package bitcamp.java106;

import org.springframework.context.ApplicationContext;

public class BeanUtils {
    public static void printBeanList(ApplicationContext iocContainer) {
        System.out.println("---------------------------------------------");
        int count = iocContainer.getBeanDefinitionCount();
        System.out.printf("빈 개수: %d\n", count);
        
        String[] beanNames = iocContainer.getBeanDefinitionNames();
        for(String name : beanNames) {
            System.out.printf("%s = %s\n", name, iocContainer.getBean(name).getClass().getName());
        }
        
        System.out.println("---------------------------------------------");
    }
    
    public static void printBeanAliases(ApplicationContext iocContainer, String beanName) {
        System.out.printf("['%s' 빈의 별명 목록]\n", beanName);
        String[] aliases = iocContainer.getAliases(beanName);
        for(String alias : aliases) {
            System.out.println(alias);
        }
    }
    
    public static void printBeanNames(ApplicationContext iocContainer) {
        System.out.println("[생성된 빈의 이름 목록]");
        String[] names = iocContainer.getBeanDefinitionNames();
        for(String name : names) {
            System.out.println(name);
        }
        System.out.println("---------------------------------------------");
    }
}
