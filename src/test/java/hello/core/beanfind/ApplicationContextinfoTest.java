package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextinfoTest {
    AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext(AppConfig.class);
    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) { //iter+Enter
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name= " + beanDefinitionName +"object ="+bean); //soutv
        }

    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) { //iter+Enter
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
            //ROLE_APPLICATION:직접 등록한 애플리케이션 빈
            //ROLE_INFRASTRUCTURE:스프링이 내부에서 사용하는 빈

            if(beanDefinition.getRole()==BeanDefinition.ROLE_APPLICATION){
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name= " + beanDefinitionName +"object ="+bean); //soutv
            }
        }

    }
}
