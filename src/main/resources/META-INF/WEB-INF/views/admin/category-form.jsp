<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Sửa Category</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="card shadow-lg">
        <div class="card-header bg-warning text-dark">
            <h4 class="mb-0"><i class="bi bi-pencil-square"></i> Sửa Category</h4>
        </div>
        <div class="card-body">
            <form action="${pageContext.request.contextPath}/admin/category/save" method="post" enctype="multipart/form-data">

                <!-- hidden ID -->
                <input type="hidden" name="categoryId" value="${category.categoryId}">

                <!-- Tên -->
                <div class="mb-3">
                    <label class="form-label fw-bold">Tên Category</label>
                    <input type="text" class="form-control" name="categoryName"
                           value="${category.categoryName}" required>
                </div>

                <!-- Mã -->
                <div class="mb-3">
                    <label class="form-label fw-bold">Mã Category</label>
                    <input type="text" class="form-control" name="categoryCode"
                           value="${category.categoryCode}">
                </div>

                <!-- Ảnh -->
                <div class="mb-3">
                    <label class="form-label fw-bold">Ảnh hiện tại</label><br>
                    <c:if test="${not empty category.images}">
                        <img src="${pageContext.request.contextPath}/image/${category.images}"
                             class="rounded border mb-2" width="150">
                    </c:if>
                    <input type="file" class="form-control" name="imgFile">
                </div>

                <!-- Trạng thái -->
                <div class="form-check mb-3">
                    <input type="checkbox" class="form-check-input" name="status"
                           ${category.status ? "checked" : ""}>
                    <label class="form-check-label fw-bold">Active</label>
                </div>

                <!-- Nút -->
                <button type="submit" class="btn btn-success">
                    <i class="bi bi-save"></i> Lưu thay đổi
                </button>
                <a href="${pageContext.request.contextPath}/admin/category/list" class="btn btn-secondary">
                    <i class="bi bi-arrow-left"></i> Quay lại
                </a>
            </form>
        </div>
    </div>
</div>

</body>
</html>
