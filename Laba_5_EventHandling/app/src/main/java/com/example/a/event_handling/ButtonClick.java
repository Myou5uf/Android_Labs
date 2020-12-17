package com.example.a.event_handling;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Objects;

public class ButtonClick extends Fragment {

    private TextView tv;

    public ButtonClick() {
        super(R.layout.activity_butclick);
    }

    private final View.OnClickListener butClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            tv.setText("Button clicked");
        }
    };

    private final View.OnLongClickListener butClickLongListener = new View.OnLongClickListener(){
        @Override
        public boolean onLongClick(View v){
            tv.setText("Long button click");
            return true;
        }
    };

    @Override
    public void onViewCreated(View view, @Nullable Bundle saveInstanceState){
        tv = (TextView)requireView().findViewById(R.id.but_tv);
        Button b = getView().findViewById(R.id.button);
        b.setOnClickListener(butClickListener);
        b.setOnLongClickListener(butClickLongListener);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle saveInstanceState){
        return inflater.inflate(R.layout.activity_butclick, parent, false);
    }


}
