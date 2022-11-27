package junitTestLianxi;


import org.junit.*;

import static org.junit.Assert.assertTrue;


public class calculatorTest {

    //beforeclass必须为public static，全局只执行一次
    @BeforeClass
    public static void beforeClassTest() {
        System.out.println("before class");

    }
    //before 必须为public，每次执行前必须执行一次
    @Before
    public void beforeTest() {
        System.out.println("before");
    }

    @Test
    public void addTest() {
        calculator cal = new calculator();
        assertTrue(cal.add(1, 2) == 3);
        assertTrue(cal.add(2, 3) == 5);
        System.out.println("add");
    }

    @Test
    public void reduceTest() {
        calculator cal = new calculator();
        assertTrue(cal.reduce(1, 2) == -1);
        System.out.println("reduce");
    }

    @After
    public void afterTest(){
        System.out.println("after");
    }

    @AfterClass
    public static void afterClassTest(){
        System.out.println("afterClass");
    }
}