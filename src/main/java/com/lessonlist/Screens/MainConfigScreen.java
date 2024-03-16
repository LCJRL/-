package com.lessonlist.Screens;

import com.lessonlist.Utils.FileControl;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;

public class MainConfigScreen extends JDialog {
    Font fontS = FileControl.getFont(Font.BOLD,20);
    Font fontL = FileControl.getFont(Font.BOLD,26);

    String targetDay = "星期一";
    public MainConfigScreen(){
        super((Frame) null, "设置", true);
        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(7,7,7,7);

        JLabel titleLable1 = new JLabel("主配置页面");
        titleLable1.setFont(fontL);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 3;
        panel.add(titleLable1,constraints);

        JLabel titleLable2 = new JLabel("你可在此配置电子课表程序");
        titleLable2.setFont(FileControl.getFont(Font.PLAIN,20));
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 3;
        panel.add(titleLable2,constraints);

        constraints.gridwidth = 1;
        JButton windowConfigButton = new JButton("窗口配置");
        windowConfigButton.addActionListener(e -> {
            GeneralConfigScreen generalConfigScreen = new GeneralConfigScreen();
            generalConfigScreen.setVisible(true);
        });
        windowConfigButton.setFont(fontS);
        constraints.gridx = 0;
        constraints.gridy = 5;
        panel.add(windowConfigButton,constraints);

        JComboBox<String> box = new JComboBox<>(new String[]{"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"});
        box.setFont(fontS);
        constraints.gridx = 0;
        constraints.gridy = 4;
        panel.add(box,constraints);

        JButton lessonConfigButton = new JButton("配置课表");
        lessonConfigButton.addActionListener(e -> {
            targetDay = (String) box.getSelectedItem();
            LessonConfigScreen lessonConfigScreen = new LessonConfigScreen(FileControl.getLessonListFromJSON(LessonConfigScreen.getDateNumFromString(targetDay)), targetDay);
            lessonConfigScreen.setVisible(true);
        });
        lessonConfigButton.setFont(fontS);
        constraints.gridx = 1;
        constraints.gridy = 4;
        panel.add(lessonConfigButton,constraints);

        JButton quitButton = new JButton("退出程序");
        quitButton.addActionListener(e -> System.exit(0));
        quitButton.setFont(fontS);
        constraints.gridx = 1;
        constraints.gridy = 5;
        panel.add(quitButton,constraints);

        JLabel titleLable3 = new JLabel("原软件作者：Widji");
        titleLable3.setForeground(new Color(40, 112, 215));
        titleLable3.setFont(FileControl.getFont(Font.PLAIN,12));
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        panel.add(titleLable3,constraints);
        titleLable3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://github.com/Wudji/Desktop-Lesson-List/"));
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        JLabel titleLable4 = new JLabel("该软件作者：LCJRL");
        titleLable4.setForeground(new Color(40, 112, 215));
        titleLable4.setFont(FileControl.getFont(Font.PLAIN,12));
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        panel.add(titleLable4,constraints);
        titleLable4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI(""));
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        add(panel);
        pack();
        setLocationRelativeTo(null);

    }
}
