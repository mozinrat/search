package com.erecyclingcorps.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erecyclingcorps.dao.TradeOptionsDAO;
import com.erecyclingcorps.dto.TradeOptionsDTO;
import com.erecyclingcorps.service.TradeOptionsService;

@Service("tradeService")
public class TradeOptionsServiceImpl implements TradeOptionsService {

    @Autowired
    TradeOptionsDAO tradeOptionsDAO;
    
    @Override
    public List<TradeOptionsDTO> getTradeOptions(String program) {
        return tradeOptionsDAO.getTradeOptions(program);
    }

}
