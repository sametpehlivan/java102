package jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection
{
    private static Connection connection;
    private String url, user, password;
    public DBConnection(String url,String user,String password) throws SQLException
    {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public Connection getConnection() throws SQLException
    {
        if (connection == null){
            connection = DriverManager.getConnection(url,user,password);
            return connection;
        }
        return connection;
    }
}
