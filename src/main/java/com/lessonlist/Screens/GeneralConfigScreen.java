package com.lessonlist.Screens;

import com.lessonlist.MainActivity;
import com.lessonlist.Utils.FileControl;
import com.lessonlist.obj.WindowConfig;

import javax.swing.*;
import java.awt.*;

public class GeneralConfigScreen extends JDialog {
    private final WindowConfig config = MainActivity.globalConfig;
    private JTextField clockFontSizeField;
    private JTextField lessonFontSizeField;
    private JTextField posxField;
    private JTextField posyField;
    private JTextField weightField;
    private JTextField heightField;

    public GeneralConfigScreen() {
        super((Frame) null, "窗口配置界面", true);
        initialize();
    }

    private void initialize() {
        // setTitle("通用配置页面");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(8, 8, 8, 8);

        // Add components to the panel
        // 添加标题标签
        JLabel titleLabel = new JLabel("窗口配置");
        Font titleFont = FileControl.getFont(Font.BOLD, 26);
        titleLabel.setFont(titleFont);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 6;
        panel.add(titleLabel, constraints);

        JLabel titleLabel2 = new JLabel("需要重启程序以生效");
        titleFont = FileControl.getFont(Font.BOLD, 20);
        titleLabel2.setFont(titleFont);
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(titleLabel2, constraints);

        JLabel titleLabel3 = new JLabel("如果无法退出该页面，是配置内容有问题，请重新修改");
        titleFont = FileControl.getFont(Font.PLAIN,10);
        titleLabel3.setFont(titleFont);
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(titleLabel3, constraints);

        Font infoFont = FileControl.getFont(Font.BOLD, 16);
        Font inputFont = FileControl.getFont(Font.PLAIN, 15);
        JLabel clockFontSizeLabel = new JLabel("时钟字体大小:");
        clockFontSizeLabel.setFont(infoFont);
        clockFontSizeField = new JTextField(10);
        clockFontSizeField.setText(String.valueOf(config.getClockFontsize()));
        clockFontSizeField.setFont(inputFont);
        constraints.gridwidth = 1;
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(clockFontSizeLabel, constraints);
        constraints.gridx = 1;
        constraints.gridy = 3;
        panel.add(clockFontSizeField, constraints);

        // Lesson Font Size
        JLabel lessonFontSizeLabel = new JLabel("课表字体大小:");
        lessonFontSizeLabel.setFont(infoFont);
        lessonFontSizeField = new JTextField(10);
        lessonFontSizeField.setText(String.valueOf(config.getLessonFontSize()));
        lessonFontSizeField.setFont(inputFont);
        constraints.gridx = 0;
        constraints.gridy = 4;
        panel.add(lessonFontSizeLabel, constraints);
        constraints.gridx = 1;
        constraints.gridy = 4;
        panel.add(lessonFontSizeField, constraints);

        // posx
        JLabel posxLabel = new JLabel("主窗口坐标X:");
        posxLabel.setFont(infoFont);
        posxField = new JTextField(10);
        posxField.setText(String.valueOf(config.getPosx()));
        posxField.setFont(inputFont);
        constraints.gridx = 0;
        constraints.gridy = 5;
        panel.add(posxLabel, constraints);
        constraints.gridx = 1;
        constraints.gridy = 5;
        panel.add(posxField, constraints);

        // posy
        JLabel posyLabel = new JLabel("主窗口坐标Y:");
        posyLabel.setFont(infoFont);
        posyField = new JTextField(10);
        posyField.setText(String.valueOf(config.getPosy()));
        posyField.setFont(inputFont);
        constraints.gridx = 0;
        constraints.gridy = 6;
        panel.add(posyLabel, constraints);
        constraints.gridx = 1;
        constraints.gridy = 6;
        panel.add(posyField, constraints);

        JLabel weightLabel = new JLabel("主窗口宽度:");
        weightLabel.setFont(infoFont);
        weightField = new JTextField(10);
        weightField.setText(String.valueOf(config.getWeight()));
        weightField.setFont(inputFont);
        constraints.gridx = 0;
        constraints.gridy = 7;
        panel.add(weightLabel, constraints);
        constraints.gridx = 1;
        constraints.gridy = 7;
        panel.add(weightField, constraints);

        JLabel heightLabel = new JLabel("主窗口高度:");
        heightLabel.setFont(infoFont);
        heightField = new JTextField(10);
        heightField.setText(String.valueOf(config.getHeight()));
        heightField.setFont(inputFont);
        constraints.gridx = 0;
        constraints.gridy = 8;
        panel.add(heightLabel, constraints);
        constraints.gridx = 1;
        constraints.gridy = 8;
        panel.add(heightField, constraints);

        titleFont = FileControl.getFont(Font.BOLD,16);
        JButton saveButton = new JButton("不退出程序并保存配置");
        saveButton.setFont(titleFont);
        saveButton.addActionListener(e -> saveConfig(false));
        constraints.gridx = 0;
        constraints.gridy = 9;
        constraints.gridwidth = 2;
        panel.add(saveButton, constraints);

        JButton saveARButton = new JButton("退出程序并保存配置");
        saveARButton.setFont(titleFont);
        saveARButton.addActionListener(e -> saveConfig(true));
        constraints.gridx = 0;
        constraints.gridy = 10;
        constraints.gridwidth = 2;
        panel.add(saveARButton, constraints);

        // updateWindow
        add(panel);
        pack();
        setLocationRelativeTo(null);



    }

    private void saveConfig(boolean isRestart) {
        config.setClockFontsize(Integer.parseInt(clockFontSizeField.getText()));
        config.setLessonFontSize(Integer.parseInt(lessonFontSizeField.getText()));
        config.setPosx(Integer.parseInt(posxField.getText()));
        config.setPosy(Integer.parseInt(posyField.getText()));
        config.setWeight(Integer.parseInt(weightField.getText()));
        config.setHeight(Integer.parseInt(heightField.getText()));

        FileControl.writeWindowConfigToJson(config);

        dispose(); // Close the config window

        if(isRestart){
            System.exit(0);
        }
    }
}
