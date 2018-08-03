package cn.coderss.reactive.service.impl;

import cn.coderss.reactive.bean.DO.UserDO;
import cn.coderss.reactive.dao.UserRepository;
import cn.coderss.reactive.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author shenwei
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Flux<UserDO> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public Mono<UserDO> saveUser(UserDO userDO) {
        return userRepository.insert(userDO);
    }
}
