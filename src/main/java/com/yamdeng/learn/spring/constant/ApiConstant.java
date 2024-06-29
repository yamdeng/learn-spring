package com.yamdeng.learn.spring.constant;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ApiConstant {

    public static final String API_VERSION_PREFIX = "/api/v1";

    public static final String USER_API_PREFIX = API_VERSION_PREFIX + "/users";
    public static final String DEPT_API_PREFIX = API_VERSION_PREFIX + "/depts";
    public static final String AIRPLANE_API_PREFIX = API_VERSION_PREFIX + "/airplanes";
    public static final String FLIGHT_API_PREFIX = API_VERSION_PREFIX + "/flights";
    public static final String CODE_GROUP_API_PREFIX = API_VERSION_PREFIX + "/codegroups";
    public static final String CODE_API_PREFIX = API_VERSION_PREFIX + "/codes";
    public static final String MENU_API_PREFIX = API_VERSION_PREFIX + "/menus";
    public static final String MESSAGE_API_PREFIX = API_VERSION_PREFIX + "/messages";
    public static final String RESERVATION_API_PREFIX = API_VERSION_PREFIX + "/reservations";

}
