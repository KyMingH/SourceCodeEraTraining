package cn.itsource.util;
import lombok.Data;
import lombok.experimental.Accessors;
@Data
@Accessors(chain = true)
public class AjaxResult<T> {
    /**
     * 错误码
     */
    private Integer code = 200;
    /**
     * 提示信息
     */
    private String message = "操作成功!";
    private T data;
    // 不能通过new创建AjaxResult对象
    private AjaxResult(){}
    /**
     * 成功
     * @return
     */
    public static AjaxResult success(){
        return new AjaxResult<>();
    }
    /**
     * 失败
     * @return
     */
    public static AjaxResult error(){
        return new AjaxResult<>
                ().setCode(500).setMessage("操作失败！");
    }
}
