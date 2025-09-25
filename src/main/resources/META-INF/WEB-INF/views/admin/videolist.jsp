<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chi tiết Video</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" 
          rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="row">
        <!-- Poster -->
        <div class="col-md-4 text-center">
            <img src="${pageContext.request.contextPath}/uploads/${video.poster}" 
                 alt="${video.title}" class="img-fluid rounded shadow">
        </div>

        <!-- Thông tin video -->
        <div class="col-md-8">
            <h2 class="fw-bold">${video.title}</h2>
            <p><strong>Mã video:</strong> ${video.videoId}</p>
            <p><strong>Category name:</strong> ${video.category.categoryName}</p>
            <p><strong>Views:</strong> ${video.views}</p>

            <!-- Share & Like -->
            <div class="d-flex gap-3 mb-3">
                <button class="btn btn-outline-primary">
                    Share (10)
                </button>
                <button class="btn btn-outline-danger">
                    Like (10)
                </button>
            </div>

            <!-- Description -->
            <h5>Mô tả</h5>
            <p>${video.description}</p>
        </div>
    </div>
</div>

</body>
</html>
