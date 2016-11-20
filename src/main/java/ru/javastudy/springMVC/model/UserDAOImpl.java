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
    public User checkUser(User user) {//++
        ArrayList<User> all = getAllUser();
        User rs = null;
        for (User u:all){
            if ((u.getPassword().equals(user.getPassword()))&&(u.getName().equals(user.getName()))){
                rs =u;
            }
        }

        return rs;
    }

    @Override
    public void insertUser(User user) {
        sqlQuery = "insert into userr values(?,?,?)";
        int newId = generateId(UserDAO.USER_TABLE);
        MyTemplate.update(sqlQuery,new Object[]{newId,user.getName(),user.getPassword()});
    }

    @Override
    public void insetAttempt(int attempt, User user) {
        sqlQuery = "insert into attempt values(?,?,?)";
        int newId= generateId(UserDAO.ATTEMPT_TABLE);
        MyTemplate.update(sqlQuery,new Object[]{newId,attempt,user.getId()});
    }

    @Override
    public ArrayList<StatisticsData> getStat() {
        ArrayList<StatisticsData> data = new ArrayList<>();
        int at;
        ArrayList<User> users = getAllUser();
        for (User user:users){
            at = sunAttempts();
            StatisticsData statisticsData = new StatisticsData(user,getUserAttempts(user)/at);
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

    @Override
    public int generateId(String tableName) {
        sqlQuery = "select max(id) from "+tableName;
        int id = MyTemplate.queryForInt(sqlQuery)+1;
        return id;
    }
}
