package xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext( "spring-config.xml");

        var beanNames = context.getBeanDefinitionNames();

        for(var name : beanNames){
            System.out.println(name);
        }
    }
}
