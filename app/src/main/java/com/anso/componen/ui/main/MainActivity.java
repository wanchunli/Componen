package com.anso.componen.ui.main;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;
import com.anso.base.baseadapter.CustomViewPagerAdapter;
import com.anso.base.basemvp.MVPBaseActivity;
import com.anso.base.bean.ErrorBean;
import com.anso.componen.R;
import com.anso.componen.bean.WeatherEntity;
import com.anso.componen.databinding.ActivityMainBinding;
import com.anso.componen.ui.main.home.HomeFragment;
import com.anso.componen.ui.main.order.OrderFragment;
import com.anso.componen.ui.main.personal.PersonalFragment;


public class MainActivity extends MVPBaseActivity<MainView, MainPresenter> implements MainView , ViewPager.OnPageChangeListener{

    public ActivityMainBinding binding;

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(MainActivity.this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = DataBindingUtil.setContentView(this, provideContentViewId());
        super.onCreate(savedInstanceState);
        binding.setLifecycleOwner(this);
        binding.setMainClick(this);
        binding.setOrderClick(this);
        binding.setPersonClick(this);
        CustomViewPagerAdapter customViewPagerAdapter = new CustomViewPagerAdapter(getSupportFragmentManager());
        customViewPagerAdapter.addFragment(HomeFragment.newInstance(0));
        customViewPagerAdapter.addFragment(OrderFragment.newInstance(1));
        customViewPagerAdapter.addFragment(PersonalFragment.newInstance(2));
        binding.mainPager.setAdapter(customViewPagerAdapter);
        binding.mainPager.setCurrentItem(CustomViewPagerAdapter.TAB_ONE, false);
        binding.mainPager.addOnPageChangeListener(this);
        binding.mainPager.setOffscreenPageLimit(3);
        switchItem(0);
    }

    @Override
    public void initViews() {
        super.initViews();
//        RxPermissions.getInstance(MainActivity.this)
//                .request(Manifest.permission.INTERNET)
//                .subscribe(new Action1<Boolean>() {
//                    @Override
//                    public void call(Boolean aBoolean) {
//                        if (aBoolean) {//true表示获取权限成功（注意这里在android6.0以下默认为true）
//                            mPresenter.getWeather("101030100");
//                        } else {
//                            PermissionPageUtils permissionPageUtils = new PermissionPageUtils(MainActivity.this, "com.anso.xinyu_outworkplatform");
//                            permissionPageUtils.jumpPermissionPage();
//                        }
//                    }
//                });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.home_layout:
                /*Intent it = new Intent(MainActivity.this, RecognizeActivity.class);
                startActivityForResult(it, FACE_RQ_CODE);*/
                binding.mainPager.setCurrentItem(CustomViewPagerAdapter.TAB_ONE, false);
                binding.homeLayout.setSelected(true);
                binding.orderLayout.setSelected(false);
                binding.personLayout.setSelected(false);
                break;
            case R.id.order_layout:
                binding.mainPager.setCurrentItem(CustomViewPagerAdapter.TAB_TWO, false);
                binding.homeLayout.setSelected(false);
                binding.orderLayout.setSelected(true);
                binding.personLayout.setSelected(false);
                break;
            case R.id.person_layout:
                binding.mainPager.setCurrentItem(CustomViewPagerAdapter.TAB_THREE, false);
                binding.homeLayout.setSelected(false);
                binding.orderLayout.setSelected(false);
                binding.personLayout.setSelected(true);
                break;
        }
    }

    /*
     底部选项切换
    */
    private void switchItem(int param) {
        switch (param) {
            case CustomViewPagerAdapter.TAB_ONE:
                binding.homeLayout.setSelected(true);
                binding.orderLayout.setSelected(false);
                binding.personLayout.setSelected(false);
                break;
            case CustomViewPagerAdapter.TAB_TWO:
                binding.homeLayout.setSelected(false);
                binding.orderLayout.setSelected(false);
                binding.personLayout.setSelected(false);
                break;
            case CustomViewPagerAdapter.TAB_THREE:
                binding.homeLayout.setSelected(false);
                binding.orderLayout.setSelected(false);
                binding.personLayout.setSelected(true);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public void getData(){
        mPresenter.getWeather("101030100");
    }

    @Override
    public void getWeather(WeatherEntity bean) {

    }

    @Override
    public void toastWeather(String msg) {
        Toast.makeText(MainActivity.this,msg,Toast.LENGTH_LONG).show();
    }

    @Override
    public void showLoading(String msg) {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showBusinessError(ErrorBean error) {

    }

    @Override
    public void showException(ErrorBean error) {
        Toast.makeText(MainActivity.this,error.getMsg(),Toast.LENGTH_LONG).show();
    }


}
