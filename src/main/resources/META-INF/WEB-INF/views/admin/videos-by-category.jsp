<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách Video theo Category</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">

    <h2 class="fw-bold mb-4 text-center">Danh sách Video theo Category</h2>

    <!-- Lặp qua từng Category -->
    <c:forEach var="cat" items="${categories}">
        <!-- Tiêu đề Category + Số lượng Video -->
        <h4 class="fw-bold mt-4 mb-3">
            ${cat.categoryName}
            <span class="text-muted">(${fn:length(cat.videos)} video)</span>
        </h4>

        <!-- Nếu category không có video -->
        <c:if test="${empty cat.videos}">
            <div class="alert alert-warning">Không có video trong category này</div>
        </c:if>

        <!-- Danh sách video của category -->
        <div class="row">
            <c:forEach var="v" items="${cat.videos}">
                <div class="col-md-3 mb-4">
                    <div class="card h-100 shadow-sm">
                        <!-- Poster -->
                        <img src="${pageContext.request.contextPath}/uploads/${v.poster}"
                             class="card-img-top" alt="${v.title}">

                        <!-- Nội dung -->
                        <div class="card-body">
                            <h6 class="card-title">${v.title}</h6>
                            <p class="card-text small">
                                <strong>Mã video:</strong> ${v.videoId}<br>
                                <strong>Views:</strong> ${v.views}<br>
                                <strong>Category:</strong> ${cat.categoryName}
                            </p>
                            <div class="d-flex gap-2">
                                <button class="btn btn-sm btn-outline-primary">Share (10)</button>
                                <button class="btn btn-sm btn-outline-danger">Like (10)</button>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>

        <hr>
    </c:forEach>

    <!-- Bảng tổng kết số lượng video theo Category -->
    <h3 class="fw-bold mt-5">📊 Thống kê Video theo Category</h3>
    <table class="table table-bordered table-striped mt-3">
        <thead class="table-dark">
            <tr>
                <th>Category</th>
                <th>Số lượng Video</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="cat" items="${categories}">
                <tr>
                    <td>${cat.categoryName}</td>
                    <td>${fn:length(cat.videos)}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</div>

</body>
</html>
