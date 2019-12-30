package cn.llyong.conf.client;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created with IntelliJ IDEA.
 *
 * @description:
 * @author: lvyong
 * @date: 2019-12-30
 * @time: 10:36 上午
 * @version: 1.0
 */
@Component
@Slf4j
public class ZkClient {

    @PostConstruct
    public void getConnect() {
        CuratorFramework client = CuratorFrameworkFactory.builder()
                .connectString("localhost")
                .sessionTimeoutMs(5000)
                .connectionTimeoutMs(5000)
                .retryPolicy(new ExponentialBackoffRetry(1000, 3))
                .namespace("base")
                .build();
        client.start();
    }

}
