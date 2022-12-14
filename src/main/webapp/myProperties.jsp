<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 10/25/22
  Time: 11:40 PM
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="includes/contentType.jsp" />
<html>
<head>
    <title>RS Properties - My properties</title>
    <jsp:include page="includes/head.jsp" />
</head>

<body>
<jsp:include page="includes/navbar.jsp" />
<h2 style="text-align: center; margin-bottom: 40px;">My Saved Properties</h2>
<c:if test="${user.getSavedProperties().size() == 0}" >
    <h3 style="text-align: center;">You have not saved any properties yet!</h3>
</c:if>
<c:if test="${user.getSavedProperties().size() != 0}" >
    <table class="table align-middle mb-0 bg-white">
        <thead class="bg-light">
        <tr>
            <th>Address</th>
            <th>Price</th>
            <th>Description</th>
            <th>Type</th>
            <th>Availability</th>
            <th>Bedrooms</th>
            <th>Bathrooms</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="property" items="${user.savedProperties}">
            <tr>
                <td>${property.address}</td>
                <td>$${property.price}.00</td>
                <td>${property.description}</td>
                <td>${property.propertyType}</td>
                <td>${property.availabilityType}</td>
                <td>${property.bedroomNumber}</td>
                <td>${property.bathroomNumber}</td>
                <td>
                    <a href="viewDetailsSaved?id=${property.id}"><button type="button" class="btn btn-link btn-sm btn-rounded">View Details</button></a>
                </td>
                <td>
                    <a href="saveProperty?propertyId=${property.id}&action=unsave"><button type="button" class="btn btn-link btn-sm btn-rounded">Unsave</button></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>

<jsp:include page="includes/footer.jsp" />
</body>

</html>
