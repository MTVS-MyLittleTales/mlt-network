package com.network.mylittletale.member.dao;

import com.network.mylittletale.member.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    int insertMember(MemberDTO member);

    String selectMemberById(String userId);

    MemberDTO findByMemberId(String memberId);

    int updateMember(MemberDTO member);

    int deleteMember(MemberDTO member);
}
