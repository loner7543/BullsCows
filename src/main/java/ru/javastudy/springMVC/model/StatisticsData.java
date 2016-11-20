package ru.javastudy.springMVC.model;

/**
 * Created by sss on 19.11.16.
 */
public class StatisticsData {
    private  User user;
    private  double averageAttempt;

    public StatisticsData(User user, double averageAttempt) {
        this.user = user;
        this.averageAttempt = averageAttempt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getAverageAttempt() {
        return averageAttempt;
    }

    public void setAverageAttempt(double averageAttempt) {
        this.averageAttempt = averageAttempt;
    }

    @Override
    public String toString() {
        return "Пользователь "+user.getName()+" Число попыток"+averageAttempt;
    }
}
