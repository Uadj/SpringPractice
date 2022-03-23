package com.example.jpa_inflearn.discount;

import com.example.jpa_inflearn.member.Grade;
import com.example.jpa_inflearn.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount =1000;
    @Override
    public int discount(Member member, int price){
        if(member.getGrade()== Grade.VIP){
            return discountFixAmount;
        } else{
            return 0;
        }
    }
}
