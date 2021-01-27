package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.models.Sale;
import com.example.demo.repositories.SaleRepository;
import com.example.demo.services.implementations.SaleServiceImpl;

@SpringBootTest
@AutoConfigureMockMvc
class CsvParserApplicationTests {
	
	@Autowired
	MockMvc mockMvc;

	@Autowired
	SaleServiceImpl saleService;
	@Autowired
	SaleRepository saleRepository;
	@Test
	void restTest() throws Exception{
		mockMvc.perform(get("/sales")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	void creatingSale() {
		Sale sale = new Sale();
		sale.setCustomerName("Kanat");
		assertThat(saleRepository.save(sale).getCustomerName()).isEqualTo(saleService.createSale(sale).getCustomerName());
		saleRepository.deleteAll();
	}
	
	@Test
	void deleteSale() {
		Sale sale = new Sale();
		sale.setCustomerName("Kanat");
		sale = saleRepository.save(sale);
		saleService.deleteSale(sale.getId());
		assertThat(saleRepository.findByCustomerNameLike("Kanat").size()).isEqualTo(0);
	}
	
	@Test
	void getAllSales() throws Exception{
		saleService.createSale(new Sale());
		Sale sale = saleService.getAllSales().get(0);
		mockMvc.perform(get("/sales/"+sale.getId())).andExpect(status().isOk());
	}
}
