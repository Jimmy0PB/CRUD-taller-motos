package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;
import util.DatebaseUtil;

public class UserDAO {
    public User getUserByUserName(String userName){
        String url = "select * from users where Name = ?";
        User user = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DatebaseUtil.getConnection();
            preparedStatement = connection.prepareStatement(url);
            preparedStatement.setString(1, userName);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                user = new User(resultSet.getString("Name"), resultSet.getString("Password"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }finally{
            DatebaseUtil.closeConnection(connection, preparedStatement, resultSet);
        }
        return user;
    }
}