package xyz.recycleself.htools;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.recycleself.toolslibrary.H_ActivityTools;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button bt_dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        H_ActivityTools.setActivityLandscape(this);
        setContentView(R.layout.activity_main);
        bt_dialog = (Button) findViewById(R.id.bt_dialog);
        bt_dialog.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
      switch (v.getId()){
          case R.id.bt_dialog:
              startActivity(new Intent(this,ActivityDialog.class));
              break;
      }
    }
}
