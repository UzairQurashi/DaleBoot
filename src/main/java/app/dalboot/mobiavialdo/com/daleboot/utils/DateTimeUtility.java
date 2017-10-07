package app.dalboot.mobiavialdo.com.daleboot.utils;

import android.support.annotation.Nullable;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by Uzair Qureshi on 11/28/16.
 */

public class DateTimeUtility {


    private static final String TAG = "DateTimeUtility";

    public String getDate(String timeDate)
    {
        if (timeDate!=null)
        {
            String[] array = timeDate.split("T");
            return array[0];
        }
        else
        {
            return "";
        }

    }
    public  String getTime(String timeDate)
    {
        try {
            String[] array =timeDate.split("T");
            String [] array1 = array[1].split("\\.");
            return array1[0];
        }
        catch (IndexOutOfBoundsException | NullPointerException e)
        {
            return "";
        }

    }
    public static String getDataTime(String timeDate)
    {
        try {
            String[] array =timeDate.split("\\.");
            String [] array1 = array[0].split("T");
            return array1[0]+" "+array1[1];
        }
        catch (IndexOutOfBoundsException e)
        {
            return timeDate;
        }
        catch (NullPointerException e)
        {
            return "";
        }

    }

    public static String getShiftDate(String OurDate)
    {
        Log.d("OurDate", OurDate);
        try
        {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
            Date value = formatter.parse(OurDate);

            SimpleDateFormat dateFormatter = new SimpleDateFormat("EEEE dd MMM"); //this format changeable
            dateFormatter.setTimeZone(TimeZone.getDefault());
            OurDate = dateFormatter.format(value);

            //Log.d("OurDate", OurDate);
        }
        catch (Exception e)
        {
            OurDate = "";
        }
        return OurDate;
    }

    public static long getTimeInMiliseconds(String OurDate)
    {
        OurDate = getDataTime(OurDate);
        Log.d("OurDate", OurDate);
        Date value = null;
        try
        {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm a");
//         formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
            value = formatter.parse(OurDate);

            //Log.d("OurDate", OurDate);
        }
        catch (Exception e)
        {
            Log.d(TAG, "getTimeInMiliseconds: "+ e.getMessage());
            return Calendar.getInstance().getTimeInMillis();
        }
        return value.getTime();
    }
    public static long minusTimetoTimespam(String OurDate,long timeMinus)
    {
        OurDate = getDataTime(OurDate);
        Log.d("OurDate", OurDate);
        Date value = null;
        try
        {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm a");
//         formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
            value = formatter.parse(OurDate);

            //Log.d("OurDate", OurDate);
        }
        catch (Exception e)
        {
            Log.d(TAG, "getTimeInMiliseconds: "+ e.getMessage());
            return Calendar.getInstance().getTimeInMillis();
        }
        return value.getTime()-timeMinus;
    }

    /*Accepted Format: yyyy-MM-dd HH:mm:ss yyyy-MM-ddTHH:mm:sszz
     return dd-MMM-YYYY
     return 00-00-0000 00:00 in case of exception*/
    public static String getLocalDate(String OurDate)
    {
        OurDate = getDataTime(OurDate);
        Log.d("OurDate", OurDate);

        try
        {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
            Date value = formatter.parse(OurDate);

            SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy"); //this format changeable
            dateFormatter.setTimeZone(TimeZone.getDefault());
            OurDate = dateFormatter.format(value);

            //Log.d("OurDate", OurDate);
        }
        catch (Exception e)
        {
            OurDate = "00-00-0000 00:00";
        }
        return OurDate;
    }

    /*Accepted Format: yyyy-MM-dd HH:mm:ss yyyy-MM-ddTHH:mm:sszz
     return dd-MMM hh:mm a
     return 00-00-0000 00:00 in case of exception*/
    public static String getEventTime(String serverDate)
    {
        Log.d("OurDate", serverDate);

        try
        {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm a");
            Date value = formatter.parse(serverDate);

            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); //this format changeable
            dateFormatter.setTimeZone(TimeZone.getDefault());
            serverDate = dateFormatter.format(value);

            //Log.d("OurDate", OurDate);
        }
        catch (Exception e)
        {
            Log.d(TAG, "getEventTime: "+e.getMessage());
            serverDate = "";
        }
        return serverDate;
    }
    public  String getLocalTime(String OurDate)
    {
        OurDate = getDataTime(OurDate);
        Log.d("OurDate", OurDate);
        try
        {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
            Date value = formatter.parse(OurDate);

            SimpleDateFormat dateFormatter = new SimpleDateFormat("HH:mm"); //this format changeable
            dateFormatter.setTimeZone(TimeZone.getDefault());
            OurDate = dateFormatter.format(value);

            //Log.d("OurDate", OurDate);
        }
        catch (Exception e)
        {
            OurDate = "";
        }
        return OurDate;
    }

    public  String getLocalTime(long timeStamp)
    {
        Date date = new Date(timeStamp*1000L); // *1000 is to convert seconds to milliseconds
        SimpleDateFormat sdf = new SimpleDateFormat("h:mm a"); // the format of your date
        return sdf.format(date);
    }

    public  String getLocalDate(long timeStamp)
    {
        Date date = new Date(timeStamp*1000L); // *1000 is to convert seconds to milliseconds
        SimpleDateFormat sdf = new SimpleDateFormat("d MMM yyyy"); // the format of your date
        return sdf.format(date);
    }
    public String getChatDate(@Nullable Calendar cal2)
    {
        try {
            if (isTodayDate(cal2))
            {
                return "Today";
            }
            else if (isYesterdayDate(cal2))
            {
                return "Yesterday";
            }
            else {
                return getDateandTime(cal2,"MMMM d, yyyy"); // the format of your date
            }
        }
        catch (NullPointerException e)
        {
            Log.e(TAG, "getChatDate:" + e.getMessage());
            return getChatDate(Calendar.getInstance());
        }

    }

    public  String getConversationDate(long timeInMiliSeconds)
    {
        Calendar cal2  = Calendar.getInstance();
        cal2.setTimeInMillis(timeInMiliSeconds*1000L); // *1000 is to convert seconds to milliseconds
        if (isTodayDate(cal2))
        {
            return "Today";
        }
        else if (isYesterdayDate(cal2))
        {
            return "Yesterday";
        }
        else {
            return getDateandTime(cal2,"MMM d, yyyy"); // the format of your date
        }
    }

    public  String getDateandTime(Calendar cal2,String format)
    {
        Date date = new Date(cal2.getTimeInMillis());
        SimpleDateFormat sdf = new SimpleDateFormat(format); // the format of your date
        return sdf.format(date);
    }
    public  boolean isTodayDate(Calendar date) {

        try {
            Calendar today = Calendar.getInstance();

            return  date.get(Calendar.YEAR) == today.get(Calendar.YEAR) &&
                    date.get(Calendar.DAY_OF_YEAR) == today.get(Calendar.DAY_OF_YEAR);

        }
        catch (NullPointerException e)
        {
            Log.e(TAG, "isTodayDate:" + e.getMessage());
            return false;
        }

    }

    public  boolean isYesterdayDate(Calendar date) {
        try {
            Calendar yesterday = Calendar.getInstance();
            yesterday.add(Calendar.DAY_OF_YEAR,-1);
            return  date.get(Calendar.YEAR) == yesterday.get(Calendar.YEAR) &&
                    date.get(Calendar.DAY_OF_YEAR) == yesterday.get(Calendar.DAY_OF_YEAR);
        }
        catch (Exception e)
        {
            Log.e(TAG, "isYesterdayDate:" + e.getMessage());
            return false;
        }

    }

    public  Calendar getCalendarObject(String time) {
        time = time.replace("T"," ");
        time =  time.replace("Z" ," ");

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        try {
            Date value = formatter.parse(time);
            Calendar cal = Calendar.getInstance();
            cal.setTime(value);
            return cal;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return Calendar.getInstance();
    }

    public static String reverseDate(String start_date) {
        String newstring = "";
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(start_date);
            newstring = new SimpleDateFormat("dd MMM yyyy").format(date);
        } catch (Exception e) {
            Log.e(TAG, "reverseDate: "  + e.getMessage());
            return start_date;
        }
        return newstring;
    }

    public static String calendarToDateString(Calendar cal) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy", Locale.US);
        return sdf.format(cal.getTime());
    }

    public static Calendar convertDateToCalendarObject(String start_date) {

        Calendar cal = Calendar.getInstance();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy", Locale.US);
            cal.setTime(sdf.parse(start_date));// all done
            return cal;
        } catch (Exception e) {
            return cal;
        }
    }

    public static String getEventEndTime(String serverDate) {
        Log.d("OurDate", serverDate);

        try
        {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm a");
            Date value = formatter.parse(serverDate);
            long timeInMiliseconds = value.getTime();
            timeInMiliseconds += 1000*60*60;
            value.setTime(timeInMiliseconds);

            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); //this format changeable
            dateFormatter.setTimeZone(TimeZone.getDefault());
            serverDate = dateFormatter.format(value);

            //Log.d("OurDate", OurDate);
        }
        catch (Exception e)
        {
            Log.d(TAG, "getEventTime: "+e.getMessage());
            serverDate = "";
        }
        return serverDate;

    }
}
