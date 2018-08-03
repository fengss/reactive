package cn.coderss.reactive.bean.DO;

import lombok.*;
import org.springframework.data.annotation.Id;

/**
 * @author shenwei
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDO {
    @Id
    private Long id;

    private String name;
}
