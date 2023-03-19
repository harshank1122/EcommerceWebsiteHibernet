<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>User Login</title>

<%@ include file="components/sms_reg.jsp"%>
<%@ include file="components/cs_js.jsp"%>

</head>

<body>
   
	<%@ include file="components/navbar.jsp"%>

	<div class="container">
		<div class="row mt-5">
			<div class="col-md-6 offset-md-3">

				<div class="card">

					<div class="card-header custom-bg">
						<h3>Login here</h3>
					</div>
					<div class="card-body">
					<%@ include file="components/sms_login.jsp"%>
						<form action="login" method="post">
							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input
									name="email" type="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter email">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input
									name="password" type="password" class="form-control" id="exampleInputPassword1"
									placeholder="Password">
							</div>
							<div class="form-check">
							</div>
							<a href="register.jsp" class="text-center d-block mb-2">if not registered click here</a>
							<div class="container text-center">
							   <button type="submit" class="btn  custom-bg custom-text">Submit</button>
							   <button type="reset" class="btn  custom-bg custom-text">Reset</button>
							</div>
						</form>
					</div>
					</div>
			</div>
		</div>
	</div>
</body>

</html>