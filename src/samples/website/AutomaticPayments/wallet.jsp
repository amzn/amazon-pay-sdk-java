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
    #AmazonWalletWidget, #AmazonConsentWidget {width: 400px; height: 228px;}
</style>	
<script type='text/javascript' src='../common.js'></script>
<script type='text/javascript'>
       window.onAmazonLoginReady = function () {
           amazon.Login.setClientId('<%=clientConfig.getClientId()%>');
       };
    </script>
<script type='text/javascript' src='<%=clientConfig.getWidgetURL()%>'></script>
</head>
<body>
	<div id='AmazonWalletWidget'></div>
	<div id='AmazonConsentWidget'></div>
	<div id="ConsentStatus"></div>
	<div id='SessionInformation'></div>
	
	<script type='text/javascript'>
		function updateConsentStatus(buyerBillingAgreementConsentStatus) {
			document.getElementById("ConsentStatus").innerHTML =
				"<p>Consent Status: " + buyerBillingAgreementConsentStatus + "</p>";
		}
		
		var session = getParameterByName('session');
		var access_token = getParameterByName('access_token');
		
		if (session == null || access_token == null) {
			alert("Missing query string parameters from request, verify that access_token & session are present");
		} else {
			document.getElementById("SessionInformation").innerHTML =
				"<p>Billing Agreement Number: " + session + "</p><p> Access Token: " + access_token + "</p>";
		}
		
		new OffAmazonPayments.Widgets.Wallet(
		{
			sellerId : '<%=clientConfig.getSellerId()%>',
			amazonBillingAgreementId : session,
			displayMode : 'Edit',
			design : {
                                 designMode : 'responsive'
                        },
			onPaymentSelect : function(billingAgreement) {
				// This is to trigger when a valid payment instrument is selected
			},
			onError : function(error) {
				alert(error.getErrorCode() + ": " + error.getMessage());
			}
		}).bind('AmazonWalletWidget');
		
		new OffAmazonPayments.Widgets.Consent({
			sellerId : '<%=clientConfig.getSellerId()%>',
			// amazonBillingAgreementId obtained from createBillingAgreement
			amazonBillingAgreementId: session,
			design : {
                                designMode : 'responsive'
                        },
			onReady: function(billingAgreementConsentStatus) {
				// Called after widget renders
				buyerBillingAgreementConsentStatus =
					billingAgreementConsentStatus.getConsentStatus();
				// getConsentStatus returns true or false
				// true - checkbox is selected
				// false - checkbox is unselected - default
				updateConsentStatus(buyerBillingAgreementConsentStatus);
			},
			onConsent: function(billingAgreementConsentStatus) {
				buyerBillingAgreementConsentStatus =
					billingAgreementConsentStatus.getConsentStatus();
				// getConsentStatus returns true or false
				// true - checkbox is selected - buyer has consented
				// false - checkbox is unselected - buyer has not consented
				// Replace this code with the action that you want to perform
				// after the consent checkbox is selected/unselected.
				updateConsentStatus(buyerBillingAgreementConsentStatus);
			},
			onError: function(error) {
				// your error handling code
			}
		}).bind("AmazonConsentWidget");
	</script>
