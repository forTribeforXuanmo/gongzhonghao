package test;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2017-7-19.
 *
 * @deprecated
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAnnotation {
    String value() default "lsz";
}
