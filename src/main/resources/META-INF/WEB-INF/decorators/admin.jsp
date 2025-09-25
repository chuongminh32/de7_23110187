<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>${page.title}</title>
    ${page.head}
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="d-flex flex-column min-vh-100">

    <!-- Header -->
    <%@ include file="/commons/admin/header.jsp" %>

    <!-- Nội dung trang con -->
    <main class="flex-fill">
        <div class="container py-4">
            ${page.body}
        </div>
    </main>

    <!-- Footer -->
    <%@ include file="/commons/admin/footer.jsp" %>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
