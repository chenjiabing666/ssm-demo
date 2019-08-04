package cn.tedu.ssm.service.impl;

import cn.tedu.ssm.domain.Admin;
import cn.tedu.ssm.mapper.AdminMapper;
import cn.tedu.ssm.service.AdminService;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements AdminService, InitializingBean {
//    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;


    @Override
    public int addAdmin(Admin admin) {
        int i = adminMapper.insertAdmin(admin);
        System.out.println(1/0);
        return i;
    }

    @Override
    public int addAdminBatch(List<Admin> admins) {
        for (int i = 0; i < admins.size(); i++) {
            adminMapper.insertAdmin(admins.get(i));
        }
//        System.out.println(1/0);
        return 0;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
