package com.example.jpa_inflearn;

import com.example.jpa_inflearn.member.Grade;
import com.example.jpa_inflearn.member.Member;
import com.example.jpa_inflearn.member.MemberService;
import com.example.jpa_inflearn.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(2L);
        System.out.println("new member =" + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
