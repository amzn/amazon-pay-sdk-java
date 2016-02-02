package com.amazon.payments.paywithamazon.response.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "type",
    "code",
    "message",
    "detail"
})
@XmlRootElement(name = "Error")
public class Error {

    @XmlElement(name = "Type", required = true)
    protected String type;
    @XmlElement(name = "Code", required = true)
    protected String code;
    @XmlElement(name = "Message", required = true)
    protected String message;
    @XmlElement(name = "Detail", required = true)
    protected Error.Detail detail;

    /**
     * Default constructor
     * 
     */
    public Error() {
        super();
    }

    public String getType() {
        return type;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Error.Detail getDetail() {
        return detail;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "any"
    })
    public static class Detail {

        @XmlAnyElement(lax = true)
        protected List<Object> any;

        public Detail() {
            super();
        }
        
        public List<Object> getAny() {
            if (any == null) {
                any = new ArrayList<Object>();
            }
            return this.any;
        }


    }

    /**
     * String representation of error object
     * @return 
     */
    @Override
    public String toString() {
        return "Error{" + "type=" + type + ", code=" + code + ", message=" + message + ", detail=" + detail + '}';
    }
    
}
