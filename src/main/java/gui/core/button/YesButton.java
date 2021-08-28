package gui.core.button;

import gui.core.button.util.GBData;
import gui.setup.util._Win;

import javax.swing.*;
import java.awt.*;

public class YesButton extends GBData {

    public YesButton(){
        text="Yes";
        init(94.5,54.5,112,43);
        color=new Color(42, 151, 238);
        font=new Font(_Win.getFont(),Font.BOLD,scaleY(24));
        fontColor=Color.WHITE;
    }

    public void add(JFrame jFrame) {
        super.add(jFrame);
    }
}
