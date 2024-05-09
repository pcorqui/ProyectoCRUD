package org.example.platzi.model;


//representa los datos de nuestros empleados
public class Employee {

    private Integer id;
    private String first_name;
    private String ps_surname;
    private String ma_surname;
    private String email;
    private Float salary;
    private String curp;


    public Employee() {
    }

    public Employee(Integer id, String first_name, String ps_surname, String ma_surname, String email, Float salary, String curp) {
        this.id = id;
        this.first_name = first_name;
        this.ps_surname = ps_surname;
        this.ma_surname = ma_surname;
        this.email = email;
        this.salary = salary;
        this.curp = curp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getPs_surname() {
        return ps_surname;
    }

    public void setPs_surname(String ps_surname) {
        this.ps_surname = ps_surname;
    }

    public String getMa_surname() {
        return ma_surname;
    }

    public void setMa_surname(String ma_surname) {
        this.ma_surname = ma_surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", ps_surname='" + ps_surname + '\'' +
                ", ma_surname='" + ma_surname + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                ", curp=" + curp +
                '}';
    }
}
