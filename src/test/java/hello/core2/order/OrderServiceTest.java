package hello.core2.order;

import hello.core2.AppConfig;
import hello.core2.member.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        final AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        final Member member = new Member(1L, "itemA", Grade.VIP);
        memberService.join(member);

        final Order order = orderService.createOrder(member.getId(), member.getName(), 10000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}
