package restassured;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

@RunWith(Parameterized.class)
public class DataDriverByExcel {
    @Parameterized.Parameters
    public static List<DataClass> adata() throws IOException {
        ArrayList<DataClass> data = new ArrayList<>();

        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = mapper.schemaFor(DataClass.class);
        //mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
//        File csvFile = new File(DataDriverByExcel.class.getResource("D:/testDemo/a/src/main/resourcess/data/input.csv").getFile()); // or from String, URL etc
        File csvFile = new File("D:/testDemo/a/src/main/resourcess/data/input.csv");
        MappingIterator<DataClass> it = mapper.readerFor(DataClass.class).with(schema).readValues(csvFile);
        while (it.hasNext()) {
            DataClass row = it.next();
            data.add(row);
        }
        return data;
    }

    @Parameterized.Parameter
    public DataClass data;

    @Test
    public void demo() {
        assertThat(data.getCount(),  equalTo(data.getKey()));

    }
}
