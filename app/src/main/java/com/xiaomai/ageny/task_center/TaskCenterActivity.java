package com.xiaomai.ageny.task_center;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.task.TaskActivity;
import com.xiaomai.ageny.task_center.contract.TaskCenterContract;
import com.xiaomai.ageny.task_center.presenter.TaskCenterPresenter;
import com.xiaomai.ageny.task_earn.EarnTaskActivity;
import com.xiaomai.ageny.utils.state_layout.OtherView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TaskCenterActivity extends BaseMvpActivity<TaskCenterPresenter> implements TaskCenterContract.View {


    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.offline_num)
    TextView offlineNum;
    @BindView(R.id.bt_offline_deal)
    TextView btOfflineDeal;
    @BindView(R.id.earn_num)
    TextView earnNum;
    @BindView(R.id.bt_earn_deal)
    TextView btEarnDeal;
    private Bundle bundle;
    private String strTasknum, strEarnnum;

    @Override
    public int getLayoutId() {
        return R.layout.activity_task_center;
    }

    @Override
    public void initView() {
        bundle = getIntent().getExtras();
        strTasknum = bundle.getString("tasknum");
        strEarnnum = bundle.getString("earnnum");
        offlineNum.setText(strTasknum);
        earnNum.setText(strEarnnum);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError(Throwable throwable) {

    }


    @OnClick({R.id.back, R.id.bt_offline_deal, R.id.bt_earn_deal})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.bt_offline_deal:
                toClass1(this, TaskActivity.class);
                break;
            case R.id.bt_earn_deal:
                toClass(this, EarnTaskActivity.class);
                break;
        }
    }
}
