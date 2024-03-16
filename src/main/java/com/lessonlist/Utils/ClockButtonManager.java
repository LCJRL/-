package com.lessonlist.Utils;

import com.lessonlist.MainActivity;
import com.lessonlist.Screens.MainConfigScreen;

import javax.swing.*;
import java.awt.*;

public class ClockButtonManager {
    static String[] weeks = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};

    static Font font1 = FileControl.getFont(Font.PLAIN, MainActivity.globalConfig.getClockFontsize() - 1);

    public static JButton getWeekButton(int week){
        JButton j = new JButton(weeks[week - 1]);
        j.setFont(font1);
        j.setBackground(MainActivity.globalConfig.getWindowBgColor());
        j.addActionListener(e -> {
            MainConfigScreen mainConfigScreen = new MainConfigScreen();
            mainConfigScreen.setVisible(true);
        });
        return j;

    }
}
