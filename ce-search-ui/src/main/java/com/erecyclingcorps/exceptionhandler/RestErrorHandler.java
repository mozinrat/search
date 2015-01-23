package com.erecyclingcorps.exceptionhandler;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.HandlerMapping;

import com.erecyclingcorps.exceptions.FilterNotFoundException;
import com.erecyclingcorps.exceptions.ModelImageNotFoundException;
import com.erecyclingcorps.exceptions.ModelNotFoundException;

/**
 * @author parora
 * 
 * Contains All Rest Exception Handlers
 * 
 **/

@ControllerAdvice
public class RestErrorHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestErrorHandler.class);

    @ExceptionHandler(FilterNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error filterNotFoundException(Exception ex) {
        LOGGER.error("The Filter applied is not supported for Now");
        return new Error(ex.getMessage(),ex);
    }

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Error inputBindException(Exception ex) {
        LOGGER.error("Invalid Input");
        return new Error(ex.getMessage(),ex);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Error otherException(Exception ex) {
        LOGGER.error("Internal Error");
        return new Error(ex.getMessage(),ex);
    }

    /*
     * Post processing if Model is not found in Db.
     */
    @ExceptionHandler(ModelNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void modelNotFoundException(Exception ex) {
        LOGGER.error("Handling ModelNotFoundException exception in Global Exception handler");
    }

    /*
     * Forward to default image url if Model Image is not resent in database
     */
    @ExceptionHandler(ModelImageNotFoundException.class)
    @ResponseStatus(HttpStatus.OK)
    public String modelImageNotFoundException(Exception ex,HttpServletRequest request) {
        @SuppressWarnings("unchecked")
        Map<String,String> map = (HashMap<String,String>)request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        LOGGER.debug("No Image available for Manufacturer Model ID "+map.get("modelId"));
        LOGGER.debug("Redirecting to default no image avaialable");
        return "forward:/static/img/image-not-available.jpg";
    }


}