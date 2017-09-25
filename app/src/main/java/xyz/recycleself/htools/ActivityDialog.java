package xyz.recycleself.htools;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityDialog extends AppCompatActivity implements View.OnClickListener {

    private Button bt_bottomsheet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        bt_bottomsheet = (Button) findViewById(R.id.bt_bottomsheet);
        bt_bottomsheet.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_bottomsheet:

                break;
        }
    }
}
