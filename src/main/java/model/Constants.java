package model;

/**
 * Created by kunal on 26/11/17.
 */
public class Constants {
    public static final String KRONOS_URL = "https://fastapps.rit.edu/kronosTimecard/login";
    public static final String EMPLOYEE_URL ="https://fastapps.rit.edu/kronosTimecard/rest/employeebyusername/{emp_username}";
    public static final String TIME_CARD_URL = "https://fastapps.rit.edu/kronosTimecard/rest/timecard/{emp_id}/{start_date}/{end_date}";
    public static final String KRONOS_LOGOUT_URL = "https://fastapps.rit.edu/kronosTimecard/logout";
    public static final int SECONDS_IN_HOUR = 3600;
    public static final int TIME_HOUR_THRESHOLD = 18;
}
