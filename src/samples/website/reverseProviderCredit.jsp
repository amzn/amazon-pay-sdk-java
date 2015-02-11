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
	<form name="ReverseProviderCredit" action="ReverseProviderCreditServlet" method="get">
	   <table>
            <tr>
                <td>Amazon Provider Credit Id</td>
                <td><input type="text" name="ProviderCreditId" required></td>
            </tr>
            <tr>
                <td>Credit Reversal Amount</td>
                <td><input type="number" name="CreditReversalAmount" required></td>
            </tr>
            
            <tr>
                <td>Credit Reversal Note:</td>
                <td><input type="text" name="CreditReversalNote"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Submit"></td>
            </tr>
	   </table>
	</form>
</body>
</html>