package utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class DateGeneratorUtil {

    protected Random rdm = new Random();
    protected Date date = new Date();

    public String generatingDate(String option) {
        String month;
        String day;
        String year;
        String formatteddata = new SimpleDateFormat("MM/dd/yyyy").format(date);

        switch (option.toLowerCase()) {
            case "random":
            case "birth":
                int rdmM = rdm.nextInt(12);
                int rdmD = rdm.nextInt(30);
                int rdmY = rdm.nextInt((2000 - 1970) + 1) + 1970;

                month = String.valueOf(rdmM);
                day = String.valueOf(rdmD);
                year = String.valueOf(rdmY);

                if (rdmM < 10 & rdmM > 0) {
                    month = "0" + month;
                } else if (rdmM == 0) {
                    month = month + 1;
                }

                if (rdmD < 10 & rdmD > 0) {
                    day = "0" + day;
                } else if (rdmD == 0) {
                    day = day + 1;
                }
                break;
            case "m+1":
                int mM = Integer.parseInt(formatteddata.substring(0, 2)) + 1;
                int mD = Integer.parseInt(formatteddata.substring(3, 5)) + 1;
                int mY = Integer.parseInt(formatteddata.substring(6, 10));

                month = String.valueOf(mM);
                day = String.valueOf(mD);
                year = String.valueOf(mY);

                if (mM < 10 & mM > 0) {
                    month = "0" + month;
                } else if (mM == 0) {
                    month = month + 1;
                }

                if (mD < 10 & mD > 0) {
                    day = "0" + day;
                } else if (mD == 0) {
                    day = day + 1;
                }
                break;
            case "atual":
                return formatteddata;
            default:
                throw new IllegalArgumentException("The " + option + " option provided does not exist on the switch");
        }
        return month + "/" + day + "/" + year;
    }
}
