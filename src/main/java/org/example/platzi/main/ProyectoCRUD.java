package org.example.platzi.main;

import org.example.platzi.util.DataBaseConnection;

import java.sql.*;

public class ProyectoCRUD {
    public static void main(String[] args) {


        PreparedStatement preparedStatement = null;

        String user = "root";
        String pass = "admin";
        String url = "jdbc:mysql://localhost:3306/project";


        //myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","admin");
        try(Connection myConn = DataBaseConnection.getConnection();
            Statement myStamt = myConn.createStatement();
            ResultSet myrest = null;
        ){
            System.out.println("Genial, nos conectamos");

            //myStamt = myConn.createStatement();
//            myrest = myStamt.executeQuery("SELECT * FROM employees");
//
//            while(myrest.next()){
//                System.out.println(myrest.getString("first_name"));
//            }

            String sql = ("INSERT INTO employees (first_name, pa_surname) VALUES (?,?)");
            preparedStatement = myConn.prepareStatement(sql);
            preparedStatement.setString(1,"Paul");
            preparedStatement.setString(2,"Cortes");

            int rowAffected = 0;//preparedStatement.executeUpdate();

            if(rowAffected> 0){
                System.out.println("Se ha creado un nuevo empleado");
            }

            //actualizar
//            rowAffected = preparedStatement.executeUpdate("UPDATE employees set first_name='paulo' where id = 7");
//            if(rowAffected>1){
//                System.out.println("dato actualizado");
//            }

            //borrar
            myStamt.executeUpdate("Delete from employees where first_name = 'Paul'");

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Algo salio mal ):");
        }


    }
}
