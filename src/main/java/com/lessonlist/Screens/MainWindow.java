package com.lessonlist.Screens;


import com.lessonlist.Utils.ClockButtonManager;
import com.lessonlist.Utils.ExceptionManager;
import com.lessonlist.MainActivity;
import com.lessonlist.Utils.FileControl;
import com.lessonlist.obj.Lesson;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.util.Calendar;

public class MainWindow extends JDialog {

    Calendar c = Calendar.getInstance();
    int week = c.get(Calendar.DAY_OF_WEEK);
    Lesson[] lessonList = FileControl.getLessonListFromJSON(week - 1);
    // clock
    WPanel clockPanel = new WPanel(1,28);
    // lessonPanel
    WPanel lessonPanel = new WPanel(lessonList.length * 2,28);

    Font lessonFont = FileControl.getFont(Font.PLAIN, MainActivity.globalConfig.getLessonFontSize());
    public MainWindow(int x,int y,int w,int h) throws HeadlessException {

        this.setUndecorated(true);
        this.setVisible(true);
        this.setName("电子课表设置主界面");
        this.setTitle("电子课表设置主界面");
        this.setBackground(new Color(0,0,0,0.0f));
        this.lessonPanel.setBackground(new Color(0,0,0,0.0f));

        this.setDefaultCloseOperation(this.HIDE_ON_CLOSE);
        this.setBounds(x,y,w,h);

        // this.setBounds(150,150,150,150);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));

        this.add(clockPanel);
        this.add(lessonPanel);

    }
    public void update(){
        this.updateLessonStatus();
        this.updateClockStatus();
        this.validate();
        this.repaint();

    }

    private void updateLessonStatus(){

        lessonPanel.removeAll();
        try {
            for (Lesson lesson : lessonList) {

                long sysMillis = System.currentTimeMillis();

                JButton lessonButt = new JButton(lesson.getName());

                lessonButt.setFont(lessonFont);


                if (lesson.getMillisTimeEnd() < sysMillis) {
                    /*new Color(148, 248, 125)*/
                    lessonButt.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(1, 13, 1, 0,
                            MainActivity.globalConfig.getPastLessonColor()),
                            BorderFactory.createEmptyBorder(5, 13, 5, 17)));
                } else if (lesson.getMillisTimeStart() > sysMillis) {
                    /*new Color(255, 88, 79)*/
                    lessonButt.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(1, 13, 1, 0,
                            MainActivity.globalConfig.getNextLessonColor()),
                            BorderFactory.createEmptyBorder(5, 13, 5, 17)));
                } else if (lesson.getMillisTimeStart() < sysMillis && lesson.getMillisTimeEnd() > sysMillis) {
                    /*new Color(234, 170, 99)*/
                    lessonButt.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(1, 13, 1, 0,
                            MainActivity.globalConfig.getPresentLessonColor()),
                            BorderFactory.createEmptyBorder(5, 13, 5, 17)));
                }

                lessonButt.setBackground(MainActivity.globalConfig.getNoAlphaWindowBgColor());

                lessonPanel.add(lessonButt);
            }
        }catch(ParseException e){
            ExceptionManager.showErrorDialog(e);
        }
    }

    private void updateClockStatus(){
        clockPanel.removeAll();
        clockPanel.add(ClockButtonManager.getWeekButton(week));
    }
}