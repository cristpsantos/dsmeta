package com.pontescr.dsmeta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pontescr.dsmeta.entities.Sale;
import com.pontescr.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	public SaleRepository repository;
	
	public List<Sale> findAll() {
		return repository.findAll();
	}
}
