package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
public class DataBaseConnection {

    public Connection databaselink;

    public Connection getconnection(){
        String databasname="dbtest";
        String databaseuser="root";
        String databasepassword="8806kiro?";
        String url="jdbc:mysql://localhost/" + databasname;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaselink=DriverManager.getConnection(url,databaseuser,databasepassword);

        }catch (Exception e){
           e.printStackTrace();
        }

        return databaselink;
    }


}
