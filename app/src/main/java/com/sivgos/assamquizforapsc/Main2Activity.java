package com.sivgos.assamquizforapsc;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.text.method.ScrollingMovementMethod;
import java.util.Random;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class Main2Activity extends AppCompatActivity {

    TextView Question1,Result1;
    RadioGroup AllOpts;
    RadioButton opt1,opt2,opt3,opt4;
    Button NxtBtn,ExtBtn;
    QuestionDatabase Qn;
    int qnlength;
    private int correct_ans;
    int index1;
    int order1[]=null;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);

        Question1 = (TextView) findViewById(R.id.Question);
        Result1 = (TextView) findViewById(R.id.Result);
        AllOpts = (RadioGroup) findViewById(R.id.AllOptions);
        opt1 = (RadioButton) findViewById(R.id.Option1);
        opt2 = (RadioButton) findViewById(R.id.Option2);
        opt3 = (RadioButton) findViewById(R.id.Option3);
        opt4 = (RadioButton) findViewById(R.id.Option4);
        NxtBtn = (Button) findViewById(R.id.NextBtn);
        ExtBtn = (Button) findViewById(R.id.ExitBtn);
        Qn = new QuestionDatabase();
        qnlength = Qn.mQuestions.length;
        index1 = 0;
        order1 = new int[qnlength];
        Random rnd1 = new Random();
        for(int i=0;i<qnlength;i++)
        {
            order1[i] = rnd1.nextInt(qnlength);
        }
        updateQuestion(index1);//.nextInt(qnlength));
        mAdView = (AdView) findViewById(R.id.adView);
        //Setting widths and height
        /*int heigth1 = Resources.getSystem().getDisplayMetrics().widthPixels;
        int width1 = Resources.getSystem().getDisplayMetrics().heightPixels;*/
        int width1 = 0;
        int heigth1 = 0;
        Point size = new Point();
        WindowManager w = getWindowManager();

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)    {
            w.getDefaultDisplay().getSize(size);
            width1 = size.x;
            heigth1 = size.y;
        }else{
            Display d = w.getDefaultDisplay();
            width1 = d.getWidth();
            heigth1 = d.getHeight();
        }
       /* Question1.setX((float)0.05);
        Question1.setY(0);
        Question1.setHeight((int)0.35*heigth1);
        Question1.setWidth((int)(0.9*width1));
        AllOpts.setX((float)0.05);
        AllOpts.setY((float)0.26);
        AllOpts.setWeightSum(width1);
        opt1.setX((float)0.05);
        opt1.setY((float)0.36);
        opt1.setWidth((int)(0.9*width1));
        opt1.setHeight((int)(0.09*heigth1));
        opt2.setX((float)0.05);
        opt2.setY((float)0.46);
        opt2.setWidth((int)(0.9*width1));
        opt2.setHeight((int)(0.09*heigth1));
        opt3.setX((float)0.05);
        opt3.setY((float)0.56);
        opt3.setWidth((int)(0.9*width1));
        opt3.setHeight((int)(0.09*heigth1));
        opt4.setX((float)0.05);
        opt4.setY((float)0.66);
        opt4.setWidth((int)(0.9*width1));
        opt4.setHeight((int)(0.09*heigth1));
        Result1.setX((float)0.05);
        Result1.setY((float)0.76);
        Result1.setWidth((int)(0.9*width1));
        Result1.setHeight((int)(0.04*heigth1));
        ExtBtn.setX((float)0.05);
        ExtBtn.setY((float)0.81);
        ExtBtn.setWidth((int)(0.49*width1));
        ExtBtn.setHeight((int)(0.04*heigth1));
        NxtBtn.setX((float)0.5);
        NxtBtn.setY((float)0.81);
        NxtBtn.setWidth((int)(0.49*width1));
        NxtBtn.setHeight((int)(0.04*heigth1));
        mAdView.setX((float)0.05);
        mAdView.setY((float)0.86);*/
        NxtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //updateQuestion(index1.nextInt(qnlength));
                index1 = (index1+1)%qnlength;
                updateQuestion(index1);
            }
        });
        NxtBtn.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public  boolean onLongClick(View v){
                index1 = (index1+10)%qnlength;
                updateQuestion(index1);
                return true;
            }

        });
        ExtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                i.setFlags(i.FLAG_ACTIVITY_CLEAR_TOP);
                i.putExtra("EXIT",true);
                startActivity(i);
            }
        });
        Question1.setMovementMethod(new ScrollingMovementMethod());

        AllOpts.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.Option1:
                        if(correct_ans == 1)
                        {
                            Result1.setText("Correct Answer");
                        }
                        else
                        {
                            Result1.setText("Incorrect Answer");
                        }
                        break;
                    case R.id.Option2:
                        if(correct_ans == 2)
                        {
                            Result1.setText("Correct Answer");
                        }
                        else
                        {
                            Result1.setText("Incorrect Answer");
                        }
                        break;
                    case R.id.Option3:
                        if(correct_ans == 3)
                        {
                            Result1.setText("Correct Answer");
                        }
                        else
                        {
                            Result1.setText("Incorrect Answer");
                        }
                        break;
                    case R.id.Option4:
                        if(correct_ans == 4)
                        {
                            Result1.setText("Correct Answer");
                        }
                        else
                        {
                            Result1.setText("Incorrect Answer");
                        }
                        break;

                    default: Result1.setText("   ");
                    break;
                }
            }
        });

        MobileAds.initialize(this,"ca-app-pub-6858242047277483~6060091914");
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }

    private void updateQuestion(int n)
    {
       /* if(Qn.mQuestions[n].length()<70)
            Question1.setTextSize(26);
        else if(Qn.mQuestions[n].length()<100)
            Question1.setTextSize(20);
        else
            Question1.setTextSize(16);*/
      // int n = order1[n0];
        if(Qn.FirstOption[n].length()<70)
            opt1.setTextSize(18);
        else
            opt1.setTextSize(14);
        if(Qn.SecondOption[n].length()<70)
            opt2.setTextSize(18);
        else
            opt2.setTextSize(14);
        if(Qn.ThirdOption[n].length()<70)
            opt3.setTextSize(18);
        else
            opt3.setTextSize(14);
        if(Qn.FourthOption[n].length()<70)
            opt4.setTextSize(18);
        else
            opt4.setTextSize(14);
        Question1.setScrollY(0);
        Question1.setText(String.valueOf(n+1)+". ");
        Question1.append(Qn.getQuestion(n));
        AllOpts.setVisibility(View.VISIBLE);
        opt1.setText(Qn.getOpt1(n));
        opt2.setText(Qn.getOpt2(n));
        opt3.setText(Qn.getOpt3(n));
        opt4.setText(Qn.getOpt4(n));
        opt1.setEnabled(true);
        opt2.setEnabled(true);
        opt3.setEnabled(true);
        AllOpts.setEnabled(true);
        opt4.setEnabled(true);
        opt1.setChecked(false);
        opt2.setChecked(false);
        opt3.setChecked(false);
        opt4.setChecked(false);
        Result1.setText(" ");
        correct_ans = Qn.getAns(n);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (index1 !=0) {
                index1 = index1 - 1;
                updateQuestion(index1);
                return false;
            }
            else
            {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                i.setFlags(i.FLAG_ACTIVITY_CLEAR_TOP);
                i.putExtra("EXIT",true);
                startActivity(i);
            }
        }
        return super.onKeyDown(keyCode, event);
    }

}
