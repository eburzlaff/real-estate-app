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
    <title>RS Properties - View Profile</title>
    <jsp:include page="includes/head.jsp" />
</head>

<body>
<jsp:include page="includes/navbar.jsp" />
<h2 style="text-align: center; margin-bottom: 10px;">View Profile</h2>
<section">
    <div class="container py-5">
        <div class="row d-flex justify-content-center align-items-center">
            <div class="col-md-12 col-xl-4">

                <div class="card" style="border-radius: 15px;">
                    <div class="card-body text-center">
                        <h4 class="mb-2">Full Name: ${user.firstName} ${user.lastName}</h4><br>
                        <h4 class="mb-2">Your Username: ${user.userName}</h4><br>
                        <h4 class="mb-2">Email: ${user.email}</h4><br>
                        <a href="editProfile">
                            <button type="button" class="btn btn-success btn-block btn-lg gradient-custom-4">
                                Edit Profile
                            </button>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<jsp:include page="includes/footer.jsp" />
</body>

</html>
