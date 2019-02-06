/*
 * Tarik El Bannany  Copyright (c) 12/13/18 3:59 PM.
 */

package net.xfantome.rain;


import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Documented
public @interface RainRow {
    String name() default "";

    String[] child() default {};

    boolean include() default true;
    
    String dateTimeFormat() default "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
}
