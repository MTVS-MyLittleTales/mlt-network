package com.network.mylittletale.member.model.service;

import com.network.mylittletale.common.exception.member.MemberModifyException;
import com.network.mylittletale.common.exception.member.MemberRegistException;
import com.network.mylittletale.common.exception.member.MemberRemoveException;
import com.network.mylittletale.member.model.dao.MemberMapper;
import com.network.mylittletale.member.model.dto.MemberDTO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {

    private final PasswordEncoder passwordEncoder;
    private final MemberMapper mapper;


    public MemberService(PasswordEncoder passwordEncoder, MemberMapper mapper) {
        this.passwordEncoder = passwordEncoder;
        this.mapper = mapper;
    }

    @Transactional
    public void registMember(MemberDTO member) throws MemberRegistException {

        System.out.println("MemberService.registMember");

        int result = mapper.insertMember(member);

//        if(!(result > 0)){
//            throw new MemberRegistException("회원 가입에 실패하셨습니다.");
//        }

    }

    public boolean selectMemberById(String userId) {

        String result = mapper.selectMemberById(userId);

        return result != null? true : false;
    }

    @Transactional
    public void modifyMember(MemberDTO member) throws MemberModifyException {
        int result = mapper.updateMember(member);

        if(!(result > 0)) {
            throw new MemberModifyException("회원 정보 수정에 실패하셨습니다.");
        }
    }
    @Transactional
    public void removeMember(MemberDTO member) throws MemberRemoveException {
        int result = mapper.deleteMember(member);

        if(!(result > 0)) {
            throw new MemberRemoveException("회원 탈퇴에 실패하셨습니다.");
        }
    }
}
