package com.example.demo.domain;

import java.time.YearMonth;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.CreditCardNumber;

import lombok.Data;

@Data
public class PaymentCard {

	/**
	 * identifier
	 */
	@NotEmpty
	private String id;
	
	/**
	 * primary account number on card
	 */
	@NotEmpty
	@CreditCardNumber
	private String accountNumber;

	/**
	 * expiration date on card
	 */
	@NotNull
	@FutureOrPresent
	private YearMonth expirationDate;
	
	/**
	 * account holder on card
	 */
	@NotNull
	private String accountHolder;
	
}
