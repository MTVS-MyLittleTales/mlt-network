package com.network.mylittletale.member.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.network.mylittletale.common.exception.member.MemberModifyException;
import com.network.mylittletale.common.exception.member.MemberRegistException;
import com.network.mylittletale.common.exception.member.MemberRemoveException;
import com.network.mylittletale.common.util.SessionUtil;
import com.network.mylittletale.member.model.dto.MemberDTO;
import com.network.mylittletale.member.model.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/member")
public class MemberController {

    private final PasswordEncoder passwordEncoder;
    private final MemberService memberService;

    @Autowired
    public MemberController(PasswordEncoder passwordEncoder, MemberService memberService) {
        this.passwordEncoder = passwordEncoder;
        this.memberService = memberService;
    }

    @GetMapping("/regist")
    public String goRegister() {
        return "member/content/regist";
    }

    @PostMapping("/regist")
    public String registMember(@ModelAttribute MemberDTO member, HttpServletRequest request,
                               RedirectAttributes rttr) throws MemberRegistException {

        System.out.println("[MemberController] registMember =======================================");

        member.setMemberPwd(passwordEncoder.encode(member.getMemberPwd()));

        boolean checkedId = memberService.selectMemberById(member.getMemberId());

        if(checkedId) {
            throw new MemberRegistException("회원가입에 실패하였습니다. 중복된 아이디입니다.");
        }

        System.out.println("[MemberController] registMember request Member : " + member);
        memberService.registMember(member);

        rttr.addFlashAttribute("message", "회원 가입에 성공하셨습니다.");

        System.out.println("[MemberController] registMember =================================");

        return "redirect:/";

    }

    @PostMapping("/idDupCheck")
    public ResponseEntity<String> checkDuplication(@RequestBody MemberDTO memberDto) throws JsonProcessingException {

        System.out.println("[MemberController] checkDuplication ================================");

        String result = "사용 가능한 아이디 입니다.";

        if("".equals(memberDto.getMemberId())) {
            System.out.println("[MemberController] Request Check Id");
            result = "아이디를 입력해 주세요";
        } else if(memberService.selectMemberById(memberDto.getMemberId())) {
            System.out.println("[MemberController] Already Exist");
            result = "중복된 아이디가 존재합니다.";
        }

        System.out.println("[MemberController] checkDuplication =======================");

        return ResponseEntity.ok(result);
    }

    @GetMapping("/login")
    public String goLogin() {

        System.out.println("로그인 화면");
        return "member/content/login";
    }

    @GetMapping("/loginfail")
    public String goLoginFail() {

        System.out.println("로그인 실패!");
        return "common/errors/error-login";
    }

    @GetMapping("/update")
    public String goModifyMember() {


        return "member/content/update";
    }

    @PostMapping("/update")
    public String modifyMember(@ModelAttribute MemberDTO member, HttpServletRequest request, HttpServletResponse response,
                               RedirectAttributes rttr) throws MemberModifyException {

        member.setMemberPwd(passwordEncoder.encode(member.getMemberPwd()));

        memberService.modifyMember(member);

        SessionUtil.invalidateSession(request, response);

        rttr.addFlashAttribute("message", "회원 정보 수정에 성공하셨습니다. 다시 로그인 해주세요.");

        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteMember(@ModelAttribute MemberDTO member, SessionStatus status,
                               RedirectAttributes rttr, HttpServletRequest request, HttpServletResponse response) throws MemberRemoveException {

        long miliseconds = System.currentTimeMillis();
        Date date = new Date(miliseconds);

        String memberId = request.getParameter("id");
        member.setMemberId(memberId);
        member.setMemberSecessionDatetime((date));

        memberService.removeMember(member);

        SessionUtil.invalidateSession(request, response);

        rttr.addFlashAttribute("message", "회원 탈퇴에 성공하셨습니다. 로그아웃됩니다.");

        return "redirect:/";
    }

}
