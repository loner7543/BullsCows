package ru.javastudy.springMVC.model;

import java.util.ArrayList;

/**
 * Created by sss on 19.11.16.
 */
public interface UserDAO {
    public static final String ATTEMPT_TABLE="attempt";
    public static final String USER_TABLE = "userr";

    public ArrayList<User> getAllUser();
    public int getUserAttempts(User user);
    public User checkUser(User user);
    public User  insertUser(User user);
    public void insetAttempt(int attempt,User user);
    public ArrayList<StatisticsData> getStat();
    public int sunAttempts();
    public int generateId(String tableName);

}
