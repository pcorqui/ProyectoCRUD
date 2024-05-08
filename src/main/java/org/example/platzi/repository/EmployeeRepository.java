package org.example.platzi.repository;

import org.example.platzi.model.Employee;
import org.example.platzi.util.DataBaseConnection;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements Repository<Employee> {

    //singleton para obtener la conexion
    private Connection getConnection() throws SQLException{
        return DataBaseConnection.getConnection();
    }

    @Override
    public List<Employee> findAll() throws SQLException {

        List<Employee> employees = new ArrayList<>();
        try(
                Statement statement = getConnection().createStatement();
                ResultSet myRes = statement.executeQuery("SELECT * FROM employees")) {
            ;

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
        try(PreparedStatement preparedStatement = getConnection()
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
    public void save(Employee employee) {

    }

    @Override
    public void delete(Integer id) {

    }
}
