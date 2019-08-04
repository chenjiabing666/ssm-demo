package cn.tedu.ssm.mapper;

import cn.tedu.ssm.domain.Admin;

public interface AdminMapper {
    int insertAdmin(Admin admin);

    Admin selectById(Integer id);
}
