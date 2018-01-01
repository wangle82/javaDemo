package futureAndcallable.demo1.mycallable;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

	private String value;

	public MyCallable(String value) {
		super();
		this.value = value;
	}

	public String call() throws Exception {
		Thread.sleep(3000);
		return "返回值 ：" + value;
	}

}
