package test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Administrator on 2017-7-19.
 *
 * @deprecated
 */
public class MyAnnotationTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(BeanScannerConfigurer.class);
        annotationConfigApplicationContext.refresh();
        Atest atest = annotationConfigApplicationContext.getBean(AtestImpl.class);
        atest.print();
    }
}
