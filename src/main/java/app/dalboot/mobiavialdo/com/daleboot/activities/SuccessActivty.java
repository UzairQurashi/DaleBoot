package app.dalboot.mobiavialdo.com.daleboot.activities;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import app.dalboot.mobiavialdo.com.daleboot.R;
import app.dalboot.mobiavialdo.com.daleboot.databinding.ActivitySuccessActivtyBinding;

public class SuccessActivty extends BaseActivity {
    ActivitySuccessActivtyBinding binding;
    protected String[]upperspinner_items=new String[]{"NEVER","LEFT","RIGHT","BOTH"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding= DataBindingUtil.setContentView(SuccessActivty.this,R.layout.activity_success_activty);
        parentBinding=binding;
        loadViews();

    }

    private void loadViews() {
        binding.ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityWithFinish(MainActivity.class);
            }
        });

    }
}
