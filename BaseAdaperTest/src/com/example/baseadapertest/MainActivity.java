package com.example.baseadapertest;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Toast;

public class MainActivity extends ListActivity {
//	private CheckBox CheckBox_cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
 
        CharSequence[] list = getResources().getStringArray(R.array.books);
        setListAdapter(new MyAdapter(this, list));
        
        Toast.makeText(this, "Adapter has set.1", Toast.LENGTH_SHORT).show();
        Toast.makeText(MainActivity.this, "Adapter has set.2", Toast.LENGTH_SHORT).show();
    }
}

//http://androidstudent13.blogspot.tw/2013/10/baseadapter.html
