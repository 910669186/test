package com.testerhome.api;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(Prod.class)
//ExcludeCategory 除了prod标签的都可以跑
//IncludeCategory 只运行prod标签的
@Suite.SuiteClasses({
        Children.class,
        Children2.class
})
public class AllSuite2 {
}
