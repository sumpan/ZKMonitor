package com.zkmonitor.watcherImp;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zkmonitor.action.Action;

public class WatcherImp implements Watcher{
    private Logger log = LoggerFactory.getLogger(WatcherImp.class);
    
    private Action act = null;
    
    public WatcherImp(Action act){
        this.act = act;
    }

    @Override
    public void process(WatchedEvent event) {
        String ip = event.getPath().split("/")[2];
        if (event.getType() == EventType.NodeDeleted){
            boolean actIsDone = exec();
            if (actIsDone){
                log.warn("node: "+ ip + "is over but the act is done");
            }else{
                log.error("node: "+ ip + "is over and the act is not done");
                System.exit(-1);
            }
        }
    }
    
    private boolean exec(){
        return act.doWork();
    }
}
