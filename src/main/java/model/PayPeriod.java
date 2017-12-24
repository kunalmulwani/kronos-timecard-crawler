package model;

import com.google.gson.annotations.SerializedName;

import java.sql.Time;
import java.util.List;

/**
 * Created by kunal on 26/11/17.
 */
public class PayPeriod {
    @SerializedName("start_date")
    private String startDate;
    @SerializedName("end_date")
    private String endDate;
    @SerializedName("punchlist")
    private List<TimePunch> timePunches;

    private double totalHours;

    private double totalWage;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public List<TimePunch> getTimePunches() {
        return timePunches;
    }

    public void setTimePunches(List<TimePunch> timePunches) {
        this.timePunches = timePunches;
    }

    public double getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(double totalHours) {
        this.totalHours = totalHours;
    }

    public double getTotalWage() {
        return totalWage;
    }

    public void setTotalWage(double totalWage) {
        this.totalWage = totalWage;
    }
}
