package hello.core2;

import hello.core2.member.Grade;
import hello.core2.member.Member;
import hello.core2.member.MemberService;
import hello.core2.member.MemberServiceImpl;
import hello.core2.order.Order;
import hello.core2.order.OrderService;
import hello.core2.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {
//        final AppConfig appConfig = new AppConfig();
//        final MemberService memberService = appConfig.memberService();
//        final OrderService orderService = appConfig.orderService();

        final ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        final MemberService memberService = ac.getBean(MemberService.class);
        final OrderService orderService = ac.getBean(OrderService.class);

        final Member member = new Member(1L, "itemA", Grade.VIP);
        memberService.join(member);

        final Order order = orderService.createOrder(member.getId(), member.getName(), 10000);

        System.out.println("orderPrice = " + order);
    }
}
