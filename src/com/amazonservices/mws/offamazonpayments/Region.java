/******************************************************************************
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
 */

package com.amazonservices.mws.offamazonpayments;

public enum Region {

	DE("de"), UK("uk"), US("us"), NA("na"), JP("jp");

	private String value;

	private Region(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

}
