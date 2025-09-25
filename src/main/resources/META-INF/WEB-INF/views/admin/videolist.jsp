<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Form Video</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <h3 class="mb-4 text-primary">${video.videoId == null ? "Thêm Video" : "Sửa Video"}</h3>

    <form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/admin/video/save">
        <input type="hidden" name="videoId" value="${video.videoId}"/>

        <div class="mb-3">
            <label class="form-label">Tiêu đề</label>
            <input type="text" class="form-control" name="title" value="${video.title}" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Mô tả</label>
            <textarea class="form-control" name="description">${video.description}</textarea>
        </div>

        <div class="mb-3">
            <label class="form-label">Poster</label><br>
            <c:if test="${not empty video.poster}">
                <img src="${pageContext.request.contextPath}/image/${video.poster}" width="120" class="img-thumbnail mb-2"/>
            </c:if>
            <input type="file" class="form-control" name="file">
        </div>

        <div class="mb-3 form-check">
            <input type="checkbox" class="form-check-input" name="active" ${video.active ? "checked" : ""}>
            <label class="form-check-label">Kích hoạt</label>
        </div>

        <button type="submit" class="btn btn-success">Lưu</button>
        <a href="${pageContext.request.contextPath}/admin/video/list" class="btn btn-secondary">Hủy</a>
    </form>
</div>

</body>
</html>
