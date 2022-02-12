//package knhel7.jd14.jpat14.task12;

//import java.util.Locale;

import java.util.Date;

public enum Logger {
    SINGLE_INSTANCE;

    private Date d = new Date();
    private int num = 1;

    public void log(String msg) {
        System.out.println(
                "[" +
                String.format("%1$td.%1$tm.%1$tY %tT", d) +
                ", " + num++ +
                "] " +
                msg
        );
    }
}
