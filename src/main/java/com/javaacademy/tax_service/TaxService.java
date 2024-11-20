package com.javaacademy.tax_service;

import com.javaacademy.email_starter.EmailService;
import com.javaacademy.finance_starter.FinanceService;
import com.javaacademy.tax_service.rates.CarRate;
import com.javaacademy.tax_service.tax_objects.Car;
import com.javaacademy.tax_service.tax_objects.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Налоговая служба
 */
@Component
@RequiredArgsConstructor
public class TaxService {
    private final EmailService emailService;
    private final FinanceService financeService;

    public void calculateTaxForCar(Car car, Person person) {
        BigDecimal tax = CarRate.LIGHT_CAR.getRate().multiply(BigDecimal.valueOf(car.getPower()));
        financeService.takePayment(tax, "Начисление налогов за автомобили");
        String message = "Уважаемый %s, налог за вашу машину составил %s".formatted(person.getFullName(), tax);
        emailService.sendEmail(person.getEmail(), message);
    }
}
