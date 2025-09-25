<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Video Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <h2 class="fw-bold mb-3">
        <c:if test="${empty video.videoId}">Thêm Video</c:if>
        <c:if test="${not empty video.videoId}">Sửa Video</c:if>
    </h2>

    <form method="post" action="${pageContext.request.contextPath}/admin/video/save"
          enctype="multipart/form-data">

        <input type="hidden" name="videoId" value="${video.videoId}">

        <div class="mb-3">
            <label class="form-label">Tiêu đề</label>
            <input type="text" class="form-control" name="title" value="${video.title}" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Mô tả</label>
            <textarea class="form-control" name="description" rows="4">${video.description}</textarea>
        </div>

        <div class="mb-3 form-check">
            <input type="checkbox" class="form-check-input" name="active"
                   <c:if test="${video.active}">checked</c:if>>
            <label class="form-check-label">Active</label>
        </div>

        <div class="mb-3">
            <label class="form-label">Poster</label>
            <input type="file" class="form-control" name="file">
            <c:if test="${not empty video.poster}">
                <img src="${pageContext.request.contextPath}/uploads/${video.poster}"
                     class="mt-2 img-thumbnail" width="120">
            </c:if>
        </div>

        <button type="submit" class="btn btn-success">Lưu</button>
        <a href="${pageContext.request.contextPath}/admin/video/list" class="btn btn-secondary">Hủy</a>
    </form>
</div>

</body>
</html>
