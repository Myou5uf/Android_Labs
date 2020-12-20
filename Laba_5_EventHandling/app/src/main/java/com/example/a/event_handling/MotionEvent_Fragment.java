package com.example.a.event_handling;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MotionEvent_Fragment extends Fragment {
    private TextView    motionEvent_tv1;
    private TextView     motionEvent_tv2;

    public MotionEvent_Fragment(){
        super(R.layout.activity_motionevent);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_motionevent, parent, false);
    }

    public void handleTouch(MotionEvent e) {
        int pointCounter = e.getPointerCount();

        for (int i = 0; i < pointCounter; i++) {
            int x = (int) e.getX(i);
            int y = (int) e.getY(i);
            int id = e.getPointerId(i) + 1;

            int action = e.getActionMasked();
            int actionIndex = e.getActionIndex();

            String actionStr;

            switch (action) {
                case MotionEvent.ACTION_DOWN:
                    actionStr = "Button clicked";
                    break;
                case MotionEvent.ACTION_UP:
                    actionStr = "Button unclicked";
                    break;
                case MotionEvent.ACTION_POINTER_DOWN:
                    actionStr = "Pointer down";
                    break;
                case MotionEvent.ACTION_POINTER_UP:
                    actionStr = "Pointer up";
                    break;
                case MotionEvent.ACTION_MOVE:
                    actionStr = "Moving";
                    break;
                default:
                    actionStr = "";
            }

            String status = "Action: " + actionStr + " Index: " + actionIndex + " ID: " + id + " X: " + x + " Y: " + y;
            if (id == 0) {
                motionEvent_tv1.setText(status);
            } else {
                motionEvent_tv2.setText(status);
            }
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        motionEvent_tv1 = getView().findViewById(R.id.me_tv_1);
        motionEvent_tv2 = getView().findViewById(R.id.me_tv_2);
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                handleTouch(event);
                return true;
            }
        });
    }
}
