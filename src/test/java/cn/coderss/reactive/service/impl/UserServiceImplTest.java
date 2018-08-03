package cn.coderss.reactive.service.impl;


import cn.coderss.reactive.bean.DO.UserDO;
import cn.coderss.reactive.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author shenwei
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserServiceImplTest {

    @Autowired
    private IUserService userService;

    @Test
    public void getUsers() {
        log.info("getUsers");
        userService.getUsers().subscribe(userDO -> {
            log.info(userDO.toString());
        });
    }

    @Test
    public void saveUser() {
        userService.saveUser(UserDO.builder()
                .id(new Date().getTime())
                .name("zs").build());
    }
}
