package com.erecyclingcorps.web.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.erecyclingcorps.bean.PriorityFileUpload;
import com.erecyclingcorps.service.AttributeService;
import com.erecyclingcorps.service.PrioritizationUploadService;
import com.erecyclingcorps.service.UserService;
import com.erecyclingcorps.utils.Constants;
import com.erecyclingcorps.validators.FileUploadValidator;

@Controller
public class PriorityController {
    @Autowired
    private AttributeService attributeService;
    @Autowired
    private FileUploadValidator fileUploadValidator;
    @Resource
    private PrioritizationUploadService prioritizationUploadService;
    @Autowired
    private UserService userService;
    private MessageSourceAccessor messageSourceAccessor;

    @Resource
    public void setMessageSource(MessageSource messageSource) {
        this.messageSourceAccessor = new MessageSourceAccessor(messageSource);
    }

    @RequestMapping(value = { "/home", "/" }, method = RequestMethod.GET)
    public String home(@ModelAttribute("fileUpload") PriorityFileUpload fileUpload, Map<String, Object> map) {
        map.putAll(userService.getUserProgramDataOnLoad());
        return Constants.HOME_PAGE;
    }

    @RequestMapping(value = "/getAttributes", method = RequestMethod.GET)
    public String getAttributes(@RequestParam("program") Long program, Model model) {
        model.addAttribute(Constants.PROGRAM_VALUE, program);
        model.addAttribute(Constants.ATTRIBUTE_LIST, attributeService.findAllAttributeByProgram(program));
        return Constants.ATTRIBUTE_PAGE;
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST, consumes = "multipart/form-data")
    public String uploadPriorityFile(@Valid @ModelAttribute("fileUpload") PriorityFileUpload fileUpload, BindingResult result, Map<String, Object> map,
            RedirectAttributes attributes, Principal principal) throws IOException {
        fileUploadValidator.validate(fileUpload, result);
        map.putAll(userService.getCurrentUserProgramList());
        if (result.hasErrors()) {
            map.put(Constants.ATTRIBUTE_LIST, attributeService.findAllAttributeByProgram(fileUpload.getProgram()));
            map.put(Constants.PROGRAM_VALUE, fileUpload.getProgram());
            return Constants.HOME_PAGE;
        }
        Map<String, Object> fileResult = prioritizationUploadService.createValidateFile(fileUpload);
        attributes.addFlashAttribute(Constants.PROGRAM_VALUE, fileUpload.getProgram());
        attributes.addFlashAttribute(Constants.ATTRIBUTE_LIST, attributeService.findAllAttributeByProgram(fileUpload.getProgram()));
        if ((boolean) fileResult.get("hasError")) {
            attributes.addFlashAttribute(Constants.FILE_ERROR, fileResult.get(Constants.FILE_ERROR));
        } else if ((boolean) fileResult.get("fileUploaded")) {
            attributes.addFlashAttribute(Constants.FILE_UPLOAD_SUCCESS, messageSourceAccessor.getMessage("label.file.upload.success", Locale.US));
        } else {
            attributes.addFlashAttribute(Constants.FILE_UPLOAD_FAIL, messageSourceAccessor.getMessage("label.file.upload.fail"));
        }
        return Constants.REDIRECT + Constants.HOME_PAGE;
    }

    @RequestMapping(value = "/download", method = RequestMethod.POST)
    public String saveFile(@Valid @ModelAttribute("fileUpload") PriorityFileUpload fileUpload, BindingResult result, HttpServletResponse response, RedirectAttributes attributes)
            throws IOException {
        byte[] byteArray = prioritizationUploadService.getFile(fileUpload.getAttribute(), fileUpload.getProgram());
        if (byteArray != null) {
            String attributeDesc = attributeService.findDescriptionByPK(fileUpload.getAttribute());
            response.setContentType(Constants.CSV_FILE_TYPE);
            response.setHeader("Content-Disposition", "filename=" + attributeDesc.replaceAll(" ", "") + ".csv");
            response.getOutputStream().write(byteArray);
            response.flushBuffer();
            return null;
        } else {
            attributes.addFlashAttribute(Constants.ATTRIBUTE_LIST, attributeService.findAllAttributeByProgram(fileUpload.getProgram()));
            attributes.addFlashAttribute(Constants.PROGRAM_VALUE, fileUpload.getProgram());
            attributes.addFlashAttribute(Constants.FILE_NOT_FOUND, messageSourceAccessor.getMessage("label.no.file.found"));
            return Constants.REDIRECT + Constants.HOME_PAGE;
        }
    }
}
