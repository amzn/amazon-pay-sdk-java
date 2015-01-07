<!-- /*************************************************************************
 *  Copyright 2011 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *
 *  You may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at:
 *  http://aws.amazon.com/apache2.0
 *  This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 *  CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the
 *  specific language governing permissions and limitations under the
 *  License.
 * ****************************************************************************
 * -->
<!DOCTYPE html>
<html>
<head>
<script src='common.js'></script>
</head>
<body>
	<form name="Items" action="SplitShipmentsCheckoutServlet" method="get">
		<table>
			<%
				for (int i = 1; i <= Integer.parseInt((String) request.getSession()
						.getAttribute("NumberOfShipments")); i++) {
			%>
			<tr>
				<td>Item for shipment <%=i%>:</td>
				<td><select name="Item_<%=i%>">
						<option value="1" selected="true">TShirt</option>
						<option value="2">Short</option>
						<option value="3">Sweater</option>
						<option value="4">Blouse</option>
						<option value="5">Skirt</option>
				</select></td>
			</tr>
			<%
				}
			%>
			<tr>
                <td></td>
                <td><input type="submit" value="Submit"></td>
            </tr>
		</table>
	</form>
</body>
</html>