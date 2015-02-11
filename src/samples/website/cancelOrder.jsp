<!DOCTYPE html>
<html>

<head>
<script src='common.js'></script>
</script>

</head>
<body>
	<form name="Order" action="OrderCancellationServlet" method="get">
		<table>
			<tr>
				<td>Amazon Order Reference Id</td>
				<td><input type="text" name="OrderReferenceId" required>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>