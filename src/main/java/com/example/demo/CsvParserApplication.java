package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.services.implementations.SaleServiceImpl;

@SpringBootApplication
public class CsvParserApplication implements CommandLineRunner{

	@Autowired
	SaleServiceImpl saleService;
	public static void main(String[] args) {
		SpringApplication.run(CsvParserApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		saleService.deleteAll();
	}

}
