import gui.Display;
import gui.util.GuiDataLoader;

public class App {
    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        new GuiDataLoader();
        new Display();
        System.out.println(System.currentTimeMillis()-start);
    }
}
