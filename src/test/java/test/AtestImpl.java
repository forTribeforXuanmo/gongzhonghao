package test;

import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017-7-19.
 *
 * @deprecated
 */
@Component
public class AtestImpl implements Atest {
    @Override
    public void print() {
        System.out.println("哈哈哈");
    }
}
