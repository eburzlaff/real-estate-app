<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 10/24/22
  Time: 4:51 AM
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="includes/contentType.jsp" />
<html>
<head>
    <title>RS Properties - Sign Up</title>
    <jsp:include page="includes/head.jsp" />
</head>

<body>
<jsp:include page="includes/navbar.jsp" />
<section>
    <div class="mask d-flex align-items-center h-100 gradient-custom-3">
        <div class="container h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-12 col-md-9 col-lg-7 col-xl-6">
                    <div class="card" style="border-radius: 15px;">
                        <div class="card-body">
                            <h2 class="text-uppercase text-center mb-5">Edit Profile</h2>

                            <form>

                                <div class="form-outline mb-4">
                                    <label class="form-label" for="form3Example1cg">First Name</label>
                                    <input type="text" name="firstName" id="form3Example1cg" class="form-control form-control-lg" value="${user.firstName}" />

                                </div>

                                <div class="form-outline mb-4">
                                    <label class="form-label" for="form3Example3cg">Last Name</label>
                                    <input type="text" name="lastName" id="form3Example3cg" class="form-control form-control-lg" value="${user.lastName}" />

                                </div>

                                <div class="form-outline mb-4">
                                    <label class="form-label" for="form3Example4cg">Email</label>
                                    <input type="email" name="email" id="form3Example4cg" class="form-control form-control-lg" value="${user.email}" />

                                </div>

                                <div class="d-flex justify-content-center">
                                    <a href="editProfile"><button type="button" class="btn btn-success btn-block btn-lg gradient-custom-4">Submit Changes To Your Profile</button></a>
                                </div>

                            </form>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<jsp:include page="includes/footer.jsp" />
</body>

</html>