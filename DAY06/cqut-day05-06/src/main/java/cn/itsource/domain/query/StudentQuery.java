package cn.itsource.domain.query;
import cn.itsource.util.PageParams;
import lombok.Data;
import java.util.Date;
@Data
public class StudentQuery extends PageParams {
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private String gender;
    /**
     * 出生日期 - 开始
     */
    private Date birthdayBegin;
    /**
     * 出生日期 - 结束
     */
    private Date birthdayEnd;
    /**
     * 联系方式
     */
    private String telephone;
    /**
     * 出生日期 - 结束
     */
    private String degree;
    /**
     * 简介
     */
    private String desc;
    /**
     * 状态
     */
    private String state;
}
