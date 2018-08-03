package cn.coderss.reactive.controller;

import cn.coderss.reactive.bean.DO.UserDO;
import cn.coderss.reactive.bean.VO.UserVO;
import cn.coderss.reactive.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @author shenwei
 */
@RestController
@Slf4j
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<UserVO> listUsers(@RequestParam(value = "index", defaultValue = "0") int index,
                                  @RequestParam(value = "size", defaultValue = "10") int size) {
        return userService.getUsers()
                .map(userDO ->UserVO.builder().id(userDO.getId()).name(userDO.getName()).build())
                .filter(userVO -> userVO.getId() > 1533202274465L)
                .skip(index)
                .limitRate(size);
    }

    @GetMapping("/save/{name}")
    public Mono<String> saveUsers(@PathVariable("name") String name){
        return userService.saveUser(
                UserDO.builder()
                        .id(new Date().getTime())
                        .name(name)
                        .build())
                .doOnSuccess(userDO->log.info("userDo新增成功:{}",userDO.toString())).then(Mono.just("ok"));
    }
}
