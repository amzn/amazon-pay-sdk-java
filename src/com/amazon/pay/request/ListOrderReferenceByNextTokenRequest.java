/**
 * Copyright 2017-2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazon.pay.request;

import java.io.Serializable;

/**
 * Container for the parameters to the ListOrderReferenceByNextToken operation.
 */
public class ListOrderReferenceByNextTokenRequest extends DelegateRequest<ListOrderReferenceByNextTokenRequest> implements Serializable {

    @Override
    protected ListOrderReferenceByNextTokenRequest getThis() {
        return this;
    }

    //required parameters
    private String nextPageToken;

    /**
     * Set the value of nextPageToken
     *
     * @param nextPageToken The next page token. This value is retrieved from
     *                      the ListOrderReference API when the page size parameter
     *                      is specified in the method call.
     */
    public ListOrderReferenceByNextTokenRequest(String nextPageToken){
        this.nextPageToken = nextPageToken;
    }

    /**
     * Return the value of nextPageToken
     *
     * @return nextPageToken
     */
    public String getNextPageToken() {
        return nextPageToken;
    }

    /**
     * Returns a string representation of this object; useful for testing and
     * debugging.
     *
     * @return A string representation of this object.
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ListOrderReferenceByNextTokenRequest{" + "nextPageToken=" + nextPageToken + '}';
    }

}
