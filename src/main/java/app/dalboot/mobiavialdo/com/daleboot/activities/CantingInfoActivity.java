package app.dalboot.mobiavialdo.com.daleboot.activities;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import app.dalboot.mobiavialdo.com.daleboot.R;
import app.dalboot.mobiavialdo.com.daleboot.abstract_classess.GeneralCallBack;
import app.dalboot.mobiavialdo.com.daleboot.databinding.ActivityCantingInfoBinding;
import app.dalboot.mobiavialdo.com.daleboot.models.response.GeneralResponse;
import app.dalboot.mobiavialdo.com.daleboot.network.RestClient;

public class CantingInfoActivity extends BaseActivity {
    private ActivityCantingInfoBinding binding;
    private String cant_want,cant_sole,after_cant,notes,order_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(CantingInfoActivity.this,R.layout.activity_canting_info);
        parentBinding=binding;
        loadViews();
    }

    private void loadViews() {
        getIntentData();
        setSupportActionBar(binding.toolbar.toolbar);
        binding.toolbar.mainToolbarTitle.setText("Canting Information\n(Boot Tech Use Only)");


    }

    private void getIntentData() {
        if (getIntent()!=null){
            order_id=getIntent().getStringExtra("order_id");

        }

    }

    private void addCanting(){
        cant_want=binding.leftCantWand.getText().toString()+"-"+binding.rightCantWand.getText().toString()+"cm";
        cant_sole=binding.leftBootCantedSole.getText().toString()+"-"+binding.rightBootCantedSole.getText().toString()+"cm";
        after_cant=binding.leftDegreeAfterCant.getText().toString()+"-"+binding.rightDegreeAfterCant.getText().toString()+"cm";
        notes=binding.notes.getText().toString();
        showProgress();
        RestClient.getAuthAdapter().addCanting(cant_want,cant_sole,after_cant,notes,order_id).enqueue(new GeneralCallBack<GeneralResponse>(this) {
            @Override
            public void onSuccess(GeneralResponse response) {
                hideProgress();
                showMessage(response.getDeveloper_message());
                openActivityWithFinish(MainActivity.class);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.form_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        if (id == R.id.nav_user_form) {
            //call api
            addCanting();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
