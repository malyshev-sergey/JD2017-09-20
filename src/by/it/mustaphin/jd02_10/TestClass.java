package by.it.mustaphin.jd02_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestClass {
    private String field = "FIELD";
    private List<String> list = new ArrayList<>(Arrays.asList("item 1", "item 2", "item 3"));

    public TestClass(String field, List<String> list) {
        this.field = field;
        this.list = list;
    }

    public TestClass() {
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String item : list) {
            sb.append(item).append("\n");
        }
        return "field: " + field + "\nlist:\n" + sb.toString();
    }
}
