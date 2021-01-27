package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.models.Sale;
import com.example.demo.services.implementations.SaleServiceImpl;

@CrossOrigin
@RestController
public class SaleController {
	
	@Autowired
	private SaleServiceImpl saleService;
	
	@GetMapping("/sales")
	public ResponseEntity<List<Sale>> getAllSales(){
		return new ResponseEntity<List<Sale>>(saleService.getAllSales(),HttpStatus.OK);
	}
	
	@GetMapping("/sales/{id}")
	public ResponseEntity<Sale> getSale(@PathVariable("id") String id){
		Sale sale = saleService.getSale(id);
		if(sale!=null) {
			return new ResponseEntity<Sale>(sale,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Sale>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/sales")
	public ResponseEntity<Sale> createSale(@RequestBody Sale sale){
		return new ResponseEntity<Sale>(saleService.createSale(sale),HttpStatus.CREATED);
	}
	
	@PostMapping("/sales/file")
	public ResponseEntity<List<Sale>> createFromFile(@RequestParam("file") MultipartFile file){
		List<Sale> sales = saleService.parseFromFile(file);
		if(sales!=null) {
			return new ResponseEntity<List<Sale>>(saleService.parseFromFile(file),HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<List<Sale>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/sales/{id}")
	public ResponseEntity<Sale> updateSale(@PathVariable("id") String id,@RequestBody Sale _sale){
		Sale sale = saleService.updateSale(id,_sale);
		if(sale!=null) {
			return new ResponseEntity<Sale>(sale,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Sale>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/sales/{id}")
	public ResponseEntity<Sale> deleteSale(@PathVariable String id){
		if(saleService.deleteSale(id)) {
			return new ResponseEntity<Sale>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Sale>(HttpStatus.NOT_FOUND);
		}
	}
}
