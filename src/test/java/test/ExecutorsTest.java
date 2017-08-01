package test;

import org.junit.Test;
import org.quartz.Scheduler;

import java.util.concurrent.*;

/**
 * Created by Administrator on 2017-7-28.
 */
public class ExecutorsTest {
    @Test
    public void test1() {
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            Thread thread = new MyThread();
            pool.execute(thread);
        }
        pool.shutdown();
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "..执行");
        }
    }

    @Test
    public void test2() {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(3);
        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        Thread t3 = new MyThread();
        pool.schedule(t1, 20, TimeUnit.MILLISECONDS);
        pool.execute(t2);
        pool.schedule(t3, 2000, TimeUnit.MILLISECONDS);
        pool.shutdown();
    }
}
