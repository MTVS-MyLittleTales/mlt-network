package com.network.mylittletale.children.model.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChildrenMapper {
    boolean hasChildren(String memberId);
}
