package com.network.mylittletale.children.model.dao;

import com.network.mylittletale.children.model.dto.ChildrenDTO;
import com.network.mylittletale.member.model.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChildrenMapper {
    ChildrenDTO hasChildren(int memberId);

    int registChildren(ChildrenDTO children);

    List<ChildrenDTO> findChildrenByMemberNo(int loginedMemberNo);
}
