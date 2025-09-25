<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh sách Category</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="d-flex justify-content-between align-items-center mb-4">
        <h2 class="fw-bold text-primary">Danh sách Category</h2>

        <form class="d-flex" method="get" action="${pageContext.request.contextPath}/admin/category/list">
            <input class="form-control me-2" type="search" name="keyword" placeholder="🔍 Tìm theo tên"
                   value="${keyword}">
            <button class="btn btn-outline-success"><i class="bi bi-search"></i></button>
        </form>

        <a href="${pageContext.request.contextPath}/admin/category/add" class="btn btn-primary">
            <i class="bi bi-plus-lg"></i> Thêm mới
        </a>
    </div>

    <c:if test="${empty categories}">
        <div class="alert alert-warning text-center">
            <i class="bi bi-exclamation-triangle"></i> Không có Category nào.
        </div>
    </c:if>

    <c:if test="${not empty categories}">
        <div class="table-responsive shadow-sm">
            <table class="table table-bordered table-hover align-middle">
                <thead class="table-dark text-center">
                <tr>
                    <th>ID</th>
                    <th>Tên</th>
                    <th>Ảnh</th>
                    <th>Trạng thái</th>
                    <th>Tác giả</th>
                    <th>Hành động</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="c" items="${categories}">
                    <tr>
                        <td class="text-center">${c.categoryId}</td>
                        <td>${c.categoryName}</td>
                        <td class="text-center">
                            <c:choose>
                                <c:when test="${not empty c.images}">
                                    <img src="${pageContext.request.contextPath}/image/${c.images}"
                                         class="img-thumbnail" style="max-height:70px">
                                </c:when>
                                <c:otherwise><i class="text-muted">Chưa có ảnh</i></c:otherwise>
                            </c:choose>
                        </td>
                        <td class="text-center">
                            <span class="badge ${c.status ? 'bg-success' : 'bg-secondary'}">
                                ${c.status ? 'Active' : 'Inactive'}
                            </span>
                        </td>
                        <td class="text-center">
                            <c:choose>
                                <c:when test="${c.user != null}">${c.user.fullname}</c:when>
                                <c:otherwise><i class="text-muted">---</i></c:otherwise>
                            </c:choose>
                        </td>
                        <td class="text-center">
                            <a href="${pageContext.request.contextPath}/admin/category/edit?categoryId=${c.categoryId}"
                               class="btn btn-sm btn-warning me-1">
                                <i class="bi bi-pencil-square"></i> Sửa
                            </a>
                            <a href="${pageContext.request.contextPath}/admin/category/delete?categoryId=${c.categoryId}"
                               class="btn btn-sm btn-danger"
                               onclick="return confirm('Xóa category này?')">
                                <i class="bi bi-trash"></i> Xóa
                            </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

        <!-- Phân trang -->
        <c:if test="${totalPages > 1}">
            <nav class="mt-3">
                <ul class="pagination justify-content-center">
                    <c:forEach var="i" begin="0" end="${totalPages-1}">
                        <li class="page-item ${i == currentPage ? 'active' : ''}">
                            <a class="page-link" href="?page=${i}&size=5&keyword=${keyword}">${i+1}</a>
                        </li>
                    </c:forEach>
                </ul>
            </nav>
        </c:if>
    </c:if>
</div>

</body>
</html>
