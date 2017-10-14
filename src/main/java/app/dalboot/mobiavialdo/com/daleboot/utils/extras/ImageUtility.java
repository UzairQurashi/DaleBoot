package app.dalboot.mobiavialdo.com.daleboot.utils.extras;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;

/**
 * Created by Uzair Qureshi on 11/29/16.
 */

public class ImageUtility {

    private static final String TAG = "ImageUtility";
    private Bitmap imageBitmap;
    private String imagePath;
    private ResultListener listener;
    private Activity activity;
    private boolean isUrl;
    private ImageView profilePictureRect;
    private float imageSize;


    interface ResultListener
    {
        /*@Param pImageBitmap
        *        Usage: Bitmap of the selected image
        * @Param pImagePath
        *        Usage: Path of the image either local or remote address
        * @Param pIsUrl
        *        Usage: Tells the path is url or not
        * @Param pActionTaken
                *Usage: What type of action performed by user */
        void imageUtilityResult(Bitmap pImageBitmap, String pImagePath, boolean pIsUrl, ActionTaken pActionTaken);
    }


    public enum ActionTaken {
        CAMERA, SELECT_PICTURE, DELETE_PICTURE
    }



    public static BitmapDrawable writeOnDrawable(Context context, int drawableId, String text){

        Bitmap bm = BitmapFactory.decodeResource(context.getResources(), drawableId).copy(Bitmap.Config.ARGB_8888, true);

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK);
        paint.setTextSize(30);
        paint.setTextAlign(Paint.Align.CENTER);
        Canvas canvas = new Canvas(bm);
        canvas.drawText(text,bm.getWidth()/2, bm.getHeight()/4, paint);
        return new BitmapDrawable(context.getResources(),bm);
    }

    public static Bitmap writeOnDrawable1(Context context, int drawableId, String text, boolean blueMarker){

        Bitmap bm = BitmapFactory.decodeResource(context.getResources(), drawableId).copy(Bitmap.Config.ARGB_8888, true);

        Typeface tf = Typeface.create("Helvetica", Typeface.BOLD);

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        if (!blueMarker)
         paint.setColor(Color.parseColor("#ff7d24"));
        else paint.setColor(Color.parseColor("#697afc"));
        paint.setTypeface(tf);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(convertToPixels( 15, context));
        Canvas canvas = new Canvas(bm);
        canvas.drawText(text,bm.getWidth()/2, (float) (bm.getHeight()/2.2), paint);
        return bm;
    }

    public static int convertToPixels(int nDP, Context mcontext)
    {
        final float conversionScale = mcontext.getResources().getDisplayMetrics().density;

        return (int) ((nDP * conversionScale) + 0.5f) ;

    }




}

