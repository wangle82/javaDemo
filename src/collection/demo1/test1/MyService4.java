package collection.demo1.test1;

import java.util.Hashtable;

public class MyService4 {
	//不支持iterator在多线程安全
	public static Hashtable hashtable = new Hashtable();

	public MyService4() {
		for (int i = 0; i < 5; i++) {
			hashtable.put("String" + (i + 1), i + 1);
		}
	}

}
