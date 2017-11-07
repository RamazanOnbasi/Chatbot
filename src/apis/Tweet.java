package apis;

import java.util.HashMap;
import java.util.Map;

public class Tweet {
    private long id;
    private String text;
    private String user;
    private String timeSpan;
    private double reviewPoint;

    public Tweet(long id, String text, String user, String timeSpan, double reviewPoint) {
        this.id = id;
        this.text = text;
        this.user = user;
        this.timeSpan = timeSpan;
        this.reviewPoint = reviewPoint;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTimeSpan() {
        return timeSpan;
    }

    public void setTimeSpan(String timeSpan) {
        this.timeSpan = timeSpan;
    }

    public double getReviewPoint() {
        return reviewPoint;
    }

    public void setReviewPoint(double reviewPoint) {
        this.reviewPoint = reviewPoint;
    }

    public String serialize(){
        return id + "♦" + text + "♦" + user + "♦" + timeSpan + "♦" + reviewPoint;
    }

    public String toString() {
        return "[" + reviewPoint + "] " + user + ": " + text + " - " + timeSpan;
    }

}
