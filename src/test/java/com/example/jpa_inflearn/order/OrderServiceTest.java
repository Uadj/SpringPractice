package com.example.jpa_inflearn.order;

import com.example.jpa_inflearn.AppConfig;
import com.example.jpa_inflearn.member.Grade;
import com.example.jpa_inflearn.member.Member;
import com.example.jpa_inflearn.member.MemberService;
import com.example.jpa_inflearn.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService ;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder(){
    Long memberId = 1L;
    Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

    Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
        System.out.println(order.toString());
    }
}
