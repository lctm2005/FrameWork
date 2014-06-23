package com.licong.util;

import java.text.DecimalFormat;

/**
 * Created by lctm2005 on 2014/6/2.
 */
public class DoubleUtil {

    /**
     * 保留小数点后几位
     * @param number      Double对象
     * @param placeNum    小数点后位数
     * @return
     */
    public static Double keepDecimalPlace(Double number, int placeNum) {
        StringBuilder sb = new StringBuilder();
        sb.append(".");
        for(int i=0; i<placeNum; i++) {
            sb.append("0");
        }
        DecimalFormat df = new DecimalFormat(sb.toString());
        return Double.parseDouble(df.format(number));
    }

}
