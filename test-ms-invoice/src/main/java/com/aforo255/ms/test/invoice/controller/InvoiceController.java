package com.aforo255.ms.test.invoice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.aforo255.ms.test.invoice.entity.Invoice;
import com.aforo255.ms.test.invoice.services.IInvoiceService;

@RestController
public class InvoiceController {
	
	@Autowired
	IInvoiceService _service;
	
	@GetMapping("invoices")
	public List<Invoice> listar() {
		return _service.findAll();
	}

	@GetMapping("/invoices/{id}")
	public Invoice detalle(@PathVariable Integer id) {

		Invoice invoice = _service.findById(id);
		return invoice;
	}

}
