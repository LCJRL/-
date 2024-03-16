package com.lessonlist.Screens;

import javax.swing.*;
import java.awt.*;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Calendar;

public class ExceptionInfoScreen extends JDialog {

    public ExceptionInfoScreen(Exception exception) {
        super((Frame) null, true);
        setTitle("错误了！！！ Unexpected Exception: " + exception.getMessage());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setFont(new Font(null,Font.BOLD,28));

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        exception.printStackTrace(pw);
        String stackTrace = sw.toString();

        String crashInfo = "The Desktop Lesson List Program encountered an unexpected exception at " + Calendar.getInstance().getTime()
                + "\n\n" + "Below is the stacktrace of the error: \n\n"
                + stackTrace;


        textArea.setText(crashInfo);

        // 按钮
        JButton aContinue = new JButton("取消并继续");
        JButton quitProgram = new JButton("退出程序");

        aContinue.addActionListener(e -> dispose());

        quitProgram.addActionListener(e -> System.exit(0));


        // 布局
        setLayout(new BorderLayout());
        add(scrollPane,BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(aContinue);
        buttonPanel.add(quitProgram);

        add(buttonPanel, BorderLayout.SOUTH);

        setSize(1280,800);
        setVisible(false);
    }

}
