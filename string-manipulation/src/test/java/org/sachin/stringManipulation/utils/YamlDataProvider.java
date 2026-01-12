package org.sachin.stringManipulation.utils;

import org.testng.annotations.DataProvider;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class YamlDataProvider {

    @DataProvider(name = "reverserData")
    public Object[][] yamlTests() {

        Yaml yaml = new Yaml();

        InputStream input =
                getClass().getClassLoader().getResourceAsStream("testdata/StringReverser.yaml");

        Map<String, List<Map<String, String>>> root = yaml.load(input);

        List<Map<String, String>> list = root.get("tests");

        Object[][] data = new Object[list.size()][3];

        for (int i = 0; i < list.size(); i++) {
            Map<String, String> item = list.get(i);
            data[i][0] = item.get("name");
            data[i][1] = item.get("input");
            data[i][2] = item.get("expected");
        }

        return data;
    }
}
