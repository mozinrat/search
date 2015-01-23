package com.erecyclingcorps.service;

import org.springframework.transaction.annotation.Transactional;


@Transactional(readOnly=true)
public interface CategoryService {
}
