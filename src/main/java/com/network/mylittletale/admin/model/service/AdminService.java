package com.network.mylittletale.admin.model.service;

import com.network.mylittletale.admin.model.dto.AdminMemberDTO;
import com.network.mylittletale.admin.model.dto.AdminTaleAndChildrenDTO;

import java.util.List;

public interface AdminService {
    List<AdminMemberDTO> findMemberList();
    List<AdminTaleAndChildrenDTO> findTaleList();
}