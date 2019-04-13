package com.xiaomai.ageny.addbank;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xiaomai.ageny.MainActivity;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class DepositSuccessActivity extends BaseActivity {


    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.bt_back_index)
    TextView btBackIndex;

    @Override
    public int getLayoutId() {
        return R.layout.activity_apply;
    }

    @Override
    public void initView() {

    }


    @OnClick({R.id.back, R.id.bt_back_index})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.bt_back_index:
                toClass1(this, MainActivity.class);
                break;
        }
    }
}
