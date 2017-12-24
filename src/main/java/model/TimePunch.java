package model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kunal on 26/11/17.
 */
public class TimePunch {
    @SerializedName("duration")
    private int duration;
    @SerializedName("in_datetime")
    private long inTime;
    @SerializedName("out_datetime")
    private long outTime;

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public long getInTime() {
        return inTime;
    }

    public void setInTime(long inTime) {
        this.inTime = inTime;
    }

    public long getOutTime() {
        return outTime;
    }

    public void setOutTime(long outTime) {
        this.outTime = outTime;
    }
}
