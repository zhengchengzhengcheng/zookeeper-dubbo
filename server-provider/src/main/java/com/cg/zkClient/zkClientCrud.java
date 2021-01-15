package com.cg.zkClient;

import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.ZkSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class zkClientCrud<T> {

    ZkClient zkClient;
    final static Logger logger = LoggerFactory.getLogger(ZkClient.class);
    //单一节点
    private static final String zkServerSingleConnect = "192.168.0.149:2181";
    //超时毫秒数
    public static final int timeout = 3000;

    public zkClientCrud(ZkSerializer zkSerializer){
        logger.info("连接zk开始");
        zkClient = new ZkClient(zkServerSingleConnect,timeout,timeout,zkSerializer);
    }

    public void createEphemeral(String path,Object data){
        zkClient.createEphemeral(path,data);
    }
    /***
     * 支持创建递归方式,但无法设置value
     * @param path
     * @param createParents
     */
    public void createPersistent(String path,boolean createParents){

        zkClient.createPersistent(path,createParents);
    }

    /***
     * 创建节点和data数据
     * @param path
     * @param data
     */
    public void createPersistent(String path,Object data){

        zkClient.createPersistent(path,data);
    }

    /***
     * 子节点
     * @param path
     * @return
     */
    public List<String> getChildren(String path){
        return zkClient.getChildren(path);

    }

    public  T readData(String path){
        return zkClient.readData(path);
    }

    public  void  writeData(String path,Object data){
        zkClient.writeData(path,data);
    }
    public  void deleteRecursive(String path){
        zkClient.deleteRecursive(path);

    }

}
