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
    <title>RS Properties - Log In</title>
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
                                <h2 class="text-uppercase text-center mb-5">Log In</h2>

                                <form>

                                    <div class="form-outline mb-4">
                                        <label class="form-label" for="form3Example1cg">Username</label>
                                        <input type="text" id="form3Example1cg" class="form-control form-control-lg" />

                                    </div>

                                    <div class="form-outline mb-4">
                                        <label class="form-label" for="form3Example4cg">Password</label>
                                        <input type="password" id="form3Example4cg" class="form-control form-control-lg" />

                                    </div>

                                    <div class="d-flex justify-content-center">
                                        <a href="logInAction"><button type="button" class="btn btn-success btn-block btn-lg gradient-custom-4">Log In</button></a>
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
