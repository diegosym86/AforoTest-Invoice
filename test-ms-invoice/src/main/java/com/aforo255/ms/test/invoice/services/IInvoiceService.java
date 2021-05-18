package com.aforo255.ms.test.invoice.services;

import java.util.List;

import com.aforo255.ms.test.invoice.entity.Invoice;

public interface IInvoiceService {
	public List<Invoice> findAll();
	public Invoice findById (Integer id ); 
	public Invoice save (Invoice invoice);
}
