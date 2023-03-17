package jdbc.dao;

import jdbc.entity.BaseEntity;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class GenericRepo <T extends BaseEntity>
{
    protected  Connection connection;

    protected GenericRepo(Connection connection) throws SQLException
    {
        this.connection = connection;
    }

    protected ResultSet query(String sql) throws SQLException
    {
        Statement statement = connection.createStatement();
        return statement.executeQuery(sql);
    }
    protected int dataManage(String sql) throws SQLException
    {
        Statement statement = connection.createStatement();
        return statement.executeUpdate(sql);
    }
    abstract protected T create(T entity) throws Exception;
    abstract protected boolean update(T entity) throws Exception;
    abstract protected boolean delete(Long id) throws Exception;
    abstract protected List<T> getAll() throws Exception;
    abstract protected T getById(Long id) throws Exception;
}
