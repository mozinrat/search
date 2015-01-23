package com.erecyclingcorps.dao;

import java.util.List;

import com.erecyclingcorps.dto.TradeOptionsDTO;


public interface TradeOptionsDAO {

    public List<TradeOptionsDTO> getTradeOptions(String program) ;
}
