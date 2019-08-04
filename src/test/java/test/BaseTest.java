package test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import cn.tedu.ssm.config.MainConfig;

public class BaseTest {
    public ApplicationContext applicationContext;
    @Before
    public void before(){
        applicationContext=new AnnotationConfigApplicationContext(MainConfig.class);
    }

    @Test
    public void test1(){

    }
}
