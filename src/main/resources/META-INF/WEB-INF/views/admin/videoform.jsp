<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${video.videoId != null ? "Sửa Video" : "Thêm Video"}</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="card shadow">
        <div class="card-header ${video.videoId != null ? 'bg-warning' : 'bg-primary text-white'}">
            <h4 class="mb-0">${video.videoId != null ? "Sửa Video" : "Thêm Video"}</h4>
        </div>
        <div class="card-body">
            <form action="${pageContext.request.contextPath}/admin/video/save" method="post" enctype="multipart/form-data">
                <c:if test="${video.videoId != null}">
                    <input type="hidden" name="videoId" value="${video.videoId}">
                </c:if>

                <div class="mb-3">
                    <label class="form-label">Tiêu đề</label>
                    <input type="text" class="form-control" name="title" value="${video.title}" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Mô tả</label>
                    <textarea class="form-control" name="description" rows="3">${video.description}</textarea>
                </div>

                <div class="mb-3">
                    <label class="form-label">Danh mục</label>
                    <select class="form-select" name="categoryId" required>
                        <c:forEach var="cat" items="${categories}">
                            <option value="${cat.categoryId}" 
                              ${video.category != null && video.category.categoryId == cat.categoryId ? "selected" : ""}>
                                ${cat.categoryName}
                            </option>
                        </c:forEach>
                    </select>
                </div>

                <div class="mb-3">
                    <label class="form-label">File Video (mp4)</label>
                    <input type="file" class="form-control" name="file">
                    <c:if test="${not empty video.poster}">
                        <p class="mt-2">File hiện tại: <span class="text-muted">${video.poster}</span></p>
                    </c:if>
                </div>

                <div class="form-check mb-3">
                    <input type="checkbox" class="form-check-input" name="active" ${video.active ? "checked" : ""}>
                    <label class="form-check-label">Active</label>
                </div>

                <button type="submit" class="btn btn-success">Lưu</button>
                <a href="${pageContext.request.contextPath}/admin/video/list" class="btn btn-secondary">Quay lại</a>
            </form>
        </div>
    </div>
</div>

</body>
</html>
