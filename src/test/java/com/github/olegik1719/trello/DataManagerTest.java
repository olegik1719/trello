package com.github.olegik1719.trello;

import com.github.olegik1719.trello.DataManager;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.sql.*;

import static org.junit.Assert.*;

public class DataManagerTest {

    @Test
    public void getInstance() throws PropertyVetoException, SQLException {
        ComboPooledDataSource h2 = new DataManager().getInstance();
        assertTrue("h2 is null!",h2!=null);
        try(Connection conn = h2.getConnection();
            Statement statement = conn.createStatement()
        ){
            statement.execute("CREATE TABLE Persons (personID int,lastName varchar(255),firstName varchar(255),"
                    + " address varchar(255), city varchar(255))");
            statement.execute("INSERT INTO Persons VALUES(1, 'HELLO', 'HELLO','HELLO','HELLO')");
            statement.execute("INSERT INTO Persons VALUES(2, 'JOHN','JOHN','JOHN','JOHN')");
            try (ResultSet resultSet = statement.executeQuery("SELECT * FROM Persons")
            ) {
                while (resultSet.next()) {
                    System.out.printf("%s%n", resultSet.getString(2));
                }
            }
        }

    }
}