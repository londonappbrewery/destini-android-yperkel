package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView mStoryText;
    Button topButton;
    Button botButton;
    String mStory;
    int mStoryIndex = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null) {
            mStoryIndex = savedInstanceState.getInt("IndexKey");
        }else
            mStoryIndex = 1;
        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryText = (TextView) findViewById(R.id.storyTextView);
        topButton = (Button) findViewById(R.id.buttonTop);
        botButton = (Button) findViewById(R.id.buttonBottom);
        if(mStoryIndex == 1 || mStoryIndex == 0)
            toT1();
        else if(mStoryIndex == 2)
            toT2();
        else if(mStoryIndex == 3)
            toT3();
        else if(mStoryIndex == 4)
            toT4();
        else if(mStoryIndex == 5)
            toT5();
        else
            toT6();

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        topButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mStoryIndex == 3){
                    toT6();
                }else {
                    toT3();
                }
            }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        botButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mStoryIndex == 1){
                    toT2();
                }else if(mStoryIndex == 2){
                    toT4();
                }else{
                    toT5();
                }
            }
        });

    }

    public void toT1(){
        mStoryText.setText(R.string.T1_Story);
        topButton.setText(R.string.T1_Ans1);
        botButton.setText(R.string.T1_Ans2);
        mStoryIndex = 1;
    }

    public void toT2(){
        mStoryText.setText(R.string.T2_Story);
        topButton.setText(R.string.T2_Ans1);
        botButton.setText(R.string.T2_Ans2);
        mStoryIndex = 2;
    }

    public void toT3(){
        mStoryText.setText(R.string.T3_Story);
        topButton.setText(R.string.T3_Ans1);
        botButton.setText(R.string.T3_Ans2);
        mStoryIndex = 3;
    }
    public void toT4(){
        mStoryText.setText(R.string.T4_End);
        botButton.setVisibility(View.GONE);
        topButton.setVisibility(View.GONE);
        mStoryIndex = 4;
    }
    public void toT5(){
        mStoryText.setText(R.string.T5_End);
        botButton.setVisibility(View.GONE);
        topButton.setVisibility(View.GONE);
        mStoryIndex = 5;
    }
    public void toT6(){
        mStoryText.setText(R.string.T6_End);
        botButton.setVisibility(View.GONE);
        topButton.setVisibility(View.GONE);
        mStoryIndex = 6;
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("indexKey", mStoryIndex);
    }
}
