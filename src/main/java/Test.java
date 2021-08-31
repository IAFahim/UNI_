import file.json.Json;

import java.io.File;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        Map<String, Object> map=new LinkedHashMap<>();
        Json.loadJson(new File("src/main/java/data/db/gui.json"),map);
        for (Object o : map.keySet()) {
            System.out.println(String.valueOf(map.get(o).getClass()));
        }


    }
}
