package xyz.recycleself.htools;

import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityDialog extends AppCompatActivity implements View.OnClickListener {

    private Button bt_bottomsheet;
    private TextView mShowBottomSheet;
    private BottomSheetBehavior<View> behavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        bt_bottomsheet = (Button) findViewById(R.id.bt_bottomsheet);
        bt_bottomsheet.setOnClickListener(this);
        //Bottom Sheet
        View bottomSheet = findViewById(R.id.design_bottom_sheet);
        behavior = BottomSheetBehavior.from(bottomSheet);
        behavior.setState(BottomSheetBehavior.STATE_HIDDEN);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //BottomSheetDialog  BottomSheetDialogFragment
            case R.id.bt_bottomsheet:
                showBottomSheet(behavior);
                break;
        }
    }
    private void showBottomSheet(BottomSheetBehavior behavior) {
        if (behavior.getState() == BottomSheetBehavior.STATE_HIDDEN) {
            behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            bt_bottomsheet.setText("隐藏bottombehavior");
        } else {
            behavior.setState(BottomSheetBehavior.STATE_HIDDEN);
            bt_bottomsheet.setText("显示bottombehavior");
        }
    }

}
