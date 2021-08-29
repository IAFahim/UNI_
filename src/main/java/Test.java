import file.json.Json;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<String, Object> map=new LinkedHashMap<>();
        Json.jsonFileToMap(map,new File("src/main/java/data/db/gui.json"));
        for (Object o : map.keySet()) {
            System.out.println(String.valueOf(map.get(o).getClass()));
        }


    }
}
