
<%
String login_message = (String) session.getAttribute("loginSms");
if (login_message != null) {
%>

<div class="modal text-center" tabindex="-1" role="dialog" id="myModal"
	style="text-align: center;">
	<div class="modal-dialog" role="document">
		<div class="modal-content" style="border: 1px solid #ccc;">
         <div class="modal-body" style="color: #ff0000;">
			<i class="fa fa-times-circle fa-5x text-danger" aria-hidden="true"></i>
			<p class="text-danger text-center" style="font-size: 20px;">
				Incorrect user or password</p>
		</div>
		<div class="modal-footer">
			<button type="button" class="btn btn-danger text-center"
				data-dismiss="modal">OK</button>
		</div>

	</div>
</div>
			
</div>

<script>
  var message = '<%= login_message %>';
  if(message && message.length > 0){
    $("#myModal").modal("show");
  }
</script>

<%
session.removeAttribute("loginSms");
}
%>

