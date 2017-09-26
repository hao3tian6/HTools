package xyz.recycleself.htools.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * hdl on 2017/9/26.
 * https://github.com/hao3tian5/HTools.git
 * xintian13@126.com
 *
 * dialog 弹窗
 */

public class BottomSheetFragment extends BottomSheetDialogFragment {

    public static BottomSheetDialogFragment newInstance(){
        return new BottomSheetFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
