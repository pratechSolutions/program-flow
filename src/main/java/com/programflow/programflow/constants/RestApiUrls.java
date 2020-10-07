package com.programflow.programflow.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestApiUrls {


    public static final String USER = "/v1/user";
    public static final String SIGNUP = "/signup";
    public static final String VERIFY = "/verify";
    public static final String RESEND_VERIFICATION = "/resendverification";
    public static final String GET_USER = "{userId}";
    public static final String GET_USERS_BY_COMPANY_ID = "companyid/{companyId}";
    public static final String ADD_NEW_USER = "/addnewuser";
    public static final String SET_USER_NEW_PASSWORD = "/setpassword/{userId}";

    public static final String LOGIN = "/v1/login";
    public static String USER_MANAGER;

    public static String NOTIFICATION_MANAGER;

    public RestApiUrls(@Value("${usermanager.url}") String USER_MANAGER,
                       @Value("${notificationmanager.url}") String NOTIFICATION_MANAGER) {
        this.USER_MANAGER = USER_MANAGER;
        this.NOTIFICATION_MANAGER = NOTIFICATION_MANAGER;
    }
}
