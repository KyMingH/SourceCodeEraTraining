package cn.itsource.util;
import lombok.Data;
@Data
public class PageParams {
    private Integer pageNum;
    private Integer pageSize;
    public Integer getStartIndex(){
        return (pageNum - 1) * pageSize;
    }
}
