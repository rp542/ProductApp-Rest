package com.capgemini.productapp;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.capgemini.productapp.controller.ProductController;
import com.capgemini.productapp.entity.Product;
import com.capgemini.productapp.service.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductControllerTest {

	private MockMvc mockMvc;
	@Mock
	private ProductService productService;
	
	@InjectMocks
	private ProductController productController;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
	}
	@Test
	public void testSddProduct() throws Exception {
		String content = "{ \"productId\": 12346,\"productName\": \"Lenovo 5\",\"productCategory\": \"computer\",\"productPrice\": 10000}";
		
		when(productService.addProduct(Mockito.isA(Product.class))).thenReturn(new Product(12346, "Lenovo 5", "computer", 10000));
			mockMvc.perform(post("/product")
//					.characterEncoding("utf-8")
			.contentType(MediaType.APPLICATION_JSON_UTF8).content(content)).andDo(print()).andExpect(jsonPath("$.productId").value(12346));
		
	}
	
	
	
}
