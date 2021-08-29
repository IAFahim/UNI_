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
                sb.append('"').append(o).append('"').append(':');
                if (!map.get(o).getClass().isArray()) {
                    Object x=map.get(o);
                    if (x instanceof Number) {
                        sb.append(x);
                    } else {
                        sb.append('"').append(x).append('"');
                    }
                } else {
                    sb.append('[');
                    Object[] objects= (Object[]) map.get(o);
                    int j=0,s=objects.length;
                    for (int i = 0; i < objects.length; i++) {
                        if (objects[i] instanceof Number) {
                            sb.append(objects[i]);
                        } else {
                            sb.append('"').append(objects[i]).append('"');
                        }
                        if(s!=++j){
                            sb.append(',');
                        }
                    }
                    sb.append(']');
                }
                sb.append((size != ++at) ? ',' : '}');
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
        int read=0;
        boolean exist = file.isFile();
        if (exist) {
            try (SimpleJsonFileReader sc = new SimpleJsonFileReader(file)) {
                while (sc.hasNext) {
                    map.put(sc.nextString(), sc.nextObject());
                    read++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return exist && read>0;
    }
}
