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
	<form name="Order" action="SimpleCheckoutServlet" method="get">
		<table>
			<tr>
				<td>Amazon Order Reference Id</td>
				<td><input type="text" name="OrderReferenceId" required>
			</tr>
			<tr>
				<td>Subtotal</td>
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
				<td>Seller Note:</td>
				<td><input type="text" name="SellerNote"></td>
			</tr>
			<tr>
				<td>Custom Note:</td>
				<td><input type="text" name="CustomNote"></td>
			</tr>
			<tr>
				<td>Store Name:</td>
				<td><input type="text" name="StoreName"></td>
			</tr>
			<tr>
		                <td>RequestPaymentAuthorization:</td>
				<td><input type="text" name="RequestPaymentAuthorization"></td>
			</tr>
			<tr>
				<td>Authorization Type:</td>
				<td><input type="radio" name="AuthorizeOption" value="1" checked>Regular 
					Authorization (Asynchronous)<br> <input type="radio" name="AuthorizeOption" 
					value="2">Fast Authorization</td>
			
			</tr>			
			<tr>
				<td>Direct Capture</td>
				<td><input type="checkbox" name="DirectCapture"></td>
			</tr>
			<tr>
				<td>Soft Descriptor</td>
				<td><input type="text" name="SoftDescriptor"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>
