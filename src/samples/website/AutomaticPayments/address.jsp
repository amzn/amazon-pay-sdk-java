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
<%@include file="../config.jsp"%>
<html>
<head>
<style>
    #AmazonAddressWidget {width: 400px; height: 228px;}
</style>    
<script type='text/javascript' src='../common.js'></script>
<script type='text/javascript'>
   window.onAmazonLoginReady = function () {
       amazon.Login.setClientId('<%=clientConfig.getClientId()%>');
   }
</script>
<script type='text/javascript' src='<%=clientConfig.getWidgetURL()%>'></script>
</head>
<body>
    <div id="AmazonAddressWidget"></div>
    
    <p>Click <a id="WalletLink" href="">here</a> to go to the 
    wallet page once you have completed the signin</p>
    
    <script type='text/javascript'>
    	var session = getParameterByName('session');
        var access_token = getParameterByName('access_token');
        
        if (session == null || access_token == null) {
            alert("Missing query string parameters from request, verify that access_token & session are present");
        }

        new OffAmazonPayments.Widgets.AddressBook({
            sellerId : '<%=clientConfig.getSellerId()%>',
            displayMode : 'Edit',
            agreementType: 'BillingAgreement',
            onBillingAgreementCreate: function(billingAgreement) {
            	session = billingAgreement.getAmazonBillingAgreementId();
            	document.getElementById("WalletLink").href = 'wallet.jsp' + 
                '?session=' + session + '&access_token=' + access_token; 	
            },
            design : {
                designMode : 'responsive'
            },
            onAddressSelect : function(billingAgreement) {
            	// This is to trigger when a valid shipping address is selected
            },
            onError : function(error) {
                alert(error.getErrorCode() + ": " + error.getErrorMessage());
            }
        }).bind('AmazonAddressWidget');
    </script>
</body>
</html>
