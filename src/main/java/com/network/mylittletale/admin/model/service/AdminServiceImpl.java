package com.network.mylittletale.admin.model.service;

import com.network.mylittletale.admin.model.dao.AdminMapper;
import com.network.mylittletale.admin.model.dto.AdminMemberDTO;
import com.network.mylittletale.admin.model.dto.AdminTaleDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{

    private AdminMapper mapper;

    public AdminServiceImpl(AdminMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<AdminMemberDTO> findMemberList() {

        return mapper.findMemberList();
    }

    @Override
    public List<AdminTaleDTO> findTaleList() {
        return mapper.findTaleList();
    }

}
