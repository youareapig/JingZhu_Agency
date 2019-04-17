package com.xiaomai.ageny.fragment.agency.fragment.daili;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpFragment;
import com.xiaomai.ageny.bean.DailiListBean;
import com.xiaomai.ageny.details.dailidetails.DailiDetailsActivity;
import com.xiaomai.ageny.fragment.agency.fragment.daili.contract.DailiContract;
import com.xiaomai.ageny.fragment.agency.fragment.daili.presenter.DailiPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class DailiFragment extends BaseMvpFragment<DailiPresenter> implements DailiContract.View {

    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.addTimeText)
    TextView addTimeText;
    @BindView(R.id.addTimeIcon)
    ImageView addTimeIcon;
    @BindView(R.id.moneyText)
    TextView moneyText;
    @BindView(R.id.moneyIcon)
    ImageView moneyIcon;
    @BindView(R.id.fenrunText)
    TextView fenrunText;
    @BindView(R.id.fenrunIcon)
    ImageView fenrunIcon;
    @BindView(R.id.totle_count)
    TextView totleCount;


    private Adapter adapter;
    private List<DailiListBean.DataBean.ListBean> list;
    private boolean rank_makeMoney = true;
    private boolean rank_addTime = true;
    private boolean rank_fenrun = true;
    private Bundle bundle;

    @Override
    protected void initView(View view) {
        bundle = new Bundle();
        moneyText.setSelected(true);
        mPresenter = new DailiPresenter();
        mPresenter.attachView(this);
        mPresenter.getData("", "", "", "1", "6");

    }

    @Override
    protected int getLayoutId() {
        return R.layout.daili_fragment;
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

    @Override
    public void onSuccess(DailiListBean bean) {
        if (bean.getCode() == 1) {
            totleCount.setText("共" + bean.getData().getTotal() + "家");
            list = bean.getData().getList();
            recycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
            adapter = new Adapter(R.layout.daili_item, list);
            recycler.setAdapter(adapter);
            adapter.openLoadAnimation();
            adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    bundle.putString("id", list.get(position).getId());
                    toClass(view.getContext(), DailiDetailsActivity.class,bundle);
                }
            });
        }
    }


    @OnClick({R.id.addTimeText, R.id.moneyText, R.id.fenrunText})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.addTimeText:
                addTimeText.setSelected(true);
                moneyText.setSelected(false);
                fenrunText.setSelected(false);
                moneyIcon.setImageResource(R.mipmap.sort_hover_hui);
                fenrunIcon.setImageResource(R.mipmap.sort_hover_hui);
                if (rank_addTime) {
                    addTimeIcon.setImageResource(R.mipmap.sort_hove);
                    rank_addTime = false;
                    mPresenter.getData("", "", "", "1", "1");
                } else {
                    addTimeIcon.setImageResource(R.mipmap.sort_hover);
                    rank_addTime = true;
                    mPresenter.getData("", "", "", "1", "2");
                }
                break;
            case R.id.moneyText:
                addTimeText.setSelected(false);
                moneyText.setSelected(true);
                fenrunText.setSelected(false);
                addTimeIcon.setImageResource(R.mipmap.sort_hover_hui);
                fenrunIcon.setImageResource(R.mipmap.sort_hover_hui);
                if (rank_makeMoney) {
                    moneyIcon.setImageResource(R.mipmap.sort_hove);
                    rank_makeMoney = false;
                    mPresenter.getData("", "", "", "1", "5");
                } else {
                    moneyIcon.setImageResource(R.mipmap.sort_hover);
                    rank_makeMoney = true;
                    mPresenter.getData("", "", "", "1", "6");
                }
                break;
            case R.id.fenrunText:
                addTimeText.setSelected(false);
                moneyText.setSelected(false);
                fenrunText.setSelected(true);
                addTimeIcon.setImageResource(R.mipmap.sort_hover_hui);
                moneyIcon.setImageResource(R.mipmap.sort_hover_hui);
                if (rank_fenrun) {
                    fenrunIcon.setImageResource(R.mipmap.sort_hove);
                    rank_fenrun = false;
                    mPresenter.getData("", "", "", "1", "3");
                } else {
                    fenrunIcon.setImageResource(R.mipmap.sort_hover);
                    rank_fenrun = true;
                    mPresenter.getData("", "", "", "1", "4");
                }
                break;
        }
    }
}
