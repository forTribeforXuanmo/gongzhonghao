package test;

/**
 * Created by Administrator on 2017-7-28.
 */
public class Singleton {
    private static class Inner {
        private static Singleton singleton = new Singleton();

        static {
            System.out.println("内部类被解析");
        }
    }

    private Singleton() {
        if (Inner.singleton != null) {
            try {
                throw new IllegalAccessException("已被实例化了，不要尝试反射构造");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static Singleton getSingleton() {
        return Inner.singleton;
    }
}
