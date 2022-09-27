package com.network.mylittletale.admin.model.service;

import com.network.mylittletale.admin.model.dto.AdminMemberDTO;
import com.network.mylittletale.admin.model.dto.AdminTaleDTO;

import java.util.List;

public interface AdminService {
    List<AdminMemberDTO> findMemberList();
    List<AdminTaleDTO> findTaleList();
}