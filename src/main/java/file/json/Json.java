package file.json;

import java.io.*;
import java.util.Map;

public final class Json {

    public static void mapToJsonFile(Map<String, Object> map, File file) {
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        if (map == null || map.size() == 0) {
            sb.append('}');
        } else {
            int size = map.size(), at = 0;
            for (Object o : map.keySet()) {
                sb.append('"').append(o).append('"').append(':').append('"').append(map.get(o)).append('"').append((size != ++at) ? ',' : '}');
            }
        }
        if (file != null)
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file.getPath()))) {
                bw.append(sb);
                bw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public static boolean jsonFileToMap(Map map, File file) {
        boolean exist=file.isFile();
        if (exist) {
            try (SimpleJsonFileReader sc = new SimpleJsonFileReader(file)) {
                while (sc.hasNext) {
                    map.put(sc.nextString(), sc.nextString());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return exist;
    }
}
