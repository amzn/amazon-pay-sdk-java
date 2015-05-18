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
    <title>Address consent example</title>
</head>
<body>
    <div>
        <h1>Address consent example</h1>
        <br />
        <p>This example shows the difference in GetOrderReferenceDetails response when 
        using the AddressConsent token field</p>
        
        <p>Enter an order reference for an order that is in the draft status,
        along with the associated access token from the buyer session</p>
    </div>
    
    <form name="Items" action="AddressConsentServlet" method="get">
        <div>
            <div>Amazon Order Reference Id <input type="text" name="OrderReferenceId" required></div>
            <div>Access Token <input type="text" name="AccessToken" required></div>
            <div><input type="submit" value="Submit"></div>
        </div>
    </form>
    
</body>
</html>
