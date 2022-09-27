package com.network.mylittletale.member.service;

import com.network.mylittletale.member.dao.MemberMapper;
import com.network.mylittletale.member.dto.MemberDTO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements UserDetailsService {

    private final MemberMapper mapper;

    public AuthenticationService(MemberMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {

        System.out.println("[AuthenticationService] memberId : " + memberId);

        MemberDTO member = mapper.findByMemberId(memberId);

        System.out.println("[AuthenticationService] member : " + member);

        if(member == null) {
            throw new UsernameNotFoundException("회원 정보가 존재하지 않습니다.");
        }

        return member;
    }
}
