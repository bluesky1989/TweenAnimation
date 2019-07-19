package com.dyq.animatordemo;

import android.animation.AnimatorInflater;
import android.animation.LayoutTransition;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button mButtonAdd;
    private LinearLayout mLinearLayout;
    private TextView tv_content;

    int count;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonAdd= (Button) findViewById(R.id.button_add);
        mLinearLayout= (LinearLayout) findViewById(R.id.linearLayout);
        tv_content=findViewById(R.id.tv_content);

        LayoutTransition transition =new LayoutTransition();
        transition.getDuration(2000);//时间

        //APPEARING添加view的动画
        transition.setAnimator(LayoutTransition.APPEARING, AnimatorInflater.loadAnimator(getApplicationContext(),R.animator.animator_scale));
        transition.setAnimator(LayoutTransition.CHANGE_APPEARING,transition.getAnimator(LayoutTransition.CHANGE_APPEARING));//CHANGE_APPEARING消失动画
        transition.setAnimator(LayoutTransition.DISAPPEARING,transition.getAnimator(LayoutTransition.DISAPPEARING));//DISAPPEARING移除view的动画
        transition.setAnimator(LayoutTransition.CHANGE_DISAPPEARING,transition.getAnimator(LayoutTransition.CHANGE_DISAPPEARING));

        mLinearLayout.setLayoutTransition(transition);//把动画加到按钮上



        mButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                count++;
                Button btn=new Button(MainActivity.this);
                ViewGroup.LayoutParams params=new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                btn.setLayoutParams(params);
                btn.setText("按钮"+count);
                btn.setScaleX(0f);
                btn.setScaleY(0f);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mLinearLayout.removeView(v);
//                        mLinearLayout.setVisibility(View.GONE);
                    }
                });

//               tv_content.setScaleX(0f);
//               tv_content.setScaleY(0f);
//               tv_content.setOnClickListener(new View.OnClickListener() {
//                   @Override
//                   public void onClick(View v) {
//                       mLinearLayout.setVisibility(View.GONE);
//                   }
//               });

                mLinearLayout.addView(btn);
//                mLinearLayout.setVisibility(View.VISIBLE);
            }
        });


    }
}
