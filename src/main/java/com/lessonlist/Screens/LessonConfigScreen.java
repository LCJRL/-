package com.lessonlist.Screens;

import com.lessonlist.Utils.ExceptionManager;
import com.lessonlist.Utils.FileControl;
import com.lessonlist.obj.Lesson;
import com.lessonlist.obj.LessonConfig;

import javax.swing.*;
import java.awt.*;

public class LessonConfigScreen extends JDialog {
    private final Lesson[] lessons;

    private final LessonConfig[] configs = new LessonConfig[15];

    private final int dateOfWeek;
    private static final String[] weeks = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};

    public LessonConfigScreen(Lesson[] lessons,String date) {
        super((Frame) null, "课程配置界面", true);
        this.lessons = lessons;
        this.dateOfWeek = getDateNumFromString(date);
        initialize();
    }

    private void initialize() {
        // setTitle("配置课程列表页面");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(6, 6, 6, 6);

        // 添加标签
        JLabel titleLabel = new JLabel("配置课表");
        Font titleFont = FileControl.getFont(Font.BOLD,26);
        titleLabel.setFont(titleFont);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 5;
        panel.add(titleLabel, constraints);

        JLabel titleLabel2 = new JLabel("你正在修改 " + weeks[dateOfWeek] + " 的课表");
        titleFont = FileControl.getFont(Font.PLAIN,22);
        titleLabel2.setFont(titleFont);
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(titleLabel2, constraints);

        JLabel titleLabel3 = new JLabel("要使修改生效，你需要重启电子课表程序");
        titleLabel3.setFont(titleFont);
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(titleLabel3, constraints);

        JLabel titleLabel4 = new JLabel("如果点击保存后无法退出，配置内容有问题，需重新修改");
        titleFont = FileControl.getFont(Font.PLAIN,15);
        titleLabel4.setFont(titleFont);
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(titleLabel4, constraints);

        constraints.gridwidth = 1;

        JLabel headLablel = new JLabel("名称");
        titleFont = FileControl.getFont(Font.BOLD,18);
        headLablel.setFont(titleFont);
        constraints.gridx = 0;
        constraints.gridy = 4;
        panel.add(headLablel, constraints);

        JLabel headLabel3 = new JLabel("开始时间");
        headLabel3.setFont(titleFont);
        constraints.gridx = 1;
        constraints.gridy = 4;
        panel.add(headLabel3, constraints);

        JLabel headLabel4 = new JLabel("结束时间");
        headLabel4.setFont(titleFont);
        constraints.gridx = 2;
        constraints.gridy = 4;
        panel.add(headLabel4, constraints);

        JLabel headLabel5 = new JLabel("是否启用本课程");
        headLabel5.setFont(titleFont);
        constraints.gridx = 3;
        constraints.gridy = 4;
        panel.add(headLabel5, constraints);

        // 添加课表配置项
        for (int j = 0;j < 15;j++){
            if(j < lessons.length) {
                configs[j] = new LessonConfig(lessons[j], true);
            }else {
                configs[j] = new LessonConfig(null, false);
            }
            constraints.gridy = j + 5;
            constraints.gridx = 0;
            panel.add(configs[j].getName(),constraints);
            constraints.gridx = 1;
            panel.add(configs[j].getTimeStart(),constraints);
            constraints.gridx = 2;
            panel.add(configs[j].getTimeEnd(),constraints);
            constraints.gridx = 3;
            panel.add(configs[j].getIsEnabled(),constraints);

        }

        // Save button
        JButton saveButton = new JButton("不退出程序并保存配置");
        titleFont = FileControl.getFont(Font.BOLD,16);
        saveButton.setFont(titleFont);
        saveButton.addActionListener(e -> saveConfig(false));
        constraints.gridx = 0;
        constraints.gridy = 20;
        constraints.gridwidth = 2;
        panel.add(saveButton, constraints);

        JButton saveARButton = new JButton("退出程序并保存配置");
        saveARButton.setFont(titleFont);
        saveARButton.addActionListener(e -> saveConfig(true));
        constraints.gridx = 2;
        constraints.gridy = 20;
        constraints.gridwidth = 2;
        panel.add(saveARButton, constraints);

        // updateWindow
        add(panel);
        pack();
        setLocationRelativeTo(null);

    }

    private void saveConfig(boolean isRestart) {
        int notNullCount = 0;

        for (LessonConfig l:
             configs) {
            if(l.isEnabled()){
                notNullCount++;
            }
        }

        Lesson[] newLessonList = new Lesson[notNullCount];

        for(int k = 0;k < configs.length;k++){
            if(configs[k].isEnabled()){
                newLessonList[k] = new Lesson();
                newLessonList[k].setName(configs[k].getName().getText());
                newLessonList[k].setTimeStart(configs[k].getTimeStart().getText());
                newLessonList[k].setTimeEnd(configs[k].getTimeEnd().getText());
            }
        }

        FileControl.writeLessonListToJson(newLessonList,dateOfWeek);

        dispose(); // 关闭配置窗口

        if(isRestart){
            System.exit(0);
        }
    }
    public static int getDateNumFromString(String date){
        int dateInt = -1;
        for (int i = 0;i < weeks.length;i++){
            if (weeks[i].equals(date)){
                dateInt = i;
                break;
            }
        }
        if (dateInt == -1) {
            ExceptionManager.showErrorDialog(new InternalError("非法的日期字符串!"));
        }
        return dateInt;
    }
}
