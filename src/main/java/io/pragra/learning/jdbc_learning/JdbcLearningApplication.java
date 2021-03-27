package io.pragra.learning.jdbc_learning;

import io.pragra.learning.jdbc_learning.dao.UserDAO;
import io.pragra.learning.jdbc_learning.domain.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.SQLException;

@SpringBootApplication
public class JdbcLearningApplication {

    public static void main(String[] args) throws SQLException {
        ConfigurableApplicationContext context = SpringApplication.run(JdbcLearningApplication.class, args);

        UserDAO dao = context.getBean(UserDAO.class);

        dao.addUser(new User(1,"Navleen", "Kaur"));
        dao.getAndPrintUser();
    }

}
