package com.example.demo.api;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.PaymentCard;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class CardController {

	private Map<String, PaymentCard> cards = new ConcurrentHashMap<>();
	
	@PostMapping("/payment-cards")
	public PaymentCard saveCard(@RequestBody @Validated PaymentCard data) {
		log.info("Save card with id {}.", data.getId());
		cards.put(data.getId(), data);
		return data;
	}
}
