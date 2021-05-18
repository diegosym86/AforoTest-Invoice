package com.aforo255.ms.test.invoice.services;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aforo255.ms.test.invoice.entity.Invoice;
import com.aforo255.ms.test.invoice.entity.Transaction;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class TransactionEvents {
	
	@Autowired
	IInvoiceService _invoiceService;
	
	private Logger log = LoggerFactory.getLogger(TransactionEvents.class);
	@Autowired
	private ObjectMapper objectMapper ; 
		
	public void processTransactionEvent(ConsumerRecord<Integer, String> consumerRecord) throws JsonMappingException, JsonProcessingException {
		Transaction event = objectMapper.readValue(consumerRecord.value(), Transaction.class);
		Invoice invoice = _invoiceService.findById(event.getInvoiceId());
		if(event.getAmount() == invoice.getAmount())
		{
			log.info("Actualizando Factura N°  ***"+event.getInvoiceId()+ "***Pago Completo");
			invoice.setState(1);			
		}
		else
		{
			log.info("Actualizando Factura N°  ***"+event.getInvoiceId()+ "***Pago Diferente al valor de la factura");
			double newBalance = invoice.getAmount() - event.getAmount(); 
			invoice.setAmount(newBalance);
		}
		log.info("Actualizando Factura N°  ***"+event.getInvoiceId());
		_invoiceService.save(invoice);
	}
}



