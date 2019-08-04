package cn.tedu.ssm.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.ExecutorType;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.IOException;

/**
 * 配置类
 * @MapperScan：扫描所有的Mapper接口
 */
@Configuration
@ComponentScan(basePackages = {"cn.tedu.ssm"})
@MapperScan(basePackages = {"cn.tedu.ssm.mapper"})
@EnableAspectJAutoProxy
@EnableAsync
@EnableTransactionManagement
public class MainConfig {
    /**
     * 注册数据源
     */
    @Bean
    public DruidDataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(DataConfig.URL);
        dataSource.setUsername(DataConfig.USER);
        dataSource.setPassword(DataConfig.PWD);
        dataSource.setDriverClassName(DataConfig.DRIVER_NAME);
        return dataSource;
    }


    /**
     * 配置SqlSessionFactoryBean，实际就是SqlSessionFactory
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        //设置数据源
        sqlSessionFactoryBean.setDataSource(dataSource());
        //配置扫描mapepr.xml文件
        PathMatchingResourcePatternResolver classPathResource = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(classPathResource.getResources("classpath:mappers/*.xml"));
        //设置全局配置文件的位置
        sqlSessionFactoryBean.setConfigLocation(classPathResource.getResource("classpath:mybatis-config.xml"));
        return sqlSessionFactoryBean;
    }


    /**
     * 注入SqlSessionTemplate，替代SqlSessionFactory直接创建SqlSession，并且能够使用Spring的事务管理
     * 如果需要使用批量处理，在构造方法中指定ExecutorType.BATCH即可，那么全部的操作的都会使用
     * 【可以不配置，需要的时候使用】
     */
    @Bean
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory().getObject());
        return sqlSessionTemplate;
    }

    /**
     * 创建事务管理器
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager(){
        return new DataSourceTransactionManager(dataSource());
    }
}
