package com.example.jpa_inflearn.order;

import com.example.jpa_inflearn.discount.DiscountPolicy;
import com.example.jpa_inflearn.discount.FixDiscountPolicy;
import com.example.jpa_inflearn.member.Member;
import com.example.jpa_inflearn.member.MemberRepository;
import com.example.jpa_inflearn.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice){
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
