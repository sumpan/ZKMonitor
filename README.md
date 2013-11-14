ZKMonitor
=========
`Author : zcfrank1st`

###Description

It's a middleware based on Zookeeper, using to control a cluster.</br>
It's very simple and flexible.<br>
When members in the cluser down after you set monitors, `ZKMonitor` can help you mantain your cluster by implementing `doWork()` method.

###How To Use

Download the project and patch a jar.
Then `new` a `ZKMonitor` class with string argument `ip:port`.
At last use instance method `setMonitor(String ip, Action act)` to monitor a machine.

example:<br>

	ZKMonitor zkm = new ZKMonitor("127.0.0.1");
	zkm.setMonitor("127.0.0.1",new Action(){
		@override
			public boolean doWork(){
				//do something
			}
	});
###Lisence

Using MIT lisence

