package model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by kunal on 26/11/17.
 */
public class Employee {
    @SerializedName("employeeid")
    private int id;
    @SerializedName("firstname")
    private String firstName;
    @SerializedName("lastname")
    private String lastName;
    @SerializedName("fullname")
    private String fullName;
    @SerializedName("badgenum")
    private int badgeNumber;
    @SerializedName("basewagerate")
    private double wageRate;
    @SerializedName("payperiods")
    private List<PayPeriod> payPeriods;

    public List<PayPeriod> getPayPeriods() {
        return payPeriods;
    }

    public void setPayPeriods(List<PayPeriod> payPeriods) {
        this.payPeriods = payPeriods;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getBadgeNumber() {
        return badgeNumber;
    }

    public void setBadgeNumber(int badgeNumber) {
        this.badgeNumber = badgeNumber;
    }

    public double getWageRate() {
        return wageRate;
    }

    public void setWageRate(double wageRate) {
        this.wageRate = wageRate;
    }
}
