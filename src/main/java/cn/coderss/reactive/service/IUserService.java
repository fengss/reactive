package cn.coderss.reactive.service;

import cn.coderss.reactive.bean.DO.UserDO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author shenwei
 */
public interface IUserService {
    Flux<UserDO> getUsers();

    Mono<UserDO> saveUser(UserDO userDO);
}
