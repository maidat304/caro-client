package org.caro.caroclient.controller;


public class DatabaseConnection {
    public Connection databaseLink;

    public Connection getConnection(){
        String databaseName = "my1";
        String databaseUser = "root";
        String databasePassword = "123456789hg";
        String url = "jdbc:mysql://localhost:3307/" + databaseName;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
            System.out.println("Ket noi thanh cong");
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
        return databaseLink;
    }
}
