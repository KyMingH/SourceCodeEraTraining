package cn.itsource.jdbc.domain;

import java.util.Date;

public class Student {

    private Integer id;
    private String name;
    private String gender;
    private Date birthday;
    private String telephone;
    private String degree;
    private String desc;
    private String state;

    public Student(Integer id, String name, String gender, Date birthday, String telephone, String degree, String desc, String state) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.telephone = telephone;
        this.degree = degree;
        this.desc = desc;
        this.state = state;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", telephone='" + telephone + '\'' +
                ", degree='" + degree + '\'' +
                ", desc='" + desc + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
