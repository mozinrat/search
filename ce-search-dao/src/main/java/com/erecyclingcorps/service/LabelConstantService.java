package com.erecyclingcorps.service;

import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface LabelConstantService {
    public String findLabelConstantByCode(String code) ;
}


