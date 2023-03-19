
<%
String message = (String) session.getAttribute("message");
if (message == "Registration successful!") {
%>

<div class="modal text-center" tabindex="-1" role="dialog" id="myModal"
	style="text-align: center;">
	<div class="modal-dialog" role="document">
		<div class="modal-content" style="border: 1px solid #ccc;">

			<div class="modal-body" style="color: #c6ff00;">
				<i class="fa fa-check-circle fa-5x text-success" aria-hidden="true"></i>
				<p class="text-success text-center" style="font-size: 20px;">
					Successful Registration</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-success text-center"
					data-dismiss="modal">OK</button>
			</div>

		</div>
	</div>
</div>

<script>
  var message = '<%= message %>';
  if(message && message.length > 0){
    $("#myModal").modal("show");
  }
</script>

<%
session.removeAttribute("message");
}
else if (message == "Alrady register"){
%>

<div class="modal text-center" tabindex="-1" role="dialog" id="myModal"
	style="text-align: center;">
	<div class="modal-dialog" role="document">
		<div class="modal-content" style="border: 1px solid #ccc;">
         <div class="modal-body" style="color: #ff0000;">
			<i class="fa fa-times-circle fa-5x text-danger" aria-hidden="true"></i>
			<p class="text-danger text-center" style="font-size: 20px;">
				You are already registered</p>
		</div>
		<div class="modal-footer">
			<button type="button" class="btn btn-danger text-center"
				data-dismiss="modal">OK</button>
		</div>

	</div>
</div>
			
</div>

<script>
  $("#myModal").modal("show");
</script>
<%
	session.removeAttribute("message");
}
%>



