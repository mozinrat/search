package com.erecyclingcorps.validators;

import javax.annotation.Resource;

import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.erecyclingcorps.bean.PriorityFileUpload;
import com.erecyclingcorps.utils.Constants;

@Component
public class FileUploadValidator implements Validator {
	private MessageSourceAccessor messageSourceAccessor;

	@Resource
	public void setMessageSource(MessageSource messageSource) {
		this.messageSourceAccessor = new MessageSourceAccessor(messageSource);
	}

	public boolean supports(Class<?> clazz) {
		return FileUpload.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		PriorityFileUpload file = (PriorityFileUpload) target;
		if (file.getFile().getSize() == 0) {
			errors.rejectValue("file", "required.priorityFileUpload.file", messageSourceAccessor.getMessage("label.file.required"));
		} else if (!StringUtils.equalsIgnoreCase(StringUtils.substringAfterLast(file.getFile().getOriginalFilename(), "."), Constants.FILE_EXTENSION)) {
			errors.rejectValue("file", "type.priorityFileUpload.file", messageSourceAccessor.getMessage("label.file.size"));
		} else if (file.getFile().getSize() > Constants.CSV_FILE_SIZE) {
			errors.rejectValue("file", "size.priorityFileUpload.file", messageSourceAccessor.getMessage("label.file.format"));
		}
	}
}
