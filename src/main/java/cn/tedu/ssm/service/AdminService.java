package cn.tedu.ssm.service;


import cn.tedu.ssm.domain.Admin;

import java.util.List;

public interface AdminService {
    int addAdmin(Admin admin);
    int addAdminBatch(List<Admin> admins);
}
