package com.example.mvcdemo.controller;

import com.example.mvcdemo.controller.dto.MemberCreateDto;
import com.example.mvcdemo.controller.dto.MemberDto;
import com.example.mvcdemo.model.Member;
import com.example.mvcdemo.service.MemberService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("member")
    public MemberDto create(@RequestBody MemberCreateDto dto) {
        Member member = memberService.create(dto.toMember());
        return MemberDto.builder()
                .id(member.getId())
                .birthDate(member.getBirthDate())
                .membershipDate(member.getMembershipDate())
                .name(member.getName())
                .surname(member.getSurname())
                .build();
    }
}
