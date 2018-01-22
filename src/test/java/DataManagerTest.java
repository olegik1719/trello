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
        Connection conn = h2.getConnection();
        Statement statement = conn.createStatement();
        statement.execute("CREATE TABLE Persons (PersonID int,LastName varchar(255),FirstName varchar(255),"
                 +" Address varchar(255), City varchar(255))");
        statement.execute("INSERT INTO Persons VALUES(1, 'HELLO', 'HELLO','HELLO','HELLO')");
        statement.execute("INSERT INTO Persons VALUES(2, 'JOHN','JOHN','JOHN','JOHN')");
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Persons");
        System.out.printf("%s",resultSet.getFetchSize());
    }
}