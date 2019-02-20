package com.example.asus_pc.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GridViewDemoActivity extends AppCompatActivity {
    private GridView mPhoneBookGridView;
    private List<UserInfo> mUserInfos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view_demo);

        mPhoneBookGridView = (GridView) findViewById(R.id.grid_view);
        mUserInfos = new ArrayList<>();
        mUserInfos.add(new UserInfo("张三",21));
        mUserInfos.add(new UserInfo("张三111",23));
        mUserInfos.add(new UserInfo("张三222",21));
        mUserInfos.add(new UserInfo("张三",21));
        mUserInfos.add(new UserInfo("张三111",23));
        mUserInfos.add(new UserInfo("张三222",21));
        mUserInfos.add(new UserInfo("张三",21));
        mUserInfos.add(new UserInfo("张三111",23));
        mUserInfos.add(new UserInfo("张三222",21));
        mUserInfos.add(new UserInfo("张三",21));
        mUserInfos.add(new UserInfo("张三111",23));
        mUserInfos.add(new UserInfo("张三222",21));
        mUserInfos.add(new UserInfo("张三",21));
        mUserInfos.add(new UserInfo("张三111",23));
        mUserInfos.add(new UserInfo("张三222",21));
        mUserInfos.add(new UserInfo("张三",21));
        mUserInfos.add(new UserInfo("张三111",23));
        mUserInfos.add(new UserInfo("张三222",21));

        final PhoneBookAdapter phoneBookAdapter = new PhoneBookAdapter(GridViewDemoActivity.this,mUserInfos);
        mPhoneBookGridView.setAdapter(phoneBookAdapter);

        //更新数据
        phoneBookAdapter.notifyDataSetChanged();

        mPhoneBookGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0){
                    //新建另外一批数据
                    //替换老的数据
                    //刷新ListView，让它更新自己的视图
                    mUserInfos.clear();
                    mUserInfos.add(new UserInfo("我是新的数据1",23));
                    mUserInfos.add(new UserInfo("我是新的数据2",28));
                    mUserInfos.add(new UserInfo("我是新的数据3",23));

                    phoneBookAdapter.refreshData(mUserInfos);

                }
                Toast.makeText(GridViewDemoActivity.this,mUserInfos.get(i).getUserName()+"被我点击了，怎么办？",Toast.LENGTH_LONG).show();
            }
        });

        mPhoneBookGridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(GridViewDemoActivity.this,mUserInfos.get(i).getUserName()+"被我长按了，怎么办？",Toast.LENGTH_LONG).show();
                return false;
            }
        });


    }
}
