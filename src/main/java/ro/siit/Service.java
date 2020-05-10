package ro.siit;



import org.w3c.dom.ls.LSOutput;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Service {

    public static long getNrOfDays(String birthday){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");
        String currentDate = dateTimeFormatter.format(now);

        long nrOfDays = 0;
        try {
            Date date1 = simpleDateFormat.parse(birthday);
            Date date2 = simpleDateFormat.parse(currentDate);
            long diff = date2.getTime() - date1.getTime();

            nrOfDays = TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return nrOfDays;
    }
}
