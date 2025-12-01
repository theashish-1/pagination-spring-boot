package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootApplication
public class ApiDesignApplication implements CommandLineRunner {

	@Autowired
	DataSource dataSource;


	public static void main(String[] args) {
		SpringApplication.run(ApiDesignApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try(Connection connection = dataSource.getConnection()) {
			if (connection!=null && !connection.isClosed()){
				System.out.println("data base connected succesfully");
			}else{
				System.out.println("Error while connecting to DB");
			}
		}catch (Exception e){
			System.out.println("An error occured while connection to DB"+e.getMessage());
		}
	}
}
