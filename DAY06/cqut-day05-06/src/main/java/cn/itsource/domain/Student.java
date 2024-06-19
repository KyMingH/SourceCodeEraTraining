package cn.itsource.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)

public class Student implements Serializable {
    private Integer id;
    private String name;
    private String gender;
    private Date birthday;
    private String telephone;
    private String degree;
    private String desc;
    private String state;
}
