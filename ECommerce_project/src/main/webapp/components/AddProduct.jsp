
<%
String added_pro = (String) session.getAttribute("added_pro");
if (added_pro != null) {
%>

<div class="modal text-center" tabindex="-1" role="dialog" id="myModal"
	style="text-align: center;">
	<div class="modal-dialog" role="document">
		<div class="modal-content" style="border: 1px solid #ccc;">

			<div class="modal-body" style="color: #c6ff00;">
				<i class="fa fa-check-circle fa-5x text-success" aria-hidden="true"></i>
				<p class="text-success text-center" style="font-size: 20px;">
					Product Added Successful </p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-success text-center"
					data-dismiss="modal">OK</button>
			</div>

		</div>
	</div>
</div>

<script>
  var message = '<%= added_pro %>';
  if(message && message.length > 0){
    $("#myModal").modal("show");
  }
</script>

<%
session.removeAttribute("added_pro");
}
%>

