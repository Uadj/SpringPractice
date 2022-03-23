package com.example.jpa_inflearn;

import com.example.jpa_inflearn.member.Grade;
import com.example.jpa_inflearn.member.Member;
import com.example.jpa_inflearn.member.MemberService;
import com.example.jpa_inflearn.member.MemberServiceImpl;
import com.example.jpa_inflearn.order.Order;
import com.example.jpa_inflearn.order.OrderService;
import com.example.jpa_inflearn.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new AppConfig().memberService();
        //MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new AppConfig().orderService();
        // OrderService orderService = new OrderServiceImpl();

        Long memberId = 1l;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);

        System.out.println(order.toString());
    }
}
