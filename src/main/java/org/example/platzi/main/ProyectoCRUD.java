package org.example.platzi.main;

import org.example.platzi.model.Employee;
import org.example.platzi.repository.EmployeeRepository;
import org.example.platzi.repository.Repository;
import org.example.platzi.util.DataBaseConnection;
import org.example.platzi.util.DataBaseConnectionPool;

import java.net.ResponseCache;
import java.sql.*;

public class ProyectoCRUD {
    public static void main(String[] args) throws SQLException {

        Connection connection = DataBaseConnection.getConnection();

        //al colocar en false el autocommit se elimina el commit automatico
        //a la base de datos.
        if(connection.getAutoCommit()){
            connection.setAutoCommit(false);
        }

        try{
            Repository<Employee> repository = new EmployeeRepository(
                    connection
            );

            Repository<Employee> repositoryTwo = new EmployeeRepository();


            repositoryTwo.findAll().forEach(System.out::println);
            repositoryTwo.findAll().forEach(System.out::println);
            repositoryTwo.findAll().forEach(System.out::println);
            repositoryTwo.findAll().forEach(System.out::println);
            repositoryTwo.findAll().forEach(System.out::println);
            repositoryTwo.findAll().forEach(System.out::println);
            //repository.findAll().forEach(System.out::println);
            System.out.println("conexion" + EmployeeRepository.map.get(DataBaseConnectionPool.getConnetion()));
            //insertar un nuevo
//            Employee e = new Employee();
//            e.setFirst_name("paul");
//            e.setPs_surname("cortes");
//            e.setMa_surname("quijano");
//            e.setSalary(25000.0f);
//            e.setEmail("pcorquidev@gmail.com");
//            e.setCurp("abc12345890abcdefb");
//            repository.save(e);
//            connection.commit();

        }catch (SQLException sqlException){
            connection.rollback();
            System.out.println("msj: " + sqlException.getMessage());
            System.out.println("Algo salio mal");
        }

        //eliminar usuario
        //repository.delete(6);
    }
}
