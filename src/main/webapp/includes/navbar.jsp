<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 10/24/22
  Time: 2:42 AM
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="contentType.jsp" />
<nav class="d-flex navbar navbar-expand-lg navbar-dark bg-dark mb-5">
    <div class="container-fluid d-flex justify-content-start flex-direction: column">
        <a class="navbar-brand" href="home">RS Properties</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent" style="float: right">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0" style="margin-left: 700px">
                <li class="nav-item text-end">
                    <a class="nav-link active" aria-current="page" href="home">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="viewForSaleProperties">Buy</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="viewForRentProperties">Rent</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="viewProperties">All Properties</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="aboutUs">About Us</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="contact">Contact</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="viewMyProperties">My Properties</a>
                </li>
                <c:choose>
                    <c:when test="${empty userName}">
                        <li class="nav-item">
                            <a class="nav-link" href="logIn">Log In</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="signUp">Sign Up</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item">
                            <a class="nav-link" href="">Welcome ${userName}</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </div>
</nav>
