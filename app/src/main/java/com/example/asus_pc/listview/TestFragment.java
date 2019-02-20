package com.example.asus_pc.listview;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TestFragment extends Fragment {
    public static final String ARGUMENT_NAME = "argument_name";
    public static final String ARGUMENT_NUMBER = "argument_number";
    private String mName;
    private int mNumber;


    public static TestFragment newInstance(String nameString, int number){


        TestFragment testFragment = new TestFragment();

        Bundle bundle = new Bundle();
        bundle.putString(ARGUMENT_NAME,nameString);
        bundle.putInt(ARGUMENT_NUMBER,number);
        testFragment.setArguments(bundle);

        return  testFragment;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();

        if (bundle != null){
            mName = bundle.getString(ARGUMENT_NAME);
            mNumber = bundle.getInt(ARGUMENT_NUMBER);
        }
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.item_phone_book_friend,container,false);

        TextView nameTextView = (TextView) view.findViewById(R.id.name_text_view);
        nameTextView.setText(mName);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
