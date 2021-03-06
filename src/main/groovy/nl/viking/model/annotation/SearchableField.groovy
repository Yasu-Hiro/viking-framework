package nl.viking.model.annotation

import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target

/**
 * User: mardo
 * Date: 10/15/14
 * Time: 9:59 AM
 */

@Retention(RetentionPolicy.RUNTIME)
@Target([ElementType.FIELD, ElementType.METHOD])
public @interface SearchableField {

	String name() default ""

	String type() default ""

	boolean like() default false

}