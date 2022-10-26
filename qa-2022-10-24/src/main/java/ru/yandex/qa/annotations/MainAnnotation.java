package ru.yandex.qa.annotations;

import java.lang.annotation.*;

public class MainAnnotation {

    //@SuppressWarnings("all")
    public static void main(String[] args) {
        //Object o = null;
        //some logic
        //System.out.println(o.toString());

        //Thread thread = new Thread();
        //thread.start();
        //thread.stop();

        Class1 class1 = new Class1();
        Class<? extends Class1> aClass = class1.getClass();

        Annotation[] annotations = aClass.getAnnotations();
        MyAnnotation annotation = (MyAnnotation) annotations[0];
        System.out.println(annotation.message());
        System.out.println(annotation.value());

        Class2 class2 = new Class2();
        Class<? extends Class2> aClass1 = class2.getClass();

        MyAnnotation annotation1 = (MyAnnotation) aClass1.getMethods()[0].getAnnotations()[0];
        System.out.println(annotation1.message());
        System.out.println(annotation1.value());
    }

    @MyAnnotation(message = "Я message")
    public static class Class1 {

        public void method() {

        }
    }

    public static class Class2 extends Class1 {

        //@Override
        @MyAnnotation(message = "Я message над меьтодом у Class2", value = 200)
        public void method() {

        }
    }

    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.METHOD, ElementType.TYPE})
    public @interface MyAnnotation {
        String message();

        int value() default 100;
    }
}
