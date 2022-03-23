package com.example.jpa_inflearn.discount;

import com.example.jpa_inflearn.member.Grade;
import com.example.jpa_inflearn.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{

    private int discountRate = 10;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()== Grade.VIP){
            return price*discountRate/100;
        }
        else{
            return 0;
        }
    }
}
