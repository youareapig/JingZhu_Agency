package com.xiaomai.ageny.staff_manage;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.xiaomai.ageny.MainActivity;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.staff_manage.contract.StaffManageContract;
import com.xiaomai.ageny.staff_manage.presenter.StaffManagePresenter;
import com.xiaomai.ageny.utils.SwipeItemLayout;
import com.xiaomai.ageny.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StaffManageActivity extends BaseMvpActivity<StaffManagePresenter> implements StaffManageContract.View {


    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.bt_manage)
    TextView btManage;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.bt_addstaff)
    LinearLayout btAddstaff;
    private Adapter adapter;
    private List<String> list;

    @Override
    public int getLayoutId() {
        return R.layout.activity_staff_manage;
    }

    @Override
    public void initView() {
        list = new ArrayList<>();
        list.add("张学友1");
        list.add("张学友2");
        list.add("张学友3");
        list.add("张学友4");
        list.add("张学友5");
        list.add("张学友6");
        list.add("张学友7");
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recycler.setNestedScrollingEnabled(false);
        //左滑删除
        recycler.addOnItemTouchListener(new SwipeItemLayout.OnSwipeItemTouchListener(this));
        adapter = new Adapter(R.layout.staff_item, list);
        recycler.setAdapter(adapter);
        adapter.openLoadAnimation();
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                myDialog(position);
            }
        });
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


    @OnClick({R.id.back, R.id.bt_addstaff})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                break;
            case R.id.bt_addstaff:
                break;
        }
    }

    private void myDialog(final int pos) {
        final AlertDialog builder = new AlertDialog.Builder(this).create();
        LayoutInflater layoutInflater = this.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.dialog_staff_delete, null);
        builder.setView(view);
        builder.setCanceledOnTouchOutside(false);
        builder.show();
        view.findViewById(R.id.bt_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.remove(pos);
                adapter.notifyItemRemoved(pos);
                builder.dismiss();
                ToastUtil.showShortToast("删除成功");
            }
        });
        view.findViewById(R.id.bt_think).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.dismiss();
            }
        });


    }
}
