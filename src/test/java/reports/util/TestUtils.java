package reports.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class TestUtils {

    public static List<String> readTextResource(String resourcePath) throws IOException {
        InputStream inputStream = TestUtils.class.getClassLoader().getResourceAsStream(resourcePath);

        if (inputStream == null)
            throw new IllegalArgumentException("Resource not found " + resourcePath);

        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

        List<String> lines = br.lines().toList();

        br.close();

        return lines;
    }
}
