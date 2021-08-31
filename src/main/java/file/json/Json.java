package file.json;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;

public final class Json {

    public static void saveJson(Map<String, Object> map, File file) {
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        if (map == null || map.size() == 0) {
            sb.append('}');
        } else {
            int size = map.size(), at = 0;
            for (Object o : map.keySet()) {
                sb.append('"').append(o).append('"').append(':');
                if (!(map.get(o) instanceof ArrayList)) {
                    Object x=map.get(o);
                    if (x instanceof Number || x instanceof Boolean) {
                        sb.append(x);
                    } else {
                        sb.append('"').append(x).append('"');
                    }
                } else {
                    sb.append('[');
                    ArrayList<Object> list= (ArrayList<Object>) map.get(o);
                    int j=0,s=list.size();
                    for (Object value : list) {
                        if (value instanceof Number || value instanceof Boolean) {
                            sb.append(value);
                        } else {
                            sb.append('"').append(value).append('"');
                        }
                        if (s != ++j) {
                            sb.append(',');
                        }
                    }
                    sb.append(']');
                }
                sb.append((size != ++at) ? ',' : '}');
            }
        }
        if (file != null)
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file.getPath()),sb.length())) {
                bw.append(sb);
                bw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public static boolean loadJson(File file,Map map) {
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
