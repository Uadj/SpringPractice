package com.example.jpa_inflearn;

import com.example.jpa_inflearn.discount.DiscountPolicy;
import com.example.jpa_inflearn.discount.FixDiscountPolicy;
import com.example.jpa_inflearn.discount.RateDiscountPolicy;
import com.example.jpa_inflearn.member.MemberRepository;
import com.example.jpa_inflearn.member.MemberService;
import com.example.jpa_inflearn.member.MemberServiceImpl;
import com.example.jpa_inflearn.member.MemoryMemberRepository;
import com.example.jpa_inflearn.order.OrderService;
import com.example.jpa_inflearn.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }
    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), discountPolicy());
    }
    private MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
    private DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}
