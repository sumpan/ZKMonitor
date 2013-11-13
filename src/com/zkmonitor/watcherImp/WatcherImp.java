package com.zkmonitor.watcherImp;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;

import com.zkmonitor.action.Action;

public class WatcherImp implements Watcher{
    private Action act = null;
    
    public WatcherImp(Action act){
        this.act = act;
    }

    @Override
    public void process(WatchedEvent event) {
        if (event.getType() == EventType.NodeDeleted){
            exec();
        }
    }
    
    private void exec(){
        act.doWork();
    }
}
