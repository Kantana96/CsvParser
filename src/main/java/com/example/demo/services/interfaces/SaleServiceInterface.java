package com.example.demo.services.interfaces;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.models.Sale;

public interface SaleServiceInterface {
	public abstract List<Sale> getAllSales();
	public abstract List<Sale> parseFromFile(MultipartFile file);
	public abstract Sale getSale(String id);
	public abstract Sale createSale(Sale _sale);
	public abstract Sale updateSale(String id,Sale _sale);
	public abstract boolean deleteSale(String id);
	public abstract void deleteAll();
}
