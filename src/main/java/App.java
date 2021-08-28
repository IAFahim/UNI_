import gui.main.Display;
import gui.main.util.GuiDataLoader;

public class App {
    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        Display window=new Display(new GuiDataLoader());
        System.out.println(System.currentTimeMillis()-start);
    }
}
