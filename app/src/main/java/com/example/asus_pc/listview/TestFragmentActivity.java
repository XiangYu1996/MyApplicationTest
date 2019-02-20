package com.example.asus_pc.listview;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;

public class TestFragmentActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_test);

        FragmentManager fragmentManager = getFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //创建一个fragment实例
        TestFragment testFragment = TestFragment.newInstance("我是极客班",15);

        //将其添加到ViewGroup
        fragmentTransaction.add(R.id.fragment_view,testFragment).commit();

        //将其移除    commit刷新
        //fragmentTransaction.remove(testFragment).commit();

        //找到我们的fragment
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_test);

        fragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {

            }
        });
        if(fragment instanceof TestFragment){
            //TODO: Do your action
        }else{
            throw new IllegalStateException("is not testFragment");

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
