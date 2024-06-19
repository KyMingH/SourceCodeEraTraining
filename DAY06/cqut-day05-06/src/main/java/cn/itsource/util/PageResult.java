package cn.itsource.util;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResult<T> {
/**
 * 当前页的数据
 */
private List<T> rows = new ArrayList<>();
/**
 * 总的条目数
 */
private Long total = 0L;
}