<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách Video</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">

    <!-- Tiêu đề + Tìm kiếm + Nút thêm -->
    <div class="d-flex justify-content-between align-items-center mb-3">
        <h2 class="fw-bold">Danh sách Video (Admin)</h2>

        <form class="d-flex" method="get"
              action="${pageContext.request.contextPath}/admin/video/list">
            <input class="form-control me-2" type="search" name="keyword"
                   placeholder="Tìm theo tiêu đề"
                   value="${keyword}">
            <button class="btn btn-outline-success" type="submit">Search</button>
        </form>

        <a href="${pageContext.request.contextPath}/admin/video/add"
           class="btn btn-primary">+ Thêm Video</a>
    </div>

    <!-- Nếu không có dữ liệu -->
    <c:if test="${empty videos}">
        <div class="alert alert-warning text-center">Không có video nào</div>
    </c:if>

    <!-- Danh sách video -->
    <div class="row">
        <c:forEach var="v" items="${videos}">
            <div class="col-md-4 mb-4">
                <div class="card shadow-sm h-100">
                    <img src="${pageContext.request.contextPath}/uploads/${v.poster}"
                         class="card-img-top" alt="${v.title}">

                    <div class="card-body">
                        <h5 class="card-title">${v.title}</h5>
                        <p>
                            <strong>Mã video:</strong> ${v.videoId}<br>
                            <strong>Views:</strong> ${v.views}
                        </p>
                        <div class="d-flex justify-content-between">
                            <a href="${pageContext.request.contextPath}/admin/video/edit?videoId=${v.videoId}"
                               class="btn btn-warning btn-sm">Sửa</a>
                            <a href="${pageContext.request.contextPath}/admin/video/delete?videoId=${v.videoId}"
                               class="btn btn-danger btn-sm"
                               onclick="return confirm('Bạn có chắc muốn xóa video này?')">Xóa</a>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

    <!-- Phân trang -->
    <nav aria-label="Page navigation" class="mt-4">
        <ul class="pagination justify-content-center">
            <c:forEach begin="0" end="${totalPages - 1}" var="i">
                <li class="page-item ${i == currentPage ? 'active' : ''}">
                    <a class="page-link"
                       href="${pageContext.request.contextPath}/admin/video/list?page=${i}&keyword=${keyword}">
                        ${i + 1}
                    </a>
                </li>
            </c:forEach>
        </ul>
    </nav>

</div>

</body>
</html>
