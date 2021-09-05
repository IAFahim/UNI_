import gui.Display;
import gui.util._Win;

public class App {
    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        new _Win();
        new Display();
        System.out.println(System.currentTimeMillis()-start);
    }
}
