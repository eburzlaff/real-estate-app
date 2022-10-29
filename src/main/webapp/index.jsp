<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="includes/contentType.jsp" />
<html>
<head>
    <title>RS Properties</title>
    <jsp:include page="includes/head.jsp" />
</head>

<body>
    <jsp:include page="includes/navbar.jsp" />
    <h2>Popular Properties</h2>
    <c:forEach items="${properties}" var="property">
        <div class="card" style="width: 18rem;">
            <img src="..." class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title">${property.address}</h5>
                <p class="card-text">${property.description}</p>
            </div>
            <ul class="list-group list-group-flush">
                <li class="list-group-item">${property.price}</li>
                <li class="list-group-item">Number of Bedrooms</li>
            </ul>
        </div>
    </c:forEach>

    <jsp:include page="includes/footer.jsp" />
</body>
</html>
