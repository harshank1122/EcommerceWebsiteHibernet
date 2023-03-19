<!DOCTYPE html>
<%@page import="com.ecommerce.helper.Helper"%>
<%@page import="com.ecommerce.user.Catagory"%>
<%@page import="com.ecommerce.CategoryDao"%>
<%@page import="com.ecommerce.user.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.ecommerce.ProductDao"%>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Namrata Cake Shop</title>
<link rel="stylesheet" href="css/style.css">
<%@ include file="components/cs_js.jsp"%>
</head>

<body>
	<%@ include file="components/navbar.jsp"%>

	<div class="row">

		<!-- show cat  -->
		<div class="col-md-2">
			<div class="list-group mt-4">

				<a href="index.jsp?category=all" class="list-group-item list-group-item-action active">
					All Cakes </a>
				<%
				CategoryDao categoryDao = new CategoryDao();
				List<Catagory> list = categoryDao.getCategories();
				for (Catagory catagory : list) {
				%>
				<a href="index.jsp?category=<%= catagory.getCategoryId()%>" class="list-group-item list-group-item-action"> <%=catagory.getCatagoryTitle()%></a>
				<%
				}
				%>
			</div>
		</div>
		<!-- show pro  -->
		<div class="col-md-9">
			<div class="row mt-4 ml-4">
				<div class="col-md-12">
					<div class="card-columns">

						<%
						
						String cat = request.getParameter("category");
					
						
						ProductDao pro = new ProductDao();
						List<Product> proList = null;
						
						if( cat == null){
							proList = pro.getAllProducts();
						}
						
						else if(cat.trim().equals("all")){
							proList = pro.getAllProducts();
						}

						else{
							int cid = Integer.parseInt(cat.trim());
							proList = pro.getProducts(cid);
						}
						
						for (Product product : proList) {
							String desc = product.getpDesc();
						%>
						<div class="card">
						<div class="container text-center">
							<img class="card-img-top"
								src="img/Product/<%=product.getPphoto()%>"
								style="max-height: 200px; max-width: 100; width: auto;"
								alt="Card image cap">
						</div>
							<div class="card-body">
								<h5><%=product.getPname()%></h5>
								<p class="card-text">

									<%=Helper.get10words(desc)%>
								</p>
							</div>

							<div class="card-footer text-center">
								<button class="btn  btn-success" onclick="add_to_cart(<%= product.getPid()%> , '<%= product.getPname() %>' , <%= product.getPriceAfterDis()%>)">Add to Cart</button>
								<button class="btn custom-bg text-black">
									&#8377
									<%= product.getPriceAfterDis()%>/- <span class="discount"> &#8377 <%= product.getPprice() %> , <%= product.getPdiscount() %>% off</span></button>
							</div>
						</div>
						<%
						}
						
						if (proList.size() == 0 ){
							  %>
							  <h1 style="font-size: 26px;">No Cakes in this Category</h1>
							  <%
							}
						
						
						%>


					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>