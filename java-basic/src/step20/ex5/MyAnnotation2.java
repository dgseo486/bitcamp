package step20.ex5;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation2 {
    String[] v1() default {"가나다", "라마바"};
    int[] v2() default {100, 200};
    float[] v3() default {3.14f, 5.14f};
}
