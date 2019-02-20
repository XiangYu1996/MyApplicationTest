package com.example.asus_pc.listview;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListViewDemoActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String LIST_VIEW_DATA_COUNTS = "list_view_data_counts";
    public static final String PREFERENCE_NAME = "preference_name";
    public static final int DEF_VALUE = 10;
    private ListView mPhoneBookListView;
    private List<UserInfo> mUserInfos;
    private  int mDataCounts=10;
    private PhoneBookAdapter mPhoneBookAdapter;
    private EditText mDataCountText;
    private Button mConfirmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_demo);

        findViews();
        setData();
        setListeners();


    }

    private void findViews() {
        mPhoneBookListView = (ListView) findViewById(R.id.list_view);
        mDataCountText = (EditText) findViewById(R.id.data_counts_edit_text);
        mConfirmButton = (Button) findViewById(R.id.confirm_button);


    }



    @NonNull
    private  void setData() {

        SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE);

        mDataCounts = sharedPreferences.getInt(LIST_VIEW_DATA_COUNTS, DEF_VALUE);

        mDataCountText.setText(String.valueOf(mDataCounts));
        mUserInfos = new ArrayList<>();
        for (int index = 0; index < mDataCounts; index++) {
            mUserInfos.add(new UserInfo("张三",21));
        }

        mPhoneBookAdapter = new PhoneBookAdapter(ListViewDemoActivity.this,mUserInfos);
        mPhoneBookListView.setAdapter(mPhoneBookAdapter);

    }


    private void setListeners() {
        mPhoneBookListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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

                    mPhoneBookAdapter.refreshData(mUserInfos);
                    //更新数据
                    mPhoneBookAdapter.notifyDataSetChanged();

                }
                Toast.makeText(ListViewDemoActivity.this,mUserInfos.get(i).getUserName()+"被我点击了，怎么办？",Toast.LENGTH_LONG).show();
            }
        });

        mPhoneBookListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListViewDemoActivity.this,mUserInfos.get(i).getUserName()+"被我长按了，怎么办？",Toast.LENGTH_LONG).show();
                return false;
            }
        });


        mConfirmButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.confirm_button:
                String countString = mDataCountText.getText().toString();
                mDataCounts = Integer.valueOf(countString);
                refreshLIstView();
                saveData2Preference(mDataCounts);
                break;

        }
    }

    private void saveData2Preference(int dataCounts) {

        //系统会为我们自动创建一个xml文件   名字是preference_name  地址在：data/data/Shard_prefs
        SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);;
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt(LIST_VIEW_DATA_COUNTS,dataCounts);

//        修改   就是再写一遍 不同的
//        editor.putInt(LIST_VIEW_DATA_COUNTS,dataCounts+1);

        //删除  editor.remove(LIST_VIEW_DATA_COUNTS); 也要commit（）
        //刷新
        //editor.commit();
        //和网络相关，和IO操作相关，都要用异步，
        //后台写数据，另开线程
        editor.apply();





    }

    private void refreshLIstView() {
        mUserInfos.clear();
        for (int index = 0; index < mDataCounts; index++) {
            mUserInfos.add(new UserInfo("张三",21));
        }
        mPhoneBookAdapter.refreshData(mUserInfos);
        //更新数据
        mPhoneBookAdapter.notifyDataSetChanged();
    }
}
