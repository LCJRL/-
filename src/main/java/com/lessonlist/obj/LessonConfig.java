package com.lessonlist.obj;

import com.lessonlist.Utils.FileControl;

import javax.swing.*;
import java.awt.*;

public class LessonConfig {
    private final JTextField name = new JTextField(10);
    private final JTextField timeStart = new JTextField(10);
    private final JTextField timeEnd = new JTextField(10);
    private final JCheckBox isEnabled = new JCheckBox();

    public LessonConfig(Lesson l, boolean i) {
        Font font = FileControl.getFont(Font.PLAIN, 14);
        name.setFont(font);
        timeStart.setFont(font);
        timeEnd.setFont(font);

        if (i) {
            name.setText(l.getName());
            timeStart.setText(l.getTimeStart());
            timeEnd.setText(l.getTimeEnd());
        } else {
            name.setText("missingno");
            timeStart.setText("missingno");
            timeEnd.setText("missingno");
        }
        isEnabled.setSelected(i);
    }

    public boolean isEnabled(){
        return isEnabled.isSelected();
    }

    public JTextField getName() {
        return name;
    }

    public JTextField getTimeStart() {
        return timeStart;
    }

    public JTextField getTimeEnd() {
        return timeEnd;
    }

    public JCheckBox getIsEnabled() {
        return isEnabled;
    }

}
