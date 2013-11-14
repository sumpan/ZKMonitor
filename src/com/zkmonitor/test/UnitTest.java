package com.zkmonitor.test;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.zookeeper.KeeperException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.Assert;
import org.junit.Test;

import com.zkmonitor.action.Action;
import com.zkmonitor.main.ZKMonitor;

@RunWith(JUnit4.class)
public class UnitTest {
    
    @Test
    public void testSetMonitor() throws IOException, KeeperException, InterruptedException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        ZKMonitor t = new ZKMonitor("localhost");
        Method m = ZKMonitor.class.getDeclaredMethod("setMonitor", String.class, Action.class);
        m.setAccessible(true);
        Assert.assertTrue((boolean) m.invoke(t, "10.1.1.1",null));
    }
    
    @Test
    public void testCreateEZNode() throws IOException, KeeperException, InterruptedException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException{
        ZKMonitor t = new ZKMonitor("localhost");
        Method m = ZKMonitor.class.getDeclaredMethod("createENode",String.class);
        m.setAccessible(true);
        Field f = ZKMonitor.class.getDeclaredField("path");
        f.setAccessible(true);
        f.set(t, "/test");
        Assert.assertTrue((boolean)m.invoke(t, new String("")));
    }
}
