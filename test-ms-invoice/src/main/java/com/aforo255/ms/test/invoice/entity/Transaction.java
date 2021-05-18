package com.aforo255.ms.test.invoice.entity;

import java.io.Serializable;

public class Transaction  implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id ; 
	private double amount ;
	private int invoiceId;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}


