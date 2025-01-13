package com.demo.db;

import com.demo.db.entity.Customer;
import com.demo.db.repository.CustomerRepository;
import com.demo.db.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

	@Mock
	private CustomerRepository customerRepository;

	@InjectMocks
	private CustomerService customerService;

	@BeforeEach
	void beforeEach() {
		//customerRepository = mock(CustomerRepository.class);
		//customerService = new CustomerService(customerRepository);
	}

	@Test
	void create_test() {
		assertNotNull(customerRepository);
		assertNotNull(customerService);

		when(customerRepository.save(any())).thenReturn(new Customer());
		Customer customer = customerService.create(new Customer());
		assertNotNull(customer);
	}

	@Test
	void getAll_test() {
		when(customerRepository.findAll()).thenReturn(List.of());
		List<Customer> customerList = customerService.getAll();
		assertNotNull(customerList);
		assertEquals(0, customerList.size());
	}
}
