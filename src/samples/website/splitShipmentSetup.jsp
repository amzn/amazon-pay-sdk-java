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
    <form name="Order" action="SplitShipmentsSetupServlet" method="get">
        <table>
            <tr>
                <td>Amazon Order Reference Id</td>
                <td><input type="text" name="OrderReferenceId" required>
            </tr>
            <tr>
                <td>Seller Note:</td>
                <td><input type="text" name="SellerNote"></td>
            </tr>
            <tr>
                <td>Store Name:</td>
                <td><input type="text" name="StoreName"></td>
            </tr>
            <tr>
                <td>Number of shipments</td>
                <td>
                    <select name="NumberOfShipments">
                        <option value="1" selected="selected">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Submit"></td>
            </tr>
        </table>
    </form>
</body>
</html>