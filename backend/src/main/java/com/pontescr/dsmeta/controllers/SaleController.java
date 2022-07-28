package com.pontescr.dsmeta.controllers;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pontescr.dsmeta.entities.Sale;
import com.pontescr.dsmeta.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	@Autowired
	public SaleService service;
	
	@GetMapping
	public ResponseEntity<List<Sale>> findAll() {
		List<Sale> sales = service.findAll();
		return ResponseEntity.ok().body(sales);
	}
}
