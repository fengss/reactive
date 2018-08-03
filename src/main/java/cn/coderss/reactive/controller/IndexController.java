package cn.coderss.reactive.controller;

import cn.coderss.reactive.bean.VO.IndexVO;
import cn.coderss.reactive.service.IIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import rx.Observable;

/**
 * @author shenwei
 */
@RestController
public class IndexController {

    @Autowired
    IIndexService indexService;

    @GetMapping("/")
    public Observable<IndexVO> index(){
        return indexService
                .getMessage("San")
                .map((data)->IndexVO.builder().message(data.getMessage()).build());
    }
}
