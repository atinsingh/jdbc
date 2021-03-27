package io.pragra.learning.jdbc_learning.dao;

import io.pragra.learning.jdbc_learning.domain.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.sql.*;

@Service
public class UserDAO {
    Connection connection;
    //jdbc:mysql:// server-name : server-port / database-name

    @PostConstruct
    public void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pragra", "appuser", "appuser");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean addUser(User user) throws SQLException {
        String sql = "INSERT INTO user_detail values (" + user.getId() +",'"
                + user.getFirstName() + "','" + user.getLastName()+"')";
        Statement statement = connection.createStatement();
        return statement.execute(sql);
    }

    public void getAndPrintUser() throws SQLException {
        String sql =  "SELECT * FROM user_detail";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            System.out.printf("Id: %d, FirstName: %s, LastName: %s\n",
                    resultSet.getInt("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name")
            );
        }

    }
}
