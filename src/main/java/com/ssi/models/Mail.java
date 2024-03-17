package com.ssi.models;

public class Mail {
	private String receiptent;
	private String subject;
	private String messsage;
	public Mail() {
		super();
	}
	public Mail(String receiptent, String subject, String messsage) {
		super();
		this.receiptent = receiptent;
		this.subject = subject;
		this.messsage = messsage;
	}
	@Override
	public String toString() {
		return "Mail [receiptent=" + receiptent + ", subject=" + subject + ", messsage=" + messsage + "]";
	}
	public String getReceiptent() {
		return receiptent;
	}
	public void setReceiptent(String receiptent) {
		this.receiptent = receiptent;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMesssage() {
		return messsage;
	}
	public void setMesssage(String messsage) {
		this.messsage = messsage;
	}

}
