package ru.javastudy.springMVC.model;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.jws.soap.SOAPBinding;
import javax.sql.DataSource;
import java.util.ArrayList;

/**
 * Created by sss on 19.11.16.
 */
public class UserDAOImpl implements UserDAO {

    private DataSource dataSource;
    private String sqlQuery;
    private JdbcTemplate MyTemplate;

    public UserDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
        MyTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public ArrayList<User> getAllUser() {  //++
        sqlQuery = "SELECT *FROM public.userr";
        ArrayList<User> users = (ArrayList<User>) MyTemplate.query(sqlQuery,new UserMapper());
        return users;
    }

    @Override
    public int getUserAttempts(User user) {    //++
        sqlQuery = "select sum(att_count) from attempt where user_id=?";
        int count = MyTemplate.queryForInt(sqlQuery,new Object[]{user.getId()});
        return count;
    }

    @Override
    public boolean checkUser(User user) {
        ArrayList<User> all = getAllUser();
        boolean rs = false;
        for (User u:all){
            if ((u.getPassword()==user.getPassword())&&(u.getName()==user.getName())){
                rs =  true;
            }
            else rs = false;
        }

        return rs;
    }

    @Override
    public void insertUser(User user) {
        sqlQuery = "insert into userr values(?,?,?)";
        MyTemplate.update(sqlQuery,new Object[]{user.getId(),user.getName(),user.getPassword()});
    }

    @Override
    public ArrayList<StatisticsData> getStat() {
        ArrayList<StatisticsData> data = new ArrayList<>();
        int at;
        ArrayList<User> users = getAllUser();
        for (User user:users){
            at = sunAttempts();
            StatisticsData statisticsData = new StatisticsData(user,getUserAttempts(user)/sunAttempts());
            data.add(statisticsData);
        }

        return data;

    }

    @Override
    public int sunAttempts() {
        sqlQuery = "select sum(att_count) from attempt";
        int s = MyTemplate.queryForInt(sqlQuery);
        return s;
    }
}
