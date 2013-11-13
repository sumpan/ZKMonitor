package com.zkmonitor.test;

import java.io.IOException;

import org.apache.zookeeper.KeeperException;

import com.zkmonitor.action.Action;
import com.zkmonitor.main.ZKMonitor;

public class UnitTest {
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZKMonitor zkm = new ZKMonitor("localhost");
        zkm.setMonitor("10.1.1.1", new Action() {
            
            @Override
            public void doWork() {
                System.out.println("hello world");
                
            }
        });
        
        while (true){}
    }
}
