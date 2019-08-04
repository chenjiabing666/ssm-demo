package test.mybaits;

import cn.tedu.ssm.domain.Patient;
import cn.tedu.ssm.mapper.PatientMapper;
import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;
import test.BaseTest;

public class PatientMapperTest extends BaseTest {

    @Test
    public void test1(){
        PatientMapper mapper = applicationContext.getBean(PatientMapper.class);
        Patient patient = mapper.selectByUserId("15627679");
        System.out.println(patient);
    }

    @Test
    public void test2(){
        SqlSessionTemplate sqlSessionTemplate = applicationContext.getBean(SqlSessionTemplate.class);
        PatientMapper mapper = sqlSessionTemplate.getMapper(PatientMapper.class);
        mapper.selectByUserId("15627679");
    }

}
