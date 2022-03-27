package com.example.jpa_inflearn;

import com.example.jpa_inflearn.member.Grade;
import com.example.jpa_inflearn.member.Member;
import com.example.jpa_inflearn.member.MemberService;
import com.example.jpa_inflearn.member.MemberServiceImpl;
import com.example.jpa_inflearn.order.Order;
import com.example.jpa_inflearn.order.OrderService;
import com.example.jpa_inflearn.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
//        MemberService memberService = new AppConfig().memberService();
//        //MemberService memberService = new MemberServiceImpl();
//        OrderService orderService = new AppConfig().orderService();
        // OrderService orderService = new OrderServiceImpl();
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1l;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);

        System.out.println(order.toString());
    }
}
