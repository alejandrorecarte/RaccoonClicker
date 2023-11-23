package view;

import javax.swing.*;
import java.awt.*;

public class ButtonRenderer extends JButton implements ListCellRenderer<Object> {
    public ButtonRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                  boolean isSelected, boolean cellHasFocus) {
        setText((value == null) ? "" : value.toString());
        return this;
    }
}
