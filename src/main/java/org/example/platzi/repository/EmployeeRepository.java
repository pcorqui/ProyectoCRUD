package org.example.platzi.repository;

import org.example.platzi.model.Employee;
import org.example.platzi.model.cerrar;
import org.example.platzi.util.DataBaseConnection;
import org.example.platzi.util.DataBaseConnectionPool;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeRepository implements Repository<Employee> {

    public static Map<Connection, String> map = new HashMap<>();

    private Connection myConn;

    private Connection connection = getConnectionPool();

    public EmployeeRepository(Connection connection) throws SQLException {
        this.myConn = connection;
    }

    public EmployeeRepository() throws SQLException {}

    //singleton para obtener la conexion
    public static Connection getConnection() throws SQLException{
        return DataBaseConnection.getConnection();
    }

    //
    private Connection getConnectionPool() throws SQLException {
        return DataBaseConnectionPool.getConnetion();
    }

    @Override
    public List<Employee> findAll() throws SQLException {

        List<Employee> employees = new ArrayList<>();
        try(
                Connection connection = getConnectionPool();
                Statement statement = connection.createStatement();

                ResultSet myRes = statement.executeQuery("SELECT * FROM employees")) {

            //map.put(connection, Math.random() + "");
            while (myRes.next()) {

                Employee e = createEmployee(myRes);
                employees.add(e);
            }
        }
        return employees;
    }

    private Employee createEmployee(ResultSet myRes) throws SQLException {
        Employee e = new Employee();
        e.setId(myRes.getInt("id"));
        e.setFirst_name(myRes.getString("first_name"));
        e.setPs_surname(myRes.getString("pa_surname"));
        e.setMa_surname(myRes.getString("ma_surname"));
        e.setEmail(myRes.getString("ma_surname"));
        e.setSalary(myRes.getFloat("salary"));
        return e;
    }

    @Override
    public Employee getById(Integer id) throws SQLException {
        Employee employee = null;
        try(PreparedStatement preparedStatement = myConn
                .prepareStatement("SELECT * FROM employees where id = ?")
                ){
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                createEmployee(resultSet);
            }

        }catch (SQLException e){

        }
        return employee;
    }

    @Override
    public void save(Employee employee) throws SQLException {

        try(PreparedStatement preparedStatement = myConn.prepareStatement(

                "INSERT INTO employees(first_name,pa_surname,ma_surname,email,salary, curp) values(?,?,?,?,?,?)")){

            createEmployee(preparedStatement, employee);

             preparedStatement.executeUpdate();
        }
    }

    private static void createEmployee(PreparedStatement preparedStatement, Employee e) throws SQLException {
        preparedStatement.setString(1,e.getFirst_name());
        preparedStatement.setString(2,e.getMa_surname());
        preparedStatement.setString(3,e.getPs_surname());
        preparedStatement.setString(4,e.getEmail());
        preparedStatement.setFloat(5,e.getSalary());
        preparedStatement.setString(6,e.getCurp());
        //preparedStatement.setString(6,e.getEmail());
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try(
                Statement statement = myConn.createStatement()){
            statement.execute("DELETE FROM employees WHERE id = " + id);
        }
    }
}
