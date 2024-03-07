package fit.hrkj.springbootjpazuoye;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing //利用jpa可以给MySQL列属性自动赋值,例如一些创建时间，修改时间
//复合注解包含了包扫描，自动注入，配置注入的功能
@SpringBootApplication
public class SpringbootMybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisPlusApplication.class, args);
    }

}
