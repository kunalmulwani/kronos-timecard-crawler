import business.KronosTimeCard;
import model.Constants;
import model.Employee;
import model.PayPeriod;
import model.enums.Colors;
import utils.PrintUtils;


import java.util.List;

/**
 * Created by kunal on 26/11/17.
 */
public class App {
    public static void main(String[] args) throws Exception {
        KronosTimeCard kronosTimeCard = new KronosTimeCard("username", "password");
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
                    System.out.printf("From: " + period.getStartDate() + " End: " + period.getEndDate() + " Total earnings: %.2f" ,period.getTotalWage());
                System.out.println();
            }
        }

        kronosTimeCard.logout();
    }
}
