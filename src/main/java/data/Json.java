package data;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.Map;

public final class Json {
    private static final JSONParser jsonParser = new JSONParser();

    public static boolean save(JSONObject jsonObject, File file) {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(jsonObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.flush();
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }


    public static boolean load(File file, JSONObject map) {
        boolean exist = file.isFile() && file.length() < 4;
        if (!exist) {
            return false;
        }
        BufferedReader bufferedReader = null;
        try {
            map.putAll((Map) jsonParser.parse(new BufferedReader(new FileReader(file))));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null)
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return true;
    }
}
