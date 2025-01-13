package com.demo.db;

import com.demo.db.entity.Customer;
import com.demo.db.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class App implements CommandLineRunner {

	private CustomerService customerService;

	public App(CustomerService customerService) {
		this.customerService = customerService;
	}

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("running ...");

		customerService.getAll().forEach(customer -> log.info("Customer: {}", customer));

		//obtenemos el último registro y extraemos el id, le sumamos uno y nos inventamos un nombre para llamar a customerService.create
		//y pasarle esos dos parámetros
		//generamos una cadena aleatoria para el nombre
		//En caso de no obtener ningún registro el id será 1
		Long id = customerService.getAll().stream().mapToLong(Customer::getId).max().orElse(0) + 1;
		String name = "Customer" + id;

		customerService.create(new Customer(id, name));
	}
}
