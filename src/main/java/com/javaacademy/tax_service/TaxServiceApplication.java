package com.javaacademy.tax_service;

import com.javaacademy.email_starter.EmailConfig;
import com.javaacademy.email_starter.EmailService;
import com.javaacademy.tax_service.tax_objects.Car;
import com.javaacademy.tax_service.tax_objects.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
//@EnableAutoConfiguration(exclude = EmailConfig.class)
public class TaxServiceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(TaxServiceApplication.class, args);
		TaxService taxService = context.getBean(TaxService.class);
		Car car = new Car(120);
		Person person = new Person("Иванов Иван Иванович", "test@yandex.ru");
		taxService.calculateTaxForCar(car, person);
	}
}
