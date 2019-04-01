/*
 * @Copyright: 2005-2018 www.2345.com. All rights reserved.
 */
package com.goudong.filter;

import java.lang.annotation.*;

/**
 * @author chentl
 * @version CrossOrigin, v0.1 2019/4/1 10:15
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CrossOrigin {

}
