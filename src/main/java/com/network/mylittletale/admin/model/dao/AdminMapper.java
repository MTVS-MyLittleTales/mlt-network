package com.network.mylittletale.admin.model.dao;

import com.network.mylittletale.admin.model.dto.AdminMemberDTO;
import com.network.mylittletale.admin.model.dto.AdminTaleAndChildrenDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {

    List<AdminMemberDTO> findMemberList();

    List<AdminTaleAndChildrenDTO> findTaleList();
}
