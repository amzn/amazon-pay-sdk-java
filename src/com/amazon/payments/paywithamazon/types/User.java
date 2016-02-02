package com.amazon.payments.paywithamazon.types;

/**
* Represents user information as returned by the service.
*/
public final class User {
    
    private String name;
    private String email;
    private String user_id;
    
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getUserId() {
        return user_id;
    }

}
