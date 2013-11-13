package com.zkmonitor.manipulate;

import com.zkmonitor.action.Action;

public interface Manipulate {
    boolean setMonitor(String ip, Action act);
}
