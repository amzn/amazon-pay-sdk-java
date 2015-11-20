
package com.amazon.payments.paywithamazon.response.ipn.model;

import com.amazon.payments.paywithamazon.response.model.Environment;
import java.util.Map;


/**
 * Abstract implementation of the notification interface encapsulates 
 * the common properties of all notifications
 */
public abstract class Notification {

    /**
     * Metadata associated with this notification
     */
    private NotificationMetaData notificationMetadata;
    private IPNMessageMetaData messageMetadata;
    
    private String notificationAsJSON;
    private Map<String,String> notificationAsMap;

    /**
     * The type of notification
     */
    private NotificationType notificationType;

    
    /** To make JaxB happy
     *  Should not be use anywhere else
     */
    public Notification() {
    }
    
    /**
     * Create a new typed notification instance
     * @param type Notification type
     */
    protected Notification(NotificationType type ) {
        this.notificationType = type;
    }
    
    /*
     * Indicates what type of notification is implementing this interface
    */
    public NotificationType getNotificationType() {
        return notificationType;
    }
    
    public NotificationMetaData getNotificationMetadata() {
        return notificationMetadata;
    }

    public void setNotificationMetadata(NotificationMetaData metadata) {
        notificationMetadata = metadata;
    }  
    
    public void setJSON(String json) {
        notificationAsJSON = json;
    }
    
    public String toJSON() {
        return notificationAsJSON;
    }
    
    public void setMap( Map<String,String> map ) {
        notificationAsMap = map;
    }
    
    public Map<String,String> toMap() {
        return notificationAsMap;
    }

    public void setMessageMetaData(IPNMessageMetaData ipnMessageMetaData) {
        messageMetadata = ipnMessageMetaData;
    }

    public IPNMessageMetaData getMessageMetadata() {
        return messageMetadata;
    }
  
    
}