package com.telizhenko.sort.utils;

/**
 * Created with IntelliJ IDEA.
 * User: Artem.Telizhenko
 * Date: 18.12.13
 * Time: 21:55
 * To change this template use File | Settings | File Templates.
 */
public final class Randomize {
    //Min + (int)(Math.random() * ((Max - Min) + 1))
    public static Double getRandom(double rangeFrom, double rangeTo) {
        return rangeFrom + (Math.random() * ((rangeTo - rangeFrom) + 1));
    }

    public static Float getRandom(float rangeFrom, float rangeTo) {
        return rangeFrom + (float) (Math.random() * ((rangeTo - rangeFrom) + 1));
    }

    public static Integer getRandom(int rangeFrom, int rangeTo) {
        return rangeFrom + (int) (Math.random() * ((rangeTo - rangeFrom) + 1));
    }

    public static Short getRandom(short rangeFrom, short rangeTo) {
        return (short) (rangeFrom + (Math.random() * ((rangeTo - rangeFrom) + 1)));
    }
}
