package cn.coderss.reactive.bean.VO;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

/**
 * @author shenwei
 */
@Data
@Builder
public class UserVO {
    @NonNull private Long id;
    @NonNull private String name;
}
