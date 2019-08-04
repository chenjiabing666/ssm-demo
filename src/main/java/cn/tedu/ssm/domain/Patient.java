package cn.tedu.ssm.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Patient {
    private String userId;
    private Integer id;
    private String status;
}
