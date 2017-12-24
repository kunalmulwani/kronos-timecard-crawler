package business;

import com.google.gson.Gson;
import model.*;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import utils.StringUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kunal on 26/11/17.
 */
public class KronosTimeCard {
    private Map<String, String> cookies;
    private Gson gson;
    private String username;
    private String password;

    public KronosTimeCard(String username, String password){
        this.username = username;
        this.password = password;
        cookies = new HashMap<String, String>();
        gson = new Gson();
    }

    public void login() throws IOException{
        Connection.Response loginForm = Jsoup.connect(Constants.KRONOS_URL)
                .method(Connection.Method.GET)
                .execute();

        Connection.Response res = Jsoup.connect(Constants.KRONOS_URL)
                .data("username", this.username)
                .data("password", this.password)
                .cookies(loginForm.cookies())
                .method(Connection.Method.POST)
                .execute();

        cookies = res.cookies();
    }

    public boolean isLoggedIn(){
        return cookies != null && cookies.size() > 0;
    }

    public List<Employee> getEmployeeDetails() throws IOException{
        if(!isLoggedIn()){
            System.out.println("Unauthorized Access");
            return null;
        }
        Connection.Response empResponse = Jsoup.connect(StringUtils.replaceTag("emp_username", this.username, Constants.EMPLOYEE_URL))
                .cookies(cookies)
                .method(Connection.Method.GET)
                .execute();
        EmployeeResponse response = gson.fromJson(empResponse.body(), EmployeeResponse.class);
        return response.getList();
    }

    public PayPeriod getWagesForPayPeriod(Employee employee, PayPeriod payPeriod) throws Exception{
        if(!isLoggedIn()){
            System.out.println("Unauthorized Access");
            return null;
        }
        Map<String, String> tags = new HashMap<String, String>();
        tags.put("emp_id", employee.getId()+"");
        tags.put("start_date", payPeriod.getStartDate());
        tags.put("end_date", payPeriod.getEndDate());
        Connection.Response timeCard = Jsoup.connect(StringUtils.replaceTags(tags, Constants.TIME_CARD_URL))
                .cookies(this.cookies)
                .method(Connection.Method.GET)
                .execute();

        PayPeriod respPeriod = gson.fromJson(timeCard.body(), PayPeriod.class);

        double totalDuration = 0;
        for(TimePunch punch : respPeriod.getTimePunches())
            totalDuration += punch.getDuration();

        payPeriod.setTimePunches(payPeriod.getTimePunches());
        payPeriod.setTotalHours(totalDuration/(Constants.SECONDS_IN_HOUR));
        payPeriod.setTotalWage(payPeriod.getTotalHours() * employee.getWageRate());
        return payPeriod;
    }

    public void logout() throws Exception{
        if(!isLoggedIn()){
            System.out.println("Unauthorized Access");
            return;
        }
        Connection.Response response = Jsoup.connect(Constants.KRONOS_LOGOUT_URL)
                .cookies(this.cookies)
                .method(Connection.Method.POST)
                .execute();
    }

}
