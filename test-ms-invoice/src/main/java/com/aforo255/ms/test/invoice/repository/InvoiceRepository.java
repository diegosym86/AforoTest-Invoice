package com.aforo255.ms.test.invoice.repository;

import org.springframework.data.repository.CrudRepository;

import com.aforo255.ms.test.invoice.entity.Invoice;

public interface InvoiceRepository extends CrudRepository<Invoice, Integer>{

}
