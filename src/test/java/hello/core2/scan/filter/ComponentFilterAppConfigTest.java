package hello.core2.scan.filter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.context.annotation.ComponentScan.*;

public class ComponentFilterAppConfigTest {

    @Test
    void filterScan() {
        final ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);
        Assertions.assertThrows(NoSuchBeanDefinitionException.class, () -> ac.getBean(BeanA.class));
        Assertions.assertThrows(NoSuchBeanDefinitionException.class, () -> ac.getBean(BeanB.class));
    }

    @Configuration
    @ComponentScan(
            includeFilters = {@Filter(type = FilterType.ANNOTATION, classes = MyIncludeComponent.class)},
            excludeFilters = {@Filter(type = FilterType.ANNOTATION, classes = MyExcludeComponent.class),
            @Filter(type = FilterType.ASSIGNABLE_TYPE, classes = BeanA.class)} // 내가 지정해준(ASSIGNABLE_TYPE) 클래스도 빈 등록에서 제외 시킬수 있다.
    )
    static class ComponentFilterAppConfig {

    }
}
