/*
 * TradeOptionsController.java Dec 26, 2014
 * Copyright (c)2014 HYLA Mobile, Inc.
 * U.S.A. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of eRecyclingCorps, Inc.
 * ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into with eRecyclingCorps, Inc.
 */
package com.erecyclingcorps.web.controller.v1.rest.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.erecyclingcorps.dto.ContactUsDTO;
import com.erecyclingcorps.dto.TradeOptionsDTO;
import com.erecyclingcorps.service.RequestHelpService;
import com.erecyclingcorps.service.TradeOptionsService;

/**
 * 
 * @author rverma
 *
 */

@RestController
@RequestMapping(value = "/api")
public class TradeOptionsController {

    @Autowired
    TradeOptionsService tradeService; 

    @Autowired
    RequestHelpService requestHelpService; 

    @RequestMapping(value = "/trade/precompleteopions", method = RequestMethod.GET, produces="application/json")
    @ResponseBody
    public List<TradeOptionsDTO> getTradeOptions(@RequestParam("program") String program) {
        return tradeService.getTradeOptions(program);
    }


    @RequestMapping(value = "/trade/{program}/faq-emailus", method = RequestMethod.GET,produces="application/json")
    @ResponseBody
    public ContactUsDTO getContactUsEmailWidgets(@RequestParam(defaultValue = "ATT") String program) {
        return requestHelpService.getContactUsEmailWidgets(program);
    }

}
