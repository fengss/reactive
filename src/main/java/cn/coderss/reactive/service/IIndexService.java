package cn.coderss.reactive.service;

import cn.coderss.reactive.bean.BO.IndexBO;
import rx.Observable;

/**
 * 首页测试服务
 *
 * @author shenwei
 */
public interface IIndexService {
    Observable<IndexBO> getMessage(String msg);
}
