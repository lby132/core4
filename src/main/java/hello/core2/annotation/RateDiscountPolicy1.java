package hello.core2.annotation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
@Qualifier("ra")
public class RateDiscountPolicy1 {
}
