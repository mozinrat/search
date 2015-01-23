package com.erecyclingcorps.dto;

import java.util.Map;

public class ContactUsDTO  extends BaseDTO {

    /**
     * 
     */
    private static final long serialVersionUID = -2207786584828351000L;
    private Map<String,String> header;
    private Map<String,Object> questions;
    private Map<String,String> comments;
    private String button;
    public Map<String, String> getHeader() {
        return header;
    }
    public void setHeader(Map<String, String> header) {
        this.header = header;
    }
    public Map<String, Object> getQuestions() {
        return questions;
    }
    public void setQuestions(Map<String, Object> questions) {
        this.questions = questions;
    }
    public Map<String, String> getComments() {
        return comments;
    }
    public void setComments(Map<String, String> comments) {
        this.comments = comments;
    }
    public String getButton() {
        return button;
    }
    public void setButton(String button) {
        this.button = button;
    }

}