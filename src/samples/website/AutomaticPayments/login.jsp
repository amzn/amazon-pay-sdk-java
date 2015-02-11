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
	<script type='text/javascript' src='../common.js'></script>
	<script type='text/javascript'>
	   window.onAmazonLoginReady = function () {
		   amazon.Login.setClientId('<%=clientConfig.getClientId()%>');
	   };
	</script>
	<script type='text/javascript' src='<%=clientConfig.getWidgetURL()%>'></script>
</head>
<body>
	<div id='AmazonPayButton'></div>
	<script type='text/javascript'>
		OffAmazonPayments.Button("AmazonPayButton", "<%=clientConfig.getSellerId()%>", {
			type: "PwA",
			useAmazonAddressBook: true,
			agreementType: 'BillingAgreement',
			authorization: function() {
				var path = location.pathname.replace(/[^\/]+.jsp/, "address.jsp");
				amazon.Login.authorize({scope: "profile payments:widget payments:shipping_address"}, "https://" + location.host + path);        
           },
           onError: function(error) {
                alert(error.getErrorCode() + ": " + error.getMessage());
           }
		});
	</script>
</body>
</html>