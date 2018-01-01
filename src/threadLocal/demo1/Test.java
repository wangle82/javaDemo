package threadLocal.demo1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wangle on 2017/12/25.
 */
public class Test {
    //线程不安全
//    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static ThreadLocal<SimpleDateFormat> sdf = new ThreadLocal<SimpleDateFormat>();

    public static class ParseDate implements Runnable{
        int i =0;
        public ParseDate(int i){
            this.i = i;
        }
        @Override
        public void run() {
            try {
//                Date t = sdf.parse("2017-12-25 20:00:"+i%60);
                sdf.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
                Date t = sdf.get().parse("2017-12-25 20:00:"+i%60);
                System.out.println(t);
            }catch (ParseException e){
                e.printStackTrace();
            }finally {
                //用完清除
                sdf.remove();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i=0 ; i<100;i++){
            service.execute(new ParseDate(i));
        }

    }
}
