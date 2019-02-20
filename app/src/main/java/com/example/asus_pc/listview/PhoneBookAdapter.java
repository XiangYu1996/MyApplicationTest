package com.example.asus_pc.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS-PC on 2018/12/26.
 */

public class PhoneBookAdapter extends BaseAdapter{
    private Context mContext;

    private LayoutInflater mLayoutInflater;

    private List<UserInfo> mUserInfos = new ArrayList<>();


    public PhoneBookAdapter(Context context,List<UserInfo> userInfos) {
        mContext = context;
        mUserInfos = userInfos;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        //有多少条数据
        return mUserInfos.size();
    }

    @Override
    public Object getItem(int i) {
        //返回某一条数据对象
        return mUserInfos.get(i);
    }

    @Override
    public long getItemId(int i) {
        //
        return i;
    }


    //item不同时
    @Override
    public int getItemViewType(int i){


        return super.getItemViewType(i);
    }

    /**
     * 每一行数据显示在界面，用户能看到时
     * @param i
     * @param view
     * @param viewGroup
     * @return
     */
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {


        //返回一个视图
        ViewHolder viewHolder;
        if (view == null) {
            view = mLayoutInflater.inflate(R.layout.item_phone_book_friend, null);
            viewHolder = new ViewHolder();
            //获取控件
            viewHolder.nameTextView       = (TextView) view.findViewById(R.id.name_text_view);
            viewHolder.ageTextView       = (TextView) view.findViewById(R.id.age_text_view);
            viewHolder.avantarImageView = (ImageView) view.findViewById(R.id.avantar_image_view);


            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }

        //和数据之间进行绑定
        viewHolder.nameTextView.setText(mUserInfos.get(i).getUserName());
        viewHolder.ageTextView.setText(String.valueOf(mUserInfos.get(i).getAge()));
        viewHolder.avantarImageView.setImageResource(R.drawable.ic_launcher);
        return view;

    }

    class ViewHolder{
        TextView nameTextView;
        TextView ageTextView;
        ImageView avantarImageView;


    }

    /**
     * 刷新数据
     * @param userInfos
     */
    public void refreshData(List<UserInfo> userInfos){
        mUserInfos = userInfos;
        notifyDataSetChanged();

    }

}
