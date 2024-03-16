package com.lessonlist.obj;

import java.awt.*;

@SuppressWarnings("unused")
public class WindowConfig {
    private int clockFontsize;
    private int lessonFontSize;
    private int posx;
    private int posy;
    private int weight;
    private int height;
    private int pastLessonColorR;
    private int pastLessonColorG;
    private int pastLessonColorB;
    private int presentLessonColorR;
    private int presentLessonColorG;
    private int presentLessonColorB;
    private int nextLessonColorR;
    private int nextLessonColorG;
    private int nextLessonColorB;
    private int windowColorR;
    private int windowColorG;
    private int windowColorB;
    private int windowColorA;

    public int getClockFontsize() {
        return clockFontsize;
    }

    public void setClockFontsize(int clockFontsize) {
        this.clockFontsize = clockFontsize;
    }

    public int getLessonFontSize() {
        return lessonFontSize;
    }

    public void setLessonFontSize(int lessonFontSize) {
        this.lessonFontSize = lessonFontSize;
    }

    public int getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public int getPosy() {
        return posy;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getPastLessonColorR() {
        return pastLessonColorR;
    }

    public void setPastLessonColorR(int pastLessonColorR) {
        this.pastLessonColorR = pastLessonColorR;
    }

    public int getPastLessonColorG() {
        return pastLessonColorG;
    }

    public void setPastLessonColorG(int pastLessonColorG) {
        this.pastLessonColorG = pastLessonColorG;
    }

    public int getPastLessonColorB() {
        return pastLessonColorB;
    }

    public void setPastLessonColorB(int pastLessonColorB) {
        this.pastLessonColorB = pastLessonColorB;
    }

    public int getPresentLessonColorR() {
        return presentLessonColorR;
    }

    public void setPresentLessonColorR(int presentLessonColorR) {
        this.presentLessonColorR = presentLessonColorR;
    }

    public int getPresentLessonColorG() {
        return presentLessonColorG;
    }

    public void setPresentLessonColorG(int presentLessonColorG) {
        this.presentLessonColorG = presentLessonColorG;
    }

    public int getPresentLessonColorB() {
        return presentLessonColorB;
    }

    public void setPresentLessonColorB(int presentLessonColorB) {
        this.presentLessonColorB = presentLessonColorB;
    }

    public int getNextLessonColorR() {
        return nextLessonColorR;
    }

    public void setNextLessonColorR(int nextLessonColorR) {
        this.nextLessonColorR = nextLessonColorR;
    }

    public int getNextLessonColorG() {
        return nextLessonColorG;
    }

    public void setNextLessonColorG(int nextLessonColorG) {
        this.nextLessonColorG = nextLessonColorG;
    }

    public int getNextLessonColorB() {
        return nextLessonColorB;
    }

    public void setNextLessonColorB(int nextLessonColorB) {
        this.nextLessonColorB = nextLessonColorB;
    }

    public int getWindowColorR() {
        return windowColorR;
    }

    public void setWindowColorR(int windowColorR) {
        this.windowColorR = windowColorR;
    }

    public int getWindowColorG() {
        return windowColorG;
    }

    public void setWindowColorG(int windowColorG) {
        this.windowColorG = windowColorG;
    }

    public int getWindowColorB() {
        return windowColorB;
    }

    public void setWindowColorB(int windowColorB) {
        this.windowColorB = windowColorB;
    }

    public int getWindowColorA() {
        return windowColorA;
    }

    public void setWindowColorA(int windowColorA) {
        this.windowColorA = windowColorA;
    }

    public Color getPastLessonColor() {
        return new Color(this.pastLessonColorR, this.pastLessonColorG, this.pastLessonColorB);
    }

    public Color getPresentLessonColor() {
        return new Color(this.presentLessonColorR, this.presentLessonColorG, this.presentLessonColorB);
    }

    public Color getNextLessonColor() {
        return new Color(this.nextLessonColorR, this.nextLessonColorG, this.nextLessonColorB);
    }

    public Color getWindowBgColor() {
        return new Color(this.windowColorR, this.windowColorG, this.windowColorB, this.windowColorA);

    }
    public Color getNoAlphaWindowBgColor(){
        return new Color(this.windowColorR, this.windowColorG, this.windowColorB, 255);
    }
}
