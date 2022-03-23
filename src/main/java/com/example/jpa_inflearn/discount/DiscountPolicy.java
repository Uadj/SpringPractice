package com.example.jpa_inflearn.discount;

import com.example.jpa_inflearn.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
