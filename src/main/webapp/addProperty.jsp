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
  <title>RS Properties - Add a Property</title>
  <jsp:include page="includes/head.jsp" />
</head>

<body>
<jsp:include page="includes/navbar.jsp" />
<h2 style="text-align: center; margin-bottom: 10px;">Add a Property</h2>
<section>
  <div class="mask d-flex align-items-center h-100 gradient-custom-3" style="margin-bottom: 130px">
    <div class="container h-100">
      <div class="row d-flex justify-content-center align-items-center h-100">
        <div class="col-12 col-md-9 col-lg-7 col-xl-6">
          <div class="card" style="border-radius: 15px;">
            <div class="card-body">
              <h2 class="text-uppercase text-center mb-5">Create Listing</h2>

              <form action="addPropertyAction" method="get">

                <div class="form-outline mb-4">
                  <label class="form-label" for="form3Example1cg">Address</label>
                  <input type="text" name="address" id="form3Example1cg" class="form-control form-control-lg" required />

                </div>

                <div class="form-outline mb-4">
                  <label class="form-label" for="form3Example3cg">Price</label>
                  <input type="text" name="price" id="form3Example3cg" class="form-control form-control-lg" required/>

                </div>

                <div class="form-outline mb-4">
                  <label class="form-label" for="form3Example4cg">Description</label>
                  <input type="text" name="description" id="form3Example4cg" class="form-control form-control-lg" required/>

                </div>

                <div class="form-outline mb-4">
                  <label for="propertyType">Property Type:</label>
                  <select id="propertyType" name="propertyType" required>
                    <option value="House">House</option>
                    <option value="Apartment">Apartment</option>
                  </select>
                </div>

                <div class="form-outline mb-4">
                  <label for="availabilityType">Availability Type:</label>
                  <select id="availabilityType" name="availabilityType" required>
                    <option value="Rent">Rent</option>
                    <option value="Sale">Sale</option>
                  </select>
                </div>

                <div class="form-outline mb-4">
                  <label class="form-label" for="form3Example7cg">Bedroom Number</label>
                  <input type="text" name="bedroomNumber" id="form3Example7cg" class="form-control form-control-lg" required/>

                </div>

                <div class="form-outline mb-4">
                  <label class="form-label" for="form3Example8cg">Bathroom Number</label>
                  <input type="text" name="bathroomNumber" id="form3Example8cg" class="form-control form-control-lg" required/>

                </div>

                <div class="form-outline mb-4">
                  <label for="image">Choose a property image:</label>
                  <input type="file"
                         id="image" name="image"
                         accept="image/png, image/jpeg">
                </div>

                <div class="d-flex justify-content-center">
                  <input class="btn btn-success btn-block btn-lg gradient-custom-4" type="submit" value="Create Listing"/>
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