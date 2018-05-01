package bitcamp.java106.pms;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="bitcamp.java106.pms")
public class AppConfig {
    @Bean
    public SqlSessionFactory getSqlSessionFactory() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("bitcamp/java106/pms/sql/mybatis-config.xml");
        return new SqlSessionFactoryBuilder().build(inputStream);
    }
}
