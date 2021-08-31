package gui.core.layout;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VerticalFlowLayout implements LayoutManager, java.io.Serializable {
    public static final int TOP = 0;

    public static final int CENTER = 1;

    public static final int BOTTOM = 2;

    int align;

    int hgap;

    int vgap;

    public VerticalFlowLayout() {
        this(CENTER, 5, 5);
    }

    public VerticalFlowLayout(int align) {
        this(align, 5, 5);
    }

    public VerticalFlowLayout(int align, int hgap, int vgap) {
        this.hgap = hgap;
        this.vgap = vgap;
        setAlignment(align);
    }

    public int getAlignment() {
        return align;
    }

    public void setAlignment(int align) {
        this.align = align;
    }

    public int getHgap() {
        return hgap;
    }

    public void setHgap(int hgap) {
        this.hgap = hgap;
    }

    public int getVgap() {
        return vgap;
    }

    public void setVgap(int vgap) {
        this.vgap = vgap;
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container target) {
        synchronized (target.getTreeLock()) {
            Dimension dim = new Dimension(0, 0);
            int nmembers = target.getComponentCount();
            boolean firstVisibleComponent = true;

            for (int i = 0; i < nmembers; i++) {
                Component m = target.getComponent(i);

                if (m.isVisible()) {
                    Dimension d = m.getPreferredSize();
                    dim.width = Math.max(dim.width, d.width);

                    if (firstVisibleComponent) {
                        firstVisibleComponent = false;
                    } else {
                        dim.height += vgap;
                    }

                    dim.height += d.height;
                }
            }

            Insets insets = target.getInsets();
            dim.width += insets.left + insets.right + hgap * 2;
            dim.height += insets.top + insets.bottom + vgap * 2;
            return dim;
        }
    }

    public Dimension minimumLayoutSize(Container target) {
        synchronized (target.getTreeLock()) {
            Dimension dim = new Dimension(0, 0);
            int nmembers = target.getComponentCount();
            boolean firstVisibleComponent = true;

            for (int i = 0; i < nmembers; i++) {
                Component m = target.getComponent(i);
                if (m.isVisible()) {
                    Dimension d = m.getMinimumSize();
                    dim.width = Math.max(dim.width, d.width);

                    if (firstVisibleComponent) {
                        firstVisibleComponent = false;
                    } else {
                        dim.height += vgap;
                    }

                    dim.height += d.height;
                }
            }


            Insets insets = target.getInsets();
            dim.width += insets.left + insets.right + hgap * 2;
            dim.height += insets.top + insets.bottom + vgap * 2;
            return dim;
        }
    }

    public void layoutContainer(Container target) {
        synchronized (target.getTreeLock()) {
            Insets insets = target.getInsets();
            int maxHeight = target.getSize().height - (insets.top + insets.bottom + vgap * 2);
            int nmembers = target.getComponentCount();
            int x = insets.left + hgap;
            int y = 0;
            int columnWidth = 0;
            int start = 0;

            boolean ttb = target.getComponentOrientation().isLeftToRight();

            for (int i = 0; i < nmembers; i++) {
                Component m = target.getComponent(i);

                if (m.isVisible()) {
                    Dimension d = m.getPreferredSize();
                    m.setSize(d.width, d.height);

                    if ((y == 0) || ((y + d.height) <= maxHeight)) {
                        if (y > 0) {
                            y += vgap;
                        }

                        y += d.height;
                        columnWidth = Math.max(columnWidth, d.width);
                    } else {
                        moveComponents(target, x, insets.top + vgap, columnWidth, maxHeight - y, start, i, ttb);
                        y = d.height;
                        x += hgap + columnWidth;
                        columnWidth = d.width;
                        start = i;
                    }
                }
            }

            moveComponents(target, x, insets.top + vgap, columnWidth, maxHeight - y, start, nmembers, ttb);
        }
    }

    private void moveComponents(
            Container target, int x, int y, int width, int height, int columnStart, int columnEnd, boolean ttb) {
        switch (align) {
            case TOP -> y += ttb ? 0 : height;
            case CENTER -> y += height / 2;
            case BOTTOM -> y += ttb ? height : 0;
        }

        for (int i = columnStart; i < columnEnd; i++) {
            Component m = target.getComponent(i);

            if (m.isVisible()) {
                int cx;
                cx = x + (width - m.getSize().width) / 2;

                if (ttb) {
                    m.setLocation(cx, y);
                } else {
                    m.setLocation(cx, target.getSize().height - y - m.getSize().height);
                }

                y += m.getSize().height + vgap;
            }
        }
    }

    public String toString() {
        String str = switch (align) {
            case TOP -> ",align=top";
            case CENTER -> ",align=center";
            case BOTTOM -> ",align=bottom";
            default -> "";
        };

        return getClass().getName() + "[hgap=" + hgap + ",vgap=" + vgap + str + "]";
    }
}