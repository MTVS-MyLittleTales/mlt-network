package com.network.mylittletale.children.model.service;

import com.network.mylittletale.children.model.dao.ChildrenMapper;
import com.network.mylittletale.children.model.dto.ChildrenDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ChildrenService {
    private final ChildrenMapper mapper;


    @Autowired
    public ChildrenService(ChildrenMapper mapper) {
        this.mapper = mapper;
    }
    public boolean hasChildren(int memberId) {
        ChildrenDTO selectedChildren = mapper.hasChildren(memberId);
        if(selectedChildren != null){
            return true;
        }
        return false;
    }

    @Transactional
    public boolean registChildren(ChildrenDTO children) {
        int result =  mapper.registChildren(children);

        if (result > 0) {
            return false;
        }
        return true;

    }
}
