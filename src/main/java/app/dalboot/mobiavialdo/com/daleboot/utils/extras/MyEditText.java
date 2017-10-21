package app.dalboot.mobiavialdo.com.daleboot.utils.extras;

import android.content.Context;
import android.databinding.adapters.TextViewBindingAdapter;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Author: Uzair Qureshi
 * Date:  10/14/17.
 * Description:
 */

public class MyEditText extends EditText    {
    public MyEditText(Context context) {
        super(context);
    }
    public MyEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


//    @Override
//    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
//        super.onTextChanged(text, start, lengthBefore, lengthAfter);
//        if(!text.toString().isEmpty()){
//            this.draw
//        }
//    }


}
