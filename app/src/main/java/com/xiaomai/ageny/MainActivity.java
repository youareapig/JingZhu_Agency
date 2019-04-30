package com.xiaomai.ageny;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.xiaomai.ageny.base.BaseActivity;
import com.xiaomai.ageny.fragment.agency.Agency_Fragment;
import com.xiaomai.ageny.fragment.contact.Contact_Fragment;
import com.xiaomai.ageny.fragment.index.Index_Fragment;
import com.xiaomai.ageny.fragment.mine.Mine_Fragment;
import com.xiaomai.ageny.utils.SharedPreferencesUtil;
import com.xiaomai.ageny.utils.ToastUtil;
import com.xiaomai.ageny.utils.state_layout.OtherView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @BindView(R.id.fragment_main)
    LinearLayout fragmentMain;
    @BindView(R.id.index_icon)
    ImageView indexIcon;
    @BindView(R.id.index_name)
    TextView indexName;
    @BindView(R.id.bt_index_index)
    RelativeLayout btIndexIndex;
    @BindView(R.id.contact_icon)
    ImageView contactIcon;
    @BindView(R.id.contact_name)
    TextView contactName;
    @BindView(R.id.bt_index_contact)
    RelativeLayout btIndexContact;
    @BindView(R.id.agency_icon)
    ImageView agencyIcon;
    @BindView(R.id.agency_name)
    TextView agencyName;
    @BindView(R.id.bt_index_agency)
    RelativeLayout btIndexAgency;
    @BindView(R.id.mine_icon)
    ImageView mineIcon;
    @BindView(R.id.mine_name)
    TextView mineName;
    @BindView(R.id.bt_index_mine)
    RelativeLayout btIndexMine;
    @BindView(R.id.otherview)
    OtherView otherView;

    private Fragment fragment;
    private List<Fragment> fragmentList;
    private int currentIndex = 0;
    private FragmentManager fragmentManager;
    private static final String CURRENT_FRAGMENT = "STATE_FRAGMENT_SHOW";
    private long exitTime = 0;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        fragment = new Fragment();
        fragmentList = new ArrayList<>();
        fragmentManager = getSupportFragmentManager();
        if (savedInstanceState != null) {
            currentIndex = savedInstanceState.getInt(CURRENT_FRAGMENT, 0);
            fragmentList.removeAll(fragmentList);
            fragmentList.add(fragmentManager.findFragmentByTag(0 + ""));
            fragmentList.add(fragmentManager.findFragmentByTag(1 + ""));
            fragmentList.add(fragmentManager.findFragmentByTag(2 + ""));
            fragmentList.add(fragmentManager.findFragmentByTag(3 + ""));
            restoreFragment();
        } else {
            fragmentList.add(new Index_Fragment());
            fragmentList.add(new Contact_Fragment());
            fragmentList.add(new Agency_Fragment());
            fragmentList.add(new Mine_Fragment());
            showFragment();

        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(CURRENT_FRAGMENT, currentIndex);
        super.onSaveInstanceState(outState);
    }

    private void showFragment() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (!fragmentList.get(currentIndex).isAdded()) {
            transaction
                    .hide(fragment)
                    .add(R.id.fragment_main, fragmentList.get(currentIndex), "" + currentIndex);
        } else {
            transaction
                    .hide(fragment)
                    .show(fragmentList.get(currentIndex));
        }
        fragment = fragmentList.get(currentIndex);
        transaction.commit();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                ToastUtil.showShortToast("再按一次退出程序");
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void restoreFragment() {
        FragmentTransaction mBeginTreansaction = fragmentManager.beginTransaction();
        for (int i = 0; i < fragmentList.size(); i++) {
            if (i == currentIndex) {
                mBeginTreansaction.show(fragmentList.get(i));
            } else {
                mBeginTreansaction.hide(fragmentList.get(i));
            }
        }
        mBeginTreansaction.commit();
        fragment = fragmentList.get(currentIndex);

    }

    @OnClick({R.id.bt_index_index, R.id.bt_index_contact, R.id.bt_index_agency, R.id.bt_index_mine})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_index_index:
                currentIndex = 0;
                showFragment();
                indexName.setTextColor(getResources().getColor(R.color.appbar));
                contactName.setTextColor(getResources().getColor(R.color.index_text_normal));
                agencyName.setTextColor(getResources().getColor(R.color.index_text_normal));
                mineName.setTextColor(getResources().getColor(R.color.index_text_normal));


                indexIcon.setImageResource(R.mipmap.index_icon_hover);
                contactIcon.setImageResource(R.mipmap.business_icon_nomal);
                agencyIcon.setImageResource(R.mipmap.people_icon_nomal);
                mineIcon.setImageResource(R.mipmap.center_icon_nomal);
                break;
            case R.id.bt_index_contact:
                currentIndex = 1;
                showFragment();

                indexName.setTextColor(getResources().getColor(R.color.index_text_normal));
                contactName.setTextColor(getResources().getColor(R.color.appbar));
                agencyName.setTextColor(getResources().getColor(R.color.index_text_normal));
                mineName.setTextColor(getResources().getColor(R.color.index_text_normal));


                indexIcon.setImageResource(R.mipmap.index_icon_nomal);
                contactIcon.setImageResource(R.mipmap.business_icon_hover);
                agencyIcon.setImageResource(R.mipmap.people_icon_nomal);
                mineIcon.setImageResource(R.mipmap.center_icon_nomal);
                break;
            case R.id.bt_index_agency:
                currentIndex = 2;
                showFragment();

                indexName.setTextColor(getResources().getColor(R.color.index_text_normal));
                contactName.setTextColor(getResources().getColor(R.color.index_text_normal));
                agencyName.setTextColor(getResources().getColor(R.color.appbar));
                mineName.setTextColor(getResources().getColor(R.color.index_text_normal));


                indexIcon.setImageResource(R.mipmap.index_icon_nomal);
                contactIcon.setImageResource(R.mipmap.business_icon_nomal);
                agencyIcon.setImageResource(R.mipmap.people_icon_hover);
                mineIcon.setImageResource(R.mipmap.center_icon_nomal);
                break;
            case R.id.bt_index_mine:
                currentIndex = 3;
                showFragment();

                indexName.setTextColor(getResources().getColor(R.color.index_text_normal));
                contactName.setTextColor(getResources().getColor(R.color.index_text_normal));
                agencyName.setTextColor(getResources().getColor(R.color.index_text_normal));
                mineName.setTextColor(getResources().getColor(R.color.appbar));


                indexIcon.setImageResource(R.mipmap.index_icon_nomal);
                contactIcon.setImageResource(R.mipmap.business_icon_nomal);
                agencyIcon.setImageResource(R.mipmap.people_icon_nomal);
                mineIcon.setImageResource(R.mipmap.center_icon_hover);
                break;
        }
    }

}
