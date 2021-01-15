package com.cg.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

public class MyZkWatcher implements Watcher {

    private static final Logger log = LoggerFactory.getLogger(MyZkWatcher.class);
    //异步锁
    private CountDownLatch countDownLatch;

    //标记
    private String mark;

    public MyZkWatcher(CountDownLatch countDownLatch, String mark) {
        this.countDownLatch = countDownLatch;
        this.mark = mark;
    }

    @Override
    public void process(WatchedEvent event) {
        log.info(mark+" watcher监听事件:{}",event);
        countDownLatch.countDown();
    }
}
