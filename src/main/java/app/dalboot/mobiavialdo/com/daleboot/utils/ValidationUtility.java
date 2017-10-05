package app.dalboot.mobiavialdo.com.daleboot.utils;

import android.content.Context;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author: Uzair Qureshi
 * Date: 5/9/17.
 * Description:
 */

public class ValidationUtility {

    private static final String TAG = "ValidationUtils";

    public static boolean isValidEmail(EditText mEditText) {
        String text = mEditText.getText().toString();
        if (text.isEmpty()) {
            return false;
        } else
        {
            boolean correct = android.util.Patterns.EMAIL_ADDRESS.matcher(text).matches();
            if(!correct) {
                return false;
            }
            else
            {
                if(text.contains("example"))
                {
                    return false;
                }
            }


        }
        return true;
    }
    public static boolean edittextValidator(EditText... mEditTexts)
    {
        for (EditText mEditText:mEditTexts) {
            if (mEditText.getText().toString().isEmpty()) {

                mEditText.setError("Required");
                return false;
            }
        }
        return true;
    }

    public static boolean isValidCardNumber(String cardNumber) {
        cardNumber= cardNumber.replace(" ","");
        return (cardNumber.length() >=7);
    }

    public  boolean educationLevel(int level, Context mContext)
    {
        if (level==-1) {

            Toast.makeText(mContext, "Required",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }




    public static boolean isThisDateValid(String dateToValidate){

        if(dateToValidate == null){
            return false;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
        sdf.setLenient(false);

        try {

            //if not valid, it will throw ParseException
            Date date = sdf.parse(dateToValidate);
            System.out.println(date);

        } catch (ParseException e) {

            e.printStackTrace();
            return false;
        }

        return true;
    }


    public static boolean isValidPhone(String phone) {

            String regex = "^(?:(?:\\+|00)(\\d{1,3})[\\s-]?)?(\\d{13})$";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(phone);
            if (m.matches()) {
                return true;
            } else {
                return false;
            }
    }

    public static boolean checkExpiry(String s) {

        try {
            if(new SimpleDateFormat("dd MMM yyyy").parse(s).before(new Date()))
                return false;
        } catch (ParseException e) {
            Log.e(TAG, "checkExpiry:" + e.getMessage());
            return false;
        }

        return true;
    }

    public static boolean isValidPassword(EditText edPassword) {
        return (edPassword.getText().toString().length()>=6);
    }
}

