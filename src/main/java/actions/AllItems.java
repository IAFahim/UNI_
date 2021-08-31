package actions;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public final class AllItems {
    public static void print(MouseEvent e){
        System.out.println(e.getSource());
        System.out.println(Thread.currentThread().getName());
    }
}
