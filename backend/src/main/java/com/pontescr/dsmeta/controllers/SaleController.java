package com.pontescr.dsmeta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pontescr.dsmeta.entities.Sale;
import com.pontescr.dsmeta.services.SaleService;
import com.pontescr.dsmeta.services.SmsService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	@Autowired
	public SaleService service;
	
	@Autowired
	public SmsService smsService;
	
	@GetMapping
	public ResponseEntity<Page<Sale>> findAll(
			@RequestParam(value = "minDate", defaultValue = "") String minDate,
			@RequestParam(value = "maxDate", defaultValue = "") String maxDate, 
			Pageable pageable) {
		Page<Sale> sales = service.findSales(minDate, maxDate, pageable);
		return ResponseEntity.ok().body(sales);
	}
	
	@GetMapping(value = "/{id}/notification")
	public void notifySms(@PathVariable Long id) {
		smsService.sendSms(id);
	}
}
