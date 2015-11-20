package com.amazon.payments.paywithamazon.response.ipn.model;

import com.amazon.payments.paywithamazon.response.model.CaptureDetails;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * An IPN notification to indicate a change in status for 
 * a capture transaction notification.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
        "captureDetails"
})
@XmlRootElement(name="CaptureNotification")
public class CaptureNotification extends Notification   {

    /**
     * Capture details.
     */
    @XmlElement(name="CaptureDetails", required = true)
    private CaptureDetails captureDetails;

    /**
     * Creates a new instance of the capture notification.
     */
    public CaptureNotification() {
        super(NotificationType.CaptureNotification);
    }

    public CaptureNotification(final CaptureDetails details) {
        super(NotificationType.CaptureNotification);
        captureDetails = details;
    }

    /**
     * @return the details for this capture notification
     */
    public CaptureDetails getCaptureDetails() {
        return this.captureDetails;
    }
    
    
}
