package com.erecyclingcorps.dto;

public class ApiUserDetailDTO  extends BaseDTO {

    /**
     * 
     */
    private static final long serialVersionUID = 5140052244493851088L;

    private String apiUrl;
    private String application;
    private String apiUsername;
    private String apiPassword;
    private String program;

    public String getProgram() {
        return program;
    }
    public void setProgram(String program) {
        this.program = program;
    }
    public String getApiUrl() {
        return apiUrl;
    }
    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }
    public String getApplication() {
        return application;
    }
    public void setApplication(String application) {
        this.application = application;
    }
    public String getApiUsername() {
        return apiUsername;
    }
    public void setApiUsername(String apiUsername) {
        this.apiUsername = apiUsername;
    }
    public String getApiPassword() {
        return apiPassword;
    }
    public void setApiPassword(String apiPassword) {
        this.apiPassword = apiPassword;
    }

}
