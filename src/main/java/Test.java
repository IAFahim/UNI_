import data.Json;
import org.json.simple.JSONObject;

import java.io.File;
import java.util.*;

public class Test {
    static int a=5;
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        Json.load(new File("src/main/java/data/db/random.json"),jsonObject);
        System.out.println(jsonObject.toString());
    }
}
