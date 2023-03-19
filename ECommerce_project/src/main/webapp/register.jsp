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
    
	<div class="container-fluid">
		<div class="row mt-5">
			<div class="col-md-4 offset-md-4">

				<div class="card ">
				<%@ include file="components/sms_reg.jsp"%>
					<div class="card-body px-5 ">
						<h3 class="text-center my-2">Sign up here</h3>

						<form action="RegisterServlet" method="post">
							<div class="form-group">
								<label for="name">User Name</label> <input type="text"
									name="name" placeholder="Enter here" class="form-control"
									id="name" aria-describedby="emailHelp">
							</div>
							<div class="form-group">
								<label for="name">User Email</label> <input type="email"
									name="email" placeholder="Enter here" class="form-control"
									id="email" aria-describedby="emailHelp">
							</div>
							<div class="form-group">
								<label for="password">Password</label> <input type="password"
									name="password" placeholder="Enter here" class="form-control"
									id="password" aria-describedby="emailHelp">
							</div>
							<div class="form-group">
								<label for="number">User Phone</label> <input type="number"
									name="number" placeholder="Enter here" class="form-control"
									id="number" aria-describedby="emailHelp">
							</div>
							<div class="form-group">
								<label for="address">User Address</label>
								<textarea style="hight: 200px" class="form-control"
									name="address" placeholder="Enter your address"></textarea>
							</div>

							<div class="container text-center">
								<button class="btn btn-outline-success">Register</button>
								<button class="btn btn-outline-warning">Reset</button>
							</div>
						</form>


					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>