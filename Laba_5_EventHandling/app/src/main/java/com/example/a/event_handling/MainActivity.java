package com.example.a.event_handling;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import java.util.Objects;

import android.os.Bundle;




public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                    .add(R.id.fragment_container_view, ButtonClick.class, null).commit();
        }
    }

    public  boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void menu_activity(MenuItem item){
        FragmentManager fgmg = getSupportFragmentManager();
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        Objects.requireNonNull(getSupportActionBar()).setSubtitle(item.getTitle());

        switch (item.getItemId()){
            case R.id.menuitem_bc:
                fgmg.beginTransaction().replace(R.id.fragment_container_view, ButtonClick.class, null)
                        .setReorderingAllowed(true).addToBackStack("name")//can be null
                        .commit();
                return;

            case R.id.menuitem_me:
                fgmg.beginTransaction().replace(R.id.fragment_container_view, MotionEvent_Fragment.class, null)
                        .setReorderingAllowed(true).addToBackStack("name").commit();
                return;

            case R.id.menuitem_cg:
                fgmg.beginTransaction().replace(R.id.fragment_container_view, CommonGestures.class, null)
                        .setReorderingAllowed(true).addToBackStack("name").commit();

        }
    }
}