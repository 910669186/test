package restassured;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class DataDriverByYaml {
    @Parameterized.Parameters()
    public static List<DataClass> data() throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        List<DataClass> data = mapper.readValue(
//                new File(DataDriverByYaml.class.getResource("../data/input.yaml").getFile()),
                new File("D:/testDemo/a/src/main/resourcess/data/input.yaml"),
                new TypeReference<List<DataClass>>(){}
        );
        return data;
    }

    @Parameterized.Parameter
    public DataClass data;

    @Test
    public void demo() {
        assertThat(data.getCount(),  equalTo(Integer.parseInt(data.getKey())));

    }
}
