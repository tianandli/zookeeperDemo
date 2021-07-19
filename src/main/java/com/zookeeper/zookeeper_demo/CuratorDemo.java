package com.zookeeper.zookeeper_demo;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.data.Stat;

/**
 * 描述：获取name节点
 * @param
 * @return 
 * @author lijie
 * @date 2021/3/10 17:57
 */
public class CuratorDemo {

    public static void main(String[] args) throws Exception {
        CuratorFramework curatorFramework=CuratorFrameworkFactory.
                builder().connectString("192.168.194.130:2181," +
                "192.168.194.130:2181,192.168.194.130:2181").
                sessionTimeoutMs(4000).retryPolicy(new
                ExponentialBackoffRetry(1000,3)).
                namespace("").build();
        curatorFramework.start();
        Stat stat=new Stat();
        byte[] bytes = curatorFramework.getData().storingStatIn(stat).forPath("/name");
        System.out.println(new String(bytes));
        curatorFramework.close();
    }
}
