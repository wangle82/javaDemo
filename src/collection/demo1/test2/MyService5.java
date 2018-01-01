package collection.demo1.test2;

import java.util.concurrent.ConcurrentHashMap;

public class MyService5 {
	//支持多线程安全,不支持排序
	public ConcurrentHashMap map = new ConcurrentHashMap();;

	public MyService5() {
		for (int i = 0; i < 5; i++) {
			map.put("key" + (i + 1), "value" + (i + 1));
		}
	}
}
