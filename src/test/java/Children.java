import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Children extends Base{

    @BeforeClass
    public static void BeforeClassChildren() {
        System.out.println("Children BeforeClass");
    }

    @AfterClass
    public static void AfterClassChildren() {
        System.out.println("Children AfterClass");
    }

    @Test
    public void demo1Children() {
        System.out.println("demo1Children");
    }

    @Test
    public void demo0Children() {
        System.out.println("demo0Children");
    }

    @Test
    public void demo2Children() {
        System.out.println("demo2Children");
    }
}
