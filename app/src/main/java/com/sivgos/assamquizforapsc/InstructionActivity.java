package com.sivgos.assamquizforapsc;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class InstructionActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);
        //getActionBar().setDisplayHomeAsUpEnabled(true);
        final ListView listView;
        listView = (ListView) findViewById(R.id.inst_list);
        ArrayList<String>newList = new ArrayList<String>();
        newList.add("If a question is long and does not fit in display, you can scroll it. Just touch the question with your finger and gently swipe up.");
        newList.add("You can view the previous question by clicking the Back button of your mobile.");
        newList.add("You can Long Press the NEXT button to jump 10 questions ahead at a time.");
        ListAdapter listAdapter = new ArrayAdapter<String>(this,R.layout.activity_listview,newList);
        listView.setAdapter(listAdapter);
        final Button ret = (Button) findViewById(R.id.inst_close);
        ret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });

    }

}
