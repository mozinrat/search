package com.erecyclingcorps.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.erecyclingcorps.dto.TradeOptionsDTO;

@Transactional(readOnly = true)
public interface TradeOptionsService {

    public List<TradeOptionsDTO> getTradeOptions(String program); 
}
