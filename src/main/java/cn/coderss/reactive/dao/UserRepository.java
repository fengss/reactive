package cn.coderss.reactive.dao;

import cn.coderss.reactive.bean.DO.UserDO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author shenwei
 */
@Repository
public interface UserRepository extends ReactiveMongoRepository<UserDO, Long> {
}
