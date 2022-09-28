package com.network.mylittletale.children.model.dao;

import com.network.mylittletale.children.model.dto.ChildrenDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChildrenMapper {
    ChildrenDTO hasChildren(int memberId);

    int registChildren(ChildrenDTO children);
}
