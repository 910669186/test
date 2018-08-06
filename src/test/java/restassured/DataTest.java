package restassured;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

@RunWith(Parameterized.class)
public class DataTest {

    @Parameterized.Parameters(name = "{0} vs {1}")
    public static Integer[][] data() {
        return new Integer[][]{
                {0, 0}, {1, 1}, {2, 3}
        };
    }

    @Parameterized.Parameter
    public int fInput;

    @Parameterized.Parameter(1)
    public int fExpected;

    @Test
    public void testDemo() {
        assertThat(fInput, equalTo(fExpected));
    }
}
