package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017-7-28.
 */
public class SingleTonTest {
    public static void main(String[] args) {

        //   Class<Singleton> singletonClass= (Class<Singleton>) Class.forName("test.Singleton");
//            Singleton a=Singleton.getSingleton();
//            Singleton b=Singleton.getSingleton();
        ExecutorService pool = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {
            MyThread t = new MyThread();
            pool.execute(t);
        }
        pool.shutdown();
    }

}
