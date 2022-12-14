<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="includes/contentType.jsp" />
<html>
<head>
    <title>RS Properties</title>
    <jsp:include page="includes/head.jsp" />
</head>

<body>
    <jsp:include page="includes/navbar.jsp" />
    <h2 style="text-align: center; margin-bottom: 10px;">Popular Properties</h2>
    <div class="d-flex  justify-content-around flex-column flex-wrap flex-lg-row ">
    <c:forEach items="${properties}" var="property">

            <div class="card mx-5 my-5" style="width: 18rem;">
                <img src="data:image/jpg;base64,${property.base64Image}" class="card-img-top" alt="Property Image"/>
                <div class="card-body">
                    <h5 class="card-title">${property.address}</h5>
                    <p class="card-text">${property.description}</p>
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">Type: ${property.propertyType}</li>
                    <li class="list-group-item">For ${property.availabilityType}</li>
                </ul>
                <div class="card-body">
                    <a href="viewDetails?id=${property.id}" class="card-link"><button type="button" class="btn btn-success btn-block btn-lg gradient-custom-4">View Details</button></a>
                </div>
                <div class="card-body">
                    <c:if test="${user != null}" >
                            <c:if test="${user.getSavedProperties().contains(savedProperty)}" >
                                <a href="saveProperty?propertyId=${property.id}&action=unsave" class="card-link"><button type="button" class="btn btn-info btn-block btn-lg gradient-custom-4">Unsave</button></a>
                            </c:if>
                            <c:if test="${!user.getSavedProperties().contains(savedProperty)}" >
                                <a href="saveProperty?propertyId=${property.id}&action=save" class="card-link"><button type="button" class="btn btn-info btn-block btn-lg gradient-custom-4">Save</button></a>
                            </c:if>
                    </c:if>
                </div>
            </div>
    </c:forEach>
    </div>


    <jsp:include page="includes/footer.jsp" />
</body>
</html>
