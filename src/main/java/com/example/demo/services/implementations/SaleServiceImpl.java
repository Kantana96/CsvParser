package com.example.demo.services.implementations;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.models.Sale;
import com.example.demo.repositories.SaleRepository;
import com.example.demo.services.interfaces.SaleServiceInterface;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

@Service
public class SaleServiceImpl implements SaleServiceInterface {

	@Autowired
	private SaleRepository saleRepository;
	
	@Override
	public List<Sale> getAllSales() {
		return saleRepository.findAll();
	}

	@Override
	public List<Sale> parseFromFile(MultipartFile file) {
		List<Sale> sales = null;
		if(file.isEmpty()) {
			return sales;
		}
		else {
				try {
					Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
					CsvToBean<Sale> csvToBean = new CsvToBeanBuilder<Sale>(reader)
							.withType(Sale.class)
							.withIgnoreLeadingWhiteSpace(true)
							.withThrowExceptions(false)
							.build();
					sales = csvToBean.parse();
					for (int i = 0; i < sales.size(); i++) {
						sales.set(i, createSale(sales.get(i)));
					}
				} catch (Exception e) {
					System.out.println("Error: "+e.getMessage());
				}
		return sales;
		}
	}
	
	@Override
	public Sale getSale(String id) {
		Optional<Sale> saleOptional = saleRepository.findById(id);
		if(saleOptional.isPresent()) {
			return saleOptional.get();
		}
		else {
			return null;
		}
	}

	@Override
	public Sale createSale(Sale _sale) {
		_sale.setId(null);
		return saleRepository.save(_sale);
	}

	@Override
	public Sale updateSale(String id,Sale _sale) {
		Optional<Sale> saleOptional = saleRepository.findById(id);
		if(saleOptional.isPresent()) {
			_sale.setId(saleOptional.get().getId());
			return saleRepository.save(_sale);
		}
		else {
			return null;
		}
	}

	@Override
	public boolean deleteSale(String id) {
		if(saleRepository.findById(id).isPresent()) {
			saleRepository.deleteById(id);
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public void deleteAll() {
		saleRepository.deleteAll();
	}
}
