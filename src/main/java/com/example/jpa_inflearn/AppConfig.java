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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), discountPolicy());
    }
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}
