package com.aforo255.ms.test.invoice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aforo255.ms.test.invoice.entity.Invoice;
import com.aforo255.ms.test.invoice.repository.InvoiceRepository;

@Service
public class InvoiceServiceImpl implements IInvoiceService{

	@Autowired
	InvoiceRepository _invoiceRepo;
	
	@Override
	public List<Invoice> findAll() {		
		return (List<Invoice>) _invoiceRepo.findAll();
	}

	@Override
	public Invoice findById(Integer id) {		
		return _invoiceRepo.findById(id).orElse(null);
	}

	@Override
	public Invoice save(Invoice invoice) {		
		return _invoiceRepo.save(invoice);
	}

}
