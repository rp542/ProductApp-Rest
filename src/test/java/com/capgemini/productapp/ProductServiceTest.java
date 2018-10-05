package com.capgemini.productapp;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.capgemini.productapp.entity.Product;
import com.capgemini.productapp.repository.ProductRepository;
import com.capgemini.productapp.service.impl.ProductServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {

	private MockMvc mockMvc;
	@Mock
	private ProductRepository productRepository;

	@InjectMocks
	private ProductServiceImpl productServiceImpl;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(productServiceImpl).build();
	}

	@Test
	public void testdeleteproduct() {
		Product product = new Product(1234, "lenovo", "laptop", 2340);
		productServiceImpl.deleteProduct(product);

	}

	@Test
	public void testaddProduct() {
		Product product = new Product(1234, "lenovo", "laptop", 2340);
		when(productRepository.save(product)).thenReturn(product);
		Product addProduct = productServiceImpl.addProduct(product);
		assertEquals(1234, addProduct.getProductId());
	}

	@Test
	public void testEditProduct() {
		Product product = new Product(1234, "lenovo", "laptop", 2340);
		when(productRepository.save(product)).thenReturn(product);
		Product addProduct = productServiceImpl.addProduct(product);
		assertEquals(1234, addProduct.getProductId());
	}

}
