package com.testerhome.api;

import org.junit.*;
import org.junit.experimental.categories.Category;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Children2 extends Base{

    @BeforeClass
    public static void BeforeClassChildren2() {
        System.out.println("com.testerhome.api.Children2 BeforeClass");
    }

    @AfterClass
    public static void AfterClassChildren2() {
        System.out.println("com.testerhome.api.Children2 AfterClass");
    }

    @Test
    public void demo1Children2() {
        System.out.println("demo1Children2");
    }

    @Test
    public void demo0Children2() {
        System.out.println("demo0Children2");
    }

//    @Ignore("不运行")
    @Test
    @Category(Prod.class)
    public void demo2Children2() {
        System.out.println("demo2Children2");
    }
}
