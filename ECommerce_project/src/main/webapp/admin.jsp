<%@page import="java.util.List"%>
<%@page import="com.ecommerce.user.Catagory"%>
<%@page import="com.ecommerce.CategoryDao"%>
<%@page import="com.ecommerce.user.User"%>

<%
User user = (User) session.getAttribute("current-user");
if (user == null) {
	response.sendRedirect("login.jsp");
	return;
} else {

	if (user.getUserType().equals("normal")) {
		response.sendRedirect("Welcome.jsp");
	}
}
%>


<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>New User</title>
<%@ include file="components/cs_js.jsp"%>


</head>

<body>

	<%@ include file="components/navbar.jsp"%>
	<%@ include file="components/AddCategory.jsp"%>
	<%@ include file="components/AddProduct.jsp"%>

	<div class="container admin">
		<div class="row mt-5">

			<!--  first box   -->
			<div class=col-md-4>
				<div class="card">
					<div class="card-body text-center">
						<div class=container>
							<img style="max-width: 125px;" class="img-fluid rounded-circle"
								src="img/man.png">
						</div>
						<h1>5</h1>
						<h1 class="text-uppercase text-muted">User</h1>
					</div>
				</div>
			</div>

			<!--  second box   -->
			<div class=col-md-4>
				<div class="card">
					<div class="card-body text-center">
						<div class=container>
							<img style="max-width: 125px;" class="img-fluid rounded-circle"
								src="img/categories.png">
						</div>
						<h1>10</h1>
						<h1 class="text-uppercase text-muted">Categories</h1>
					</div>
				</div>
			</div>

			<!--  third box   -->
			<div class=col-md-4>
				<div class="card">
					<div class="card-body text-center">
						<div class=container>
							<img style="max-width: 125px;" class="img-fluid rounded-circle"
								src="img/cake.png">
						</div>
						<h1>500</h1>
						<h1 class="text-uppercase text-muted">Cakes</h1>
					</div>
				</div>
			</div>
		</div>

		<div class="row mt-3">
			<div class="col-md-6">
				<div class="card" data-toggle="modal" data-target="#myModal3">
					<div class="card-body text-center">
						<div class=container>
							<img style="max-width: 125px;" class="img-fluid rounded-circle"
								src="img/add-file.png">
						</div>
						<p class="mt-2">Click here to add new category
						<p>
						<h1 class="text-uppercase text-muted">add category</h1>
					</div>
				</div>
			</div>

			<div class="col-md-6">
				<div class="card" data-toggle="modal" data-target="#add_product">
					<div class="card-body text-center">
						<div class=container>
							<img style="max-width: 125px;" class="img-fluid rounded-circle"
								src="img/add.png">
						</div>
						<p class="mt-2">Click here to add new cake</p>
						<h1 class="text-uppercase text-muted">Add Cakes</h1>
					</div>
				</div>
			</div>
		</div>
	</div>

	<link rel="stylesheet"
		href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
		integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
		crossorigin="anonymous">


	<!-- Modal -->
	<div class="modal fade" id="myModal3" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header custom-bg ">
					<h5 class="modal-title" id="myModalLabel">Fill Category
						details</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form action="ProductOperationServlet" method="post">
						<input type="hidden" name="operation" value="addcategory">
						<div class="form-group">
							<input type="text" class="form-control" name="catTitel"
								placeholder="Enter category title" required />
						</div>
						<div class="form-group">
							<textarea style="height: 300px;" class="form-control"
								placeholder="Enter category description" name="catDiscription"
								required></textarea>
						</div>
						<div class="container text-center">
							<button class="btn btn-outline-success">Add Category</button>
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="add_product" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header custom-bg">
					<h5 class="modal-title" id="exampleModalLabel">Product details</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form action="ProductOperationServlet" method="post" enctype="multipart/form-data">
					<input type="hidden" name="operation" value="addproduct" >
						<!-- product title -->
						<div class="form-group">
							<input type="text" class="form-control" required
								placeholder="Enter title of product" name="pName">
						</div>
						<div class="form-group">
							<textarea style="height: 150px;" class="form-control"
								placeholder="Enter Product Description" name="pDescription"
								required></textarea>
						</div>
						<div class="form-group">
							<input type="number" class="form-control" required
								placeholder="Enter Price of Product" name="pPrice">
						</div>
						<div class="form-group">
							<input type="number" class="form-control" required
								placeholder="Enter Product Discount" name="pDis">
						</div>
						<div class="form-group">
							<input type="number" class="form-control" required
								placeholder="Enter Product Quantity" name="pQuantity">
						</div>

						<!-- product Category -->
						
						<%
						 
						CategoryDao categoryDao = new CategoryDao();
						List<Catagory> list = categoryDao.getCategories();
						
						%>

						<div class="form-group">
							<select name="catId" class="form-control" id="">
							
							<%
							for(Catagory c : list){
							%>
								<option value="<%= c.getCategoryId()%>"><%= c.getCatagoryTitle()%></option>
							<%
							}
							%>
							
							
							</select>
						</div>

						<!-- product file -->

						<div class="form-group">
							<label for="">Select Picture of product</label> <input
								type="file" name="pPice" required>
						</div>

						<div class="container text-center">
							<button class="btn btn-outline-success">Add Category</button>
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>



</body>

</html>