package cn.coderss.reactive.bean.BO;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

/**
 * @author shenwei
 */
@Data
@Builder
public class IndexBO {
    @NonNull
    private String message;
}
