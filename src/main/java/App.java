import gui.Display;
import gui.util._Win;
import keyListaner.Capture;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

public class App {
    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        new _Win();
        new Display();

        try {
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());

            System.exit(1);
        }
        System.out.println(System.currentTimeMillis()-start);
        GlobalScreen.addNativeKeyListener(new Capture());

    }
}
