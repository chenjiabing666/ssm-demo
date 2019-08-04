package cn.tedu.ssm.mapper;

import cn.tedu.ssm.domain.Patient;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface PatientMapper {
//    @Select("select id as id,user_id as userId from patient_info where user_id=#{userId}")
    Patient selectByUserId(String userId);

    @Select("select * from patient_info where ipt_num=#{param1} and status=#{param2}")
    Patient selectByIptNumAndInhos(@Param("iptNum") String iptNum, @Param("status") String status);

    @Select("select * from patient_info where ipt_num=#{iptNum} and status=#{status}")
    Patient selectByIptAndInhosNumMap(Map ipts);

    /**
     * 使用@MapKey注解指定返回Map中的key，这里设定的是Patient中的id属性作为key
     * @return
     */
    @MapKey("id")
    @Select("select * from patient_info")
    Map<Integer,Patient> selectAllReturnMap();

    @Select("SELECT * from patient_info where dept_id=#{deptId}")
    List<Patient> selectByDeptId(Integer deptId);

}
