package test.mybaits;

import cn.tedu.ssm.domain.Admin;
import cn.tedu.ssm.service.AdminService;
import org.junit.Test;
import test.BaseTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminServiceTest extends BaseTest {
    @Test
    public void test1(){
        AdminService adminService = applicationContext.getBean(AdminService.class);
        Admin admin = new Admin("chenjiabing", "account", 10.2, new Date(), "2344");
        int i = adminService.addAdmin(admin);
        System.out.println(i);
    }


    @Test
    public void test2(){
        AdminService adminService = applicationContext.getBean(AdminService.class);
        List<Admin> admins=new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Admin admin = new Admin("chenjiabing", "account", 10.2, new Date(), "2344");
            admins.add(admin);
        }
        adminService.addAdminBatch(admins);
    }

}
