package cn.coderss.reactive.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @author shenwei
 */
@RestController
@Slf4j
public class OtherController {

    @GetMapping("callable")
    public Callable<String> callable(){
        return ()->{
            TimeUnit.SECONDS.sleep(1);
            return "callable";
        };
    }

    @GetMapping("deferredResult")
    public DeferredResult<String> deferredResult(){
        DeferredResult<String> deferredResult = new DeferredResult<>();
        new Thread(() -> deferredResult.setResult("ok")).start();

        deferredResult.onCompletion(()->{
            log.info("completion");
        });
        return deferredResult;
    }

    @GetMapping("/events")
    public ResponseBodyEmitter handle(){
        ResponseBodyEmitter emitter = new ResponseBodyEmitter();
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
                emitter.send("hello\n");
                TimeUnit.SECONDS.sleep(3);
                emitter.send("hello2\n");
                TimeUnit.SECONDS.sleep(3);
                emitter.send("hello3\n");
                TimeUnit.SECONDS.sleep(3);
                emitter.complete();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
        return emitter;
    }
}
