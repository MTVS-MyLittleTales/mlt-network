package com.network.mylittletale.tale.model.dao;

import com.network.mylittletale.tale.model.dto.CutDataDTO;
import com.network.mylittletale.tale.model.dto.TaleDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TaleMapper {
    List<TaleDTO> findTaleList();

    int insertCutData(CutDataDTO cutDataDTO);

    int getCutNo();

    int getCutSequence(int taleNo);

    List<CutDataDTO> getTales(int taleNo);
}
