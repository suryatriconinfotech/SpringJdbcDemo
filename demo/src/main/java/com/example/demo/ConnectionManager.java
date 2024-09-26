package com.example.demo;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionManager {
         private static final HikariDataSource dataSource;
         static {
             HikariConfig hikariConfig=new HikariConfig();
             hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/demo");
             hikariConfig.setUsername("root");
             hikariConfig.setPassword("root");
             hikariConfig.setMaximumPoolSize(10);
             dataSource=new HikariDataSource(hikariConfig);
         }
         public static Connection getConnection() throws SQLException {
              return dataSource.getConnection();
         }
         public static void closeConnection(){
             if(dataSource!=null){
                 dataSource.close();
             }
         }
}
