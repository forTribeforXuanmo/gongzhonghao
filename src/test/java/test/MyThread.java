package test;

/**
 * Created by Administrator on 2017-7-28.
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "---执行");
        Singleton S = Singleton.getSingleton();

    }
}
