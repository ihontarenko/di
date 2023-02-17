package pro.javadev.di;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Bean {

    String[] name() default {};

    String[] value() default {};

}
