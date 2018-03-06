/**
 * Copyright 2016-2017 Amazon.com, Inc. or its affiliates. All Rights Reserved.
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


import com.amazon.pay.types.OrderReferenceStatus;
import com.amazon.pay.types.SortOrder;

import java.io.Serializable;
import java.util.EnumSet;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Container for the parameters to the ListOrderReference operation.
 */
public class ListOrderReferenceRequest extends SetMWSAuthToken implements Serializable {

    // required parameters
    private String queryId;
    private String queryIdType;

    // Optional parameters
    private XMLGregorianCalendar startTime;
    private XMLGregorianCalendar endTime;
    private SortOrder sortOrder;
    private Integer pageSize;
    private EnumSet<OrderReferenceStatus> orderReferenceStatusListFilter;

    /**
     *
     * @param queryId The Seller Order id for which OROs need to be found out.
     * @param queryIdType The queryIdType is 'SellerOrderId'.
     */
    public ListOrderReferenceRequest(String queryId, String queryIdType){
        this.queryId = queryId;
        this.queryIdType = queryIdType;
    }

    /**
     * Sets the creation start time
     * @param startTime The creation Start Time
     *
     * @return the Start Time
     */
    public ListOrderReferenceRequest setStartTime (XMLGregorianCalendar startTime){
        this.startTime = startTime;
        return this;
    }

    /**
     * Sets the creation end time
     * @param endTime The creation End Time
     *
     * @return the End Time
     */
    public ListOrderReferenceRequest setEndTime (XMLGregorianCalendar endTime){
        this.endTime = endTime;
        return this;
    }

    /**
     * Sets the manner in which the order reference IDs have to be sorted (ascending,descending).
     * @param sortOrder sort order of the order reference IDs
     *
     * @return the Sort Order
     */
    public ListOrderReferenceRequest setSortOrder (SortOrder sortOrder){
        this.sortOrder = sortOrder;
        return this;
    }

    /**
     * Sets the page size for listing order reference IDs
     * @param pageSize sets the page size to lists the order reference IDs
     *
     * @return the Page Size
     */
    public ListOrderReferenceRequest setPageSize (Integer pageSize){
        this.pageSize = pageSize;
        return this;
    }

    /**
     * Sets the filters to filter according to the status of an order (open, closed, canceled).
     * @param orderReferenceStatusListFilter sets the filter for the order status
     *
     * @return the OrderReference Filter
     */
    public ListOrderReferenceRequest setOrderReferenceStatusListFilter (EnumSet<OrderReferenceStatus> orderReferenceStatusListFilter){
        this.orderReferenceStatusListFilter = orderReferenceStatusListFilter;
        return this;
    }

    /**
     * Returns the query id
     *
     * @return queryId
     */
    public  String getQueryId() {
        return queryId;
    }

    /**
     * Returns the query id type
     *
     * @return queryIdType
     */
    public String getQueryIdType() {
        return queryIdType;
    }

    /**
     * Returns the creation start time
     *
     * @return return startTime
     */
    public XMLGregorianCalendar getStartTime() {
        return startTime;
    }

    /**
     * Returns the creation end time
     *
     * @return endTime
     */
    public XMLGregorianCalendar getEndTime() {
        return endTime;
    }

    /**
     * Returns the order in which the orders have to be sorted
     *
     * @return sortOrder
     */
    public SortOrder getSortOrder() {
        return sortOrder;
    }

    /**
     * Returns the page size
     *
     * @return pageSize
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * Returns the order reference status filter
     *
     * @return orderReferenceStatusListFilter
     */
    public EnumSet<OrderReferenceStatus> getOrderReferenceStatusListFilter() {
        return orderReferenceStatusListFilter;
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
        return "ListOrderReferenceRequest{" + "queryId=" + queryId
                + ", queryIdType=" + queryIdType
                + ", startTime=" + startTime.toString()
                + ", endTime=" + endTime.toString()
                + ", sortOrder=" + sortOrder.toString()
                + ", pageSize=" + pageSize
                + ", orderReferenceStatusListFilter=" + orderReferenceStatusListFilter.toString() + '}';
    }

}
