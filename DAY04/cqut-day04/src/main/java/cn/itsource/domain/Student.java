package cn.itsource.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Student {
    private Integer id;
    private String name;
    private String gender;
    private Date birthday;
    private String telephone;
    private String degree;
    private String desc;
    private String state;
}
