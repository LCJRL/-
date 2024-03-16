package com.lessonlist;

import com.lessonlist.obj.WindowConfig;
import com.lessonlist.Screens.MainWindow;
import com.lessonlist.Utils.ExceptionManager;
import com.lessonlist.Utils.FileControl;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity {

    public static WindowConfig globalConfig = FileControl.getWindowConfig();
    public static Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    public static String base_version = "v1.3";
    public static String product_version = "v1.3.1";
    public static MainWindow window;

    public static void main(String[] args){
        Thread.setDefaultUncaughtExceptionHandler(new CustomExceptionHandler());

        window = new MainWindow((int)d.getWidth() - globalConfig.getPosx(),globalConfig.getPosy(),globalConfig.getWeight(),(int)d.getHeight() - globalConfig.getHeight());

        Timer timer = new Timer();

        // 主循环
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                updateA();
            }

            private void updateA() {
                window.update();
            }
        },1,1000);


        }
    }

class CustomExceptionHandler implements Thread.UncaughtExceptionHandler{

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        ExceptionManager.showErrorDialog(e);
    }
}