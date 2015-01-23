package com.erecyclingcorps.web.controller.v1.rest.api;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erecyclingcorps.dto.AttachmentType;
import com.erecyclingcorps.exceptions.ModelImageNotFoundException;
import com.erecyclingcorps.service.ModelService;
import com.erecyclingcorps.utils.Constants;

/**
 * @author parora
 **/

@Controller
@RequestMapping(value = "/api")
public class ModelImageController {

	@Autowired
	private ModelService modelService;

	@RequestMapping(value = "/model/{modelId}/small/image", method = RequestMethod.GET, produces = "image/jpeg")
	@ResponseBody
	public byte[] getSmallModelImage(@PathVariable
	String modelId, HttpServletResponse response) throws ModelImageNotFoundException {
		response.setHeader(Constants.CacheControl, Constants.NOCACHE);
		return modelService.getModelAttachment(Long.valueOf(modelId), AttachmentType.MODEL_IMAGE_SMALL);
	}

	@RequestMapping(value = "/model/{modelId}/large/image", method = RequestMethod.GET, produces = "image/jpeg")
	@ResponseBody
	public byte[] getLargeModelImage(@PathVariable
	String modelId, HttpServletResponse response) throws ModelImageNotFoundException {
		response.setHeader(Constants.CacheControl, Constants.NOCACHE);
		return modelService.getModelAttachment(Long.valueOf(modelId), AttachmentType.MODEL_IMAGE_LARGE);
	}

}
