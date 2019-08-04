package cn.tedu.ssm.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
public class Admin {
    private Integer id;
    private String name;
    private String account;
    private Double point;
    private Date birthday;
    private String password;

    public Admin(String name, String account, Double point, Date birthday, String password) {
        this.name = name;
        this.password=password;
        this.account = account;
        this.point = point;
        this.birthday = birthday;
    }
}
