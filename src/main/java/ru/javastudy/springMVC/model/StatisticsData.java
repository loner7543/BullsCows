package ru.javastudy.springMVC.model;

/**
 * Created by sss on 19.11.16.
 */
public class StatisticsData {
    private  User user;
    private  int averageAttempt;

    public StatisticsData(User user, int averageAttempt) {
        this.user = user;
        this.averageAttempt = averageAttempt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getAverageAttempt() {
        return averageAttempt;
    }

    public void setAverageAttempt(int averageAttempt) {
        this.averageAttempt = averageAttempt;
    }
}
