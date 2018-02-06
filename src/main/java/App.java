import business.KronosTimeCard;
import model.Constants;
import model.Employee;
import model.PayPeriod;
import model.enums.Colors;
import utils.PrintUtils;


import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
 * Created by kunal on 26/11/17.
 */
public class App {
    public static void main(String[] args) throws Exception {
        Properties prop = new Properties();
        InputStream input = null;
        input = new FileInputStream("config.prop");
        prop.load(input);
        KronosTimeCard kronosTimeCard = new KronosTimeCard(prop.getProperty("username"), prop.getProperty("password"));
        kronosTimeCard.login();
        List<Employee> employees = kronosTimeCard.getEmployeeDetails();

        for(Employee emp: employees){
            System.out.println("Employee Name:" + emp.getFullName());
            System.out.println();
            System.out.println("*************** Time Periods *****************");
            for(PayPeriod period: emp.getPayPeriods()){
                period = kronosTimeCard.getWagesForPayPeriod(emp, period);
                if(period.getTotalHours() > Constants.TIME_HOUR_THRESHOLD)
                    PrintUtils.print(String.format("From: " + period.getStartDate() + " End: " + period.getEndDate() + " Total earnings: %.2f Total Hours: %.2f" ,period.getTotalWage(), period.getTotalHours()), Colors.RED);
                else
                    System.out.printf("From: " + period.getStartDate() + " End: " + period.getEndDate() + " Total earnings: %.2f Total Hours: %.2f" ,period.getTotalWage(), period.getTotalHours());
                System.out.println();
            }
        }

        kronosTimeCard.logout();
    }
}
