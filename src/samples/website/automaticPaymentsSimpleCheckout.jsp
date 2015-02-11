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
	<form name="Order" action="AutomaticPaymentSimpleCheckoutServlet" method="get">
		<table>
			<tr>
				<td>Buyer Consented Billing Agreement Id</td>
				<td><input type="text" name="BillingAgreementId" required>
			</tr>
			<tr>
				<td>Subtotal of Each Payment</td>
				<td><input type="number" name="Subtotal" required></td>
			</tr>

			<tr>
				<td>Shipping Type</td>
				<td><input type="radio" name="ShippingType" value="1" checked>Standard
					Shipping<br> <input type="radio" name="ShippingType" value="2">Two
					Day Shipping<br> <input type="radio" name="ShippingType"
					value="3">NextDay Shipping</td>
			</tr>
			<tr>
				<td>3 payments of above amount will be performed in this example</td>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>