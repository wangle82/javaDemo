package collection.demo1.test3;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class MyService1 {
	//保证高并发线程安全，也保证顺序
	public ConcurrentSkipListMap map = new ConcurrentSkipListMap();
	public MyService1() {
		Userinfo userinfo1 = new Userinfo(1, "username1");
		Userinfo userinfo2 = new Userinfo(2, "username2");
		Userinfo userinfo4 = new Userinfo(4, "username4");
		Userinfo userinfo3 = new Userinfo(3, "username3");
		Userinfo userinfo5 = new Userinfo(5, "username5");
		Userinfo userinfo6 = new Userinfo(6, "username6");

		map.put(userinfo1, "value1");
		map.put(userinfo3, "value3");
		map.put(userinfo5, "value5");
		map.put(userinfo4, "value4");
		map.put(userinfo2, "value2");
		map.put(userinfo6, "value6");
	}
}
