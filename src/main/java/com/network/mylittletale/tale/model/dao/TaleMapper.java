package com.network.mylittletale.tale.model.dao;

import com.network.mylittletale.children.model.dto.ChildrenDTO;
import com.network.mylittletale.tale.model.dto.CutDataDTO;
import com.network.mylittletale.tale.model.dto.TaleDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TaleMapper {
    int insertCutData(CutDataDTO cutDataDTO);

    int getCutNo();

    int getCutSequence(int taleNo);

    List<CutDataDTO> getTales(int taleNo);

    int updateTaleNo(Map<String, Integer> map);

    int insertTale(Map<String, Integer> childNo);

    int getTaleSequence();

    List<TaleDTO> getTaleList(int childNo);

    List<ChildrenDTO> getChildList(int memberNo);
}
