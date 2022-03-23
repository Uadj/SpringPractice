package com.example.jpa_inflearn.order;

import com.example.jpa_inflearn.discount.DiscountPolicy;
import com.example.jpa_inflearn.discount.FixDiscountPolicy;
import com.example.jpa_inflearn.member.Member;
import com.example.jpa_inflearn.member.MemberRepository;
import com.example.jpa_inflearn.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy){
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice){
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
