package com.network.mylittletale.tale.model.service;

import com.network.mylittletale.tale.model.dto.CutDataDTO;

import java.util.List;
import java.util.Map;


public interface TaleService {

    void test();

    int insertCutData(CutDataDTO cutDataDTO);

    int getCutNo();

    int getCutSequence(int taleNo);

    List<CutDataDTO> getTales(int taleNo);

    int updateTaleNo(Map<String, Integer> map);

    int insertTale(Map<String, Integer> childNo);

    int getTaleSequence();

    List<Integer> getTaleList(int childNo);
}

