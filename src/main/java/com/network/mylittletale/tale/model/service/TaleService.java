package com.network.mylittletale.tale.model.service;

import com.network.mylittletale.tale.model.dto.TaleDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TaleService {
    List<TaleDTO> findTaleList();
    void test();
}

