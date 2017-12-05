package com.crycetruly.onboard;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private SliderAdapter adapter;
private RelativeLayout relativeLayout;
private ViewPager pager;
private LinearLayout linearLayout;
private TextView[] dots;
private Button back,next;
private int mCurrentPge;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout=findViewById(R.id.linearLayout);
        pager=findViewById(R.id.pager);
        back=findViewById(R.id.button);
        next=findViewById(R.id.button2);
        adapter =new SliderAdapter(this);
        pager.setAdapter(adapter);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pager.setCurrentItem(mCurrentPge-1);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pager.setCurrentItem(mCurrentPge+1);
                if (mCurrentPge==2)
                {
                        startActivity(new Intent(MainActivity.this,HomeActivity.class));
                }
            }
        });
        addDotIndicator(0);
        pager.addOnPageChangeListener(onPageChangeListener);
    }

    public void addDotIndicator(int position){
        Log.d(TAG, "addDotIndicator: ");
dots=new TextView[3];
for(int i=0;i<dots.length;i++){
    dots[i]=new TextView(this);
    dots[i].setText(Html.fromHtml("&#8226;"));
    dots[i].setTextColor(Color.WHITE);
    dots[i].setTextSize(35);
    linearLayout.addView(dots[i]);
}
if (dots.length>0){
    dots[position].setTextColor(Color.GRAY);
}
    }
    ViewPager.OnPageChangeListener onPageChangeListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
addDotIndicator(position);
mCurrentPge=position;
if (position ==0){
    back.setVisibility(View.GONE);
    back.setEnabled(false); next.setEnabled(true);
    back.setText("");
    next.setText("Next");
}else if (position==dots.length-1){
back.setEnabled(true); next.setEnabled(true); back.setVisibility(View.VISIBLE);
back.setText("Back");
next.setText("Finish");

}else {
    back.setEnabled(true);
    next.setEnabled(true);
    back.setVisibility(View.VISIBLE);
    back.setText("Back");
    next.setText("Next");
}
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
