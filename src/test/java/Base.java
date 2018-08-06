import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class Base {

    @BeforeClass
    public static void BeforeClass() {
        System.out.println("base BeforeClass");
    }

    @AfterClass
    public static void AfterClass() {
        System.out.println("base AfterClass");
    }

    @Test
    public void demo1() {
        System.out.println("demo1");
    }

    @Test
    public void demo0() {
        System.out.println("demo");
    }

    @Test
    public void demo2() {
        System.out.println("demo2");
    }
}
