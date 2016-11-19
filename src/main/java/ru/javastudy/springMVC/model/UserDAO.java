package ru.javastudy.springMVC.model;

import java.util.ArrayList;

/**
 * Created by sss on 19.11.16.
 */
public interface UserDAO {

    public ArrayList<User> getAllUser();
    public int getUserAttempts(User user);
    public boolean checkUser(User user);
    public void  insertUser(User user);
    public ArrayList<StatisticsData> getStat();
    public int sunAttempts();

}
