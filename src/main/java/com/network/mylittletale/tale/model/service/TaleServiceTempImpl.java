/**
 * 임시 테스트 서비스 클래스
 */


package com.network.mylittletale.tale.model.service;

import com.network.mylittletale.tale.model.dao.TaleMapper;
import com.network.mylittletale.tale.model.dto.TaleDTO;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaleServiceTempImpl implements TaleService {

    private TaleMapper mapper;

    public TaleServiceTempImpl(TaleMapper mapper) {

        this.mapper = mapper;
    }

    @Override
    public List<TaleDTO> findTaleList() {
        System.out.println("TaleServiceTempImpl.findTaleList");
        return mapper.findTaleList();
    }

    @Override
    public void test() {
        System.out.println(mapper);
    }
}
