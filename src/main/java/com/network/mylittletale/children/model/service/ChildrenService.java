package com.network.mylittletale.children.model.service;

import com.network.mylittletale.children.model.dao.ChildrenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChildrenService {
    private final ChildrenMapper mapper;


    @Autowired
    public ChildrenService(ChildrenMapper mapper) {
        this.mapper = mapper;
    }

    public boolean hasChildren(String memberId) {
        return mapper.hasChildren(memberId);
    }
}
