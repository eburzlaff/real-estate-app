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
    <title>RS Properties - Request A Tour</title>
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
                            <h2 class="text-uppercase text-center mb-5">Request a Tour</h2>

                            <form>

                                <div class="form-outline mb-4">
                                    <label class="form-label" for="form3Example1cg">Name</label>
                                    <input type="text" id="form3Example1cg" class="form-control form-control-lg" />

                                </div>

                                <div class="form-outline mb-4">
                                    <label class="form-label" for="form3Example4cg">Email</label>
                                    <input type="password" id="form3Example4cg" class="form-control form-control-lg" />

                                </div>

                                <div class="form-outline mb-4">
                                    <label class="form-label" for="form3Example4cg">Phone</label>
                                    <input type="password" id="form3Example5cg" class="form-control form-control-lg" />

                                </div>

                                <div class="form-outline mb-4">
                                    <label class="form-label" for="form3Example4cg">Select Preferred Date</label>
                                    <input type="date" id="form3Example6cg" class="form-control form-control-lg" />

                                </div>

                                <div class="form-outline mb-4">
                                    <label class="form-label" for="form3Example4cg">Select Preferred Time</label>
                                    <input type="time" id="form3Example7cg" class="form-control form-control-lg" />

                                </div>

                                <div class="d-flex justify-content-center">
                                    <a href="requestTourAction"><button type="button" class="btn btn-success btn-block btn-lg gradient-custom-4">Request Tour</button></a>
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
