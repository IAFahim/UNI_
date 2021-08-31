package gui.core.layout;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class VerticalFlowLayout implements LayoutManager, java.io.Serializable
{
    /**
     * This value indicates that each row of components
     * should be left-justified.
     */
    public static final int TOP     = 0;

    /**
     * This value indicates that each row of components
     * should be centered.
     */
    public static final int CENTER    = 1;

    /**
     * This value indicates that each row of components
     * should be right-justified.
     */
    public static final int BOTTOM     = 2;

    /**
     * <code>align</code> is the property that determines
     * how each column distributes empty space.
     * It can be one of the following three values:
     * <ul>
     * <code>TOP</code>
     * <code>BOTTOM</code>
     * <code>CENTER</code>
     * </ul>
     *
     * @see #getAlignment
     * @see #setAlignment
     */
    int align;     // This is the one we actually use

    /**
     * The flow layout manager allows a seperation of
     * components with gaps.  The horizontal gap will
     * specify the space between components and between
     * the components and the borders of the
     * <code>Container</code>.
     *
     * @see #getHgap()
     * @see #setHgap(int)
     */
    int hgap;

    /**
     * The flow layout manager allows a seperation of
     * components with gaps.  The vertical gap will
     * specify the space between rows and between the
     * the rows and the borders of the <code>Container</code>.
     *
     * @see #getHgap()
     * @see #setHgap(int)
     */
    int vgap;

    /**
     * Constructs a new <code>VerticalFlowLayout</code> with a centered alignment and a
     * default 5-unit horizontal and vertical gap.
     */
    public VerticalFlowLayout()
    {
        this(CENTER, 5, 5);
    }

    /**
     * Constructs a new <code>VerticalFlowLayout</code> with the specified
     * alignment and a default 5-unit horizontal and vertical gap.
     * The value of the alignment argument must be one of
     * <code>VerticalFlowLayout.TOP</code>, <code>VerticalFlowLayout.BOTTOM</code>,
     * or <code>VerticalFlowLayout.CENTER</code>
     * @param align the alignment value
     */
    public VerticalFlowLayout(int align)
    {
        this(align, 5, 5);
    }

    /**
     * Creates a new flow layout manager with the indicated alignment
     * and the indicated horizontal and vertical gaps.
     * <p>
     * The value of the alignment argument must be one of
     * <code>VerticalFlowLayout.TOP</code>, <code>VerticalFlowLayout.BOTTOM</code>,
     * or <code>VerticalFlowLayout.CENTER</code>.
     * @param     align   the alignment value
     * @param     hgap  the horizontal gap between components
     *                   and between the components and the
     *                   borders of the <code>Container</code>
     * @param     vgap  the vertical gap between components
     *                   and between the components and the
     *                   borders of the <code>Container</code>
     */
    public VerticalFlowLayout(int align, int hgap, int vgap)
    {
        this.hgap = hgap;
        this.vgap = vgap;
        setAlignment(align);
    }

    public int getAlignment()
    {
        return align;
    }

    public void setAlignment(int align)
    {
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

    public Dimension preferredLayoutSize(Container target)
    {
        synchronized (target.getTreeLock())
        {
            Dimension dim = new Dimension(0, 0);
            int nmembers = target.getComponentCount();
            boolean firstVisibleComponent = true;

            for (int i = 0 ; i < nmembers ; i++)
            {
                Component m = target.getComponent(i);

                if (m.isVisible())
                {
                    Dimension d = m.getPreferredSize();
                    dim.width = Math.max(dim.width, d.width);

                    if (firstVisibleComponent)
                    {
                        firstVisibleComponent = false;
                    }
                    else
                    {
                        dim.height += vgap;
                    }

                    dim.height += d.height;
                }
            }

            Insets insets = target.getInsets();
            dim.width += insets.left + insets.right + hgap*2;
            dim.height += insets.top + insets.bottom + vgap*2;
            return dim;
        }
    }

    /**
     * Returns the minimum dimensions needed to layout the <i>visible</i>
     * components contained in the specified target container.
     * @param target the container that needs to be laid out
     * @return  the minimum dimensions to lay out the
     *          subcomponents of the specified container
     * @see #preferredLayoutSize
     * @see    java.awt.Container
     * @see    java.awt.Container#doLayout
     */
    public Dimension minimumLayoutSize(Container target)
    {
        synchronized (target.getTreeLock())
        {
            Dimension dim = new Dimension(0, 0);
            int nmembers = target.getComponentCount();
            boolean firstVisibleComponent = true;

            for (int i = 0 ; i < nmembers ; i++)
            {
                Component m = target.getComponent(i);
                if (m.isVisible())
                {
                    Dimension d = m.getMinimumSize();
                    dim.width = Math.max(dim.width, d.width);

                    if (firstVisibleComponent)
                    {
                        firstVisibleComponent = false;
                    }
                    else
                    {
                        dim.height += vgap;
                    }

                    dim.height += d.height;
                }
            }


            Insets insets = target.getInsets();
            dim.width += insets.left + insets.right + hgap*2;
            dim.height += insets.top + insets.bottom + vgap*2;
            return dim;
        }
    }

    /**
     * Lays out the container. This method lets each
     * <i>visible</i> component take
     * its preferred size by reshaping the components in the
     * target container in order to satisfy the alignment of
     * this <code>VerticalFlowLayout</code> object.
     *
     * @param target the specified component being laid out
     * @see Container
     * @see    java.awt.Container#doLayout
     */
    public void layoutContainer(Container target)
    {
        synchronized (target.getTreeLock())
        {
            Insets insets = target.getInsets();
            int maxHeight = target.getSize().height - (insets.top + insets.bottom + vgap*2);
            int nmembers = target.getComponentCount();
            int x = insets.left + hgap;
            int y = 0;
            int columnWidth = 0;
            int start = 0;

            boolean ttb = target.getComponentOrientation().isLeftToRight();

            for (int i = 0 ; i < nmembers ; i++)
            {
                Component m = target.getComponent(i);

                if (m.isVisible())
                {
                    Dimension d = m.getPreferredSize();
                    m.setSize(d.width, d.height);

                    if ((y == 0) || ((y + d.height) <= maxHeight))
                    {
                        if (y > 0)
                        {
                            y += vgap;
                        }

                        y += d.height;
                        columnWidth = Math.max(columnWidth, d.width);
                    }
                    else
                    {
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

    /**
     * Centers the elements in the specified row, if there is any slack.
     * @param target the component which needs to be moved
     * @param x the x coordinate
     * @param y the y coordinate
     * @param width the width dimensions
     * @param height the height dimensions
     * @param columnStart the beginning of the column
     * @param columnEnd the the ending of the column
     */
    private void moveComponents(
            Container target, int x, int y, int width, int height, int columnStart, int columnEnd, boolean ttb)
    {
        switch (align) {
            case TOP -> y += ttb ? 0 : height;
            case CENTER -> y += height / 2;
            case BOTTOM -> y += ttb ? height : 0;
        }

        for (int i = columnStart ; i < columnEnd ; i++)
        {
            Component m = target.getComponent(i);

            if (m.isVisible())
            {
                int cx;
                cx = x + (width - m.getSize().width) / 2;

                if (ttb)
                {
                    m.setLocation(cx, y);
                }
                else
                {
                    m.setLocation(cx, target.getSize().height - y - m.getSize().height);
                }

                y += m.getSize().height + vgap;
            }
        }
    }

    /**
     * Returns a string representation of this <code>VerticalFlowLayout</code>
     * object and its values.
     * @return   a string representation of this layout
     */
    public String toString()
    {
        String str = switch (align) {
            case TOP -> ",align=top";
            case CENTER -> ",align=center";
            case BOTTOM -> ",align=bottom";
            default -> "";
        };

        return getClass().getName() + "[hgap=" + hgap + ",vgap=" + vgap + str + "]";
    }


    public static void main(String[] args)
    {
        JPanel main = new JPanel( new BorderLayout() );

        final JPanel buttons = new JPanel(new VerticalFlowLayout() );
//      buttons.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        main.add(buttons, BorderLayout.CENTER);

        for (int i = 0; i < 7; i++)
        {
            buttons.add( new JRadioButton("button " + i) );
        }

        JButton button = new JButton("Add Radio Button");
        main.add(button, BorderLayout.SOUTH);
        button.addActionListener( new ActionListener()
        {
            private int i = 8;

            public void actionPerformed(ActionEvent e)
            {
                buttons.add( new JRadioButton("button R Us" + i++) );
                buttons.revalidate();
//              pack();
            }
        });

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(main);
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


}