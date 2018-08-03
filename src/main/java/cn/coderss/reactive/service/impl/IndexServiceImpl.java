package cn.coderss.reactive.service.impl;


import cn.coderss.reactive.bean.BO.IndexBO;
import cn.coderss.reactive.service.IIndexService;
import org.springframework.stereotype.Service;
import rx.Observable;

/**
 * @author shenwei
 */
@Service
public class IndexServiceImpl implements IIndexService {

    public Observable<IndexBO> getMessage(String msg) {
        return Observable.just(IndexBO.builder().message("hello:" + msg).build());
    }
}
