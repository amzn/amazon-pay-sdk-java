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

package com.amazonservices.mws.offamazonpayments.model;

import java.util.List;

/**
 * This class contains response metadata for each MWS request.
 */
public class ResponseHeaderMetadata {
  private String requestId;
  private List<String> responseContext;
  private String timestamp;

  public ResponseHeaderMetadata() {}

  public ResponseHeaderMetadata(String requestId, List<String> responseContext, String timestamp) {
    this.requestId = requestId;
    this.responseContext = responseContext;
    this.timestamp = timestamp;
  }

  /**
   * Gets the x-mws-request-id header value.
   */
  public String getRequestId() {
    return requestId;
  }

  /**
   * Gets the x-mws-response-context header value.
   */
  public List<String> getResponseContext() {
    return responseContext;
  }

  /**
   * Gets the x-mws-timestamp header value.
   */
  public String getTimestamp() {
    return timestamp;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("requestId : " + requestId + "\n");
    sb.append("responseContext : " + responseContext + "\n");
    sb.append("timestamp : " + timestamp);
    return sb.toString();
  }
}
