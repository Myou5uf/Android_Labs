package com.example.a.event_handling;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

public class ButtonClick extends Fragment {

    public ButtonClick() {
        super(R.layout.activity_butclick);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle saveInstanceState){
        return inflater.inflate(R.layout.activity_butclick, parent, false);
    }
}
