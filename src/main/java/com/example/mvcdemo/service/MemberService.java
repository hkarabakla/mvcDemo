package com.example.mvcdemo.service;

import com.example.mvcdemo.model.Member;
import com.example.mvcdemo.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member create(Member member) {
        return memberRepository.save(member);
    }

    public Optional<Member> getMemberById(long memberId) {
        return memberRepository.findById(memberId);
    }
}
