package file.util;

public final class Cast {
    public static int asInt(Object o) {
        return Integer.parseInt((String) o);
    }
    public static boolean asBool(Object o) {
        return Boolean.parseBoolean((String) o);
    }
}
