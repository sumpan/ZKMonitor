package com.zkmonitor.main;

import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

import com.zkmonitor.action.Action;
import com.zkmonitor.constant.Constant;
import com.zkmonitor.manipulate.Manipulate;
import com.zkmonitor.watcherImp.WatcherImp;

public class ZKMonitor implements Manipulate{
    private ZooKeeper zk = null;
    private String path = "/zkmonitor/";
    
    public ZKMonitor(String ip) throws IOException, KeeperException, InterruptedException{
        this.zk = new ZooKeeper(ip, Constant.SESSION_TIME_OUT, null);
        if(zk.exists("/zkmonitor", false) == null){
            zk.create("/zkmonitor", "root".getBytes(),Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }
    }

    @Override
    public boolean setMonitor(String ip, Action act) {
        path = path + ip;
        createENode(ip);
        try {
            zk.getData(path, new WatcherImp(act), null);
        } catch (KeeperException | InterruptedException e) {
            return true;
        }
        return true;
    }
    
    private boolean createENode(String ip){
        try {
            zk.create(path, "0".getBytes(),Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        } catch (KeeperException | InterruptedException e) {
            return false;
        }
        return true;
    }
    
    //for testing
    public ZooKeeper getZK(){
        return zk;
    }

}
