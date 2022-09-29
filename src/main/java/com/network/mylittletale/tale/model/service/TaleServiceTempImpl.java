/**
 * 임시 테스트 서비스 클래스
 */


package com.network.mylittletale.tale.model.service;

import com.network.mylittletale.tale.model.dao.TaleMapper;
import com.network.mylittletale.tale.model.dto.CutDataDTO;
import com.network.mylittletale.tale.model.dto.TaleDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class TaleServiceTempImpl implements TaleService {

    private TaleMapper mapper;

    public TaleServiceTempImpl(TaleMapper mapper) {

        this.mapper = mapper;
    }

    @Override
    public void test() {
        System.out.println(mapper);
    }

    @Override
    public int insertCutData(CutDataDTO cutDataDTO) {
        return mapper.insertCutData(cutDataDTO);
    }

    @Override
    public int getCutNo() {
        return mapper.getCutNo();
    }

    @Override
    public int getCutSequence(int taleNo) {
        return mapper.getCutSequence(taleNo);
    }

    @Override
    public List<CutDataDTO> getTales(int taleNo) {
        return mapper.getTales(taleNo);
    }

    @Override
    public int updateTaleNo(Map<String, Integer> map) {
        return mapper.updateTaleNo(map);
    }

    @Override
    public int insertTale(Map<String, Integer> childNo) {
        return mapper.insertTale(childNo);
    }

    @Override
    public int getTaleSequence() {
        return mapper.getTaleSequence();
    }

    @Override
    public List<TaleDTO> getTaleList(int childNo) {
        return mapper.getTaleList(childNo);
    }
}
