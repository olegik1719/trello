import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;

public class DataManager {
    private ComboPooledDataSource dataSource = null;

    public ComboPooledDataSource getInstance() throws PropertyVetoException {
        if (dataSource == null){
            //create dataSource
            dataSource = new ComboPooledDataSource();
            dataSource.setDriverClass("org.h2.Driver");
            dataSource.setJdbcUrl("jdbc:h2:mem:test");
        }
        return dataSource;
    }
}
