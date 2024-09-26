package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringJdbcApplication.class, args);

		try{
			Connection connection=ConnectionManager.getConnection();
			String updatedsql1="update discipline set name=? where id=?";
			PreparedStatement preparedStatement1=connection.prepareStatement(updatedsql1);
			preparedStatement1.setString(1,"Suraj");
			preparedStatement1.setInt(2,2);

			String updatedsql2="update discipline set description=? where id=?";
			PreparedStatement preparedStatement2=connection.prepareStatement(updatedsql2);
        preparedStatement2.setString(1,"Hi");
        preparedStatement2.setInt(2,1);

			boolean autocommit= connection.getAutoCommit();

				connection.setAutoCommit(false);
				preparedStatement1.executeUpdate();
				System.out.println("here1");
				preparedStatement2.executeUpdate();
				System.out.println("here2");
				connection.commit();

			connection.close();
		}
		catch(SQLException e){
           System.out.println(e.getMessage());
		}

	}

}
