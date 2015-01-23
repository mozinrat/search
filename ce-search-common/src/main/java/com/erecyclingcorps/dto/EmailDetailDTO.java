package com.erecyclingcorps.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class EmailDetailDTO  extends BaseDTO {


    /**
     * 
     */
    private static final long serialVersionUID = 8754064928838671602L;
    private String senderAddress;
	private String recipientAddress;
	private String subject;
	private String message;
	private String program;
	private Long id;
	
	public EmailDetailDTO(){
	}
	
	public EmailDetailDTO(String senderAddress, String recipientAddress, String subject,String message,String program){
	    this.message=message;
	    this.program=program;
	    this.recipientAddress=recipientAddress;
	    this.senderAddress=senderAddress;
	    this.subject=subject;
	}
	
	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
	}
    public String getSenderAddress() {
        return senderAddress;
    }
    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }
    public String getRecipientAddress() {
        return recipientAddress;
    }
    public void setRecipientAddress(String recipientAddress) {
        this.recipientAddress = recipientAddress;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
   	
}
