package com.wenhuaijun.keywordsflowdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    KeywordsFlowView keywordsFlowView;
    Button flow_in;
    Button flow_out;

    public static final String[] keywords = { "Apple", "Android", "呵呵",
            "高富帅","女神","拥抱","旅行","爱情","屌丝","搞笑","暴走漫画","重邮","信科",
            "唯美","汪星人","秋天","雨天","科幻","黑夜",
            "孤独","星空","东京食尸鬼","金正恩","张全蛋","东京热","陈希妍",
            "明星","NBA","马云","码农","动漫","时尚","熊孩子","地理","伤感",
            "二次元"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flow_in =(Button)findViewById(R.id.flow_in);
        flow_out =(Button)findViewById(R.id.flow_out);
        keywordsFlowView = (KeywordsFlowView)findViewById(R.id.keywordsFlowView);
        //设置每次随机飞入文字的个数
        keywordsFlowView.setTextShowSize(15);
        //设置是否允许滑动屏幕切换文字
        keywordsFlowView.shouldScroolFlow(true);
        //开始展示
        keywordsFlowView.show(keywords, KeywordsFlow.ANIMATION_IN);
        flow_in.setOnClickListener(this);
        flow_out.setOnClickListener(this);
        //设置文字的点击点击监听
        keywordsFlowView.setOnItemClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,((TextView)v).getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onClick(View v) {
        if(v==flow_in){
            //文字随机飞入
            keywordsFlowView.show(keywords,KeywordsFlow.ANIMATION_IN);
        }else if (v==flow_out){
            //文字随机飞出
            keywordsFlowView.show(keywords,KeywordsFlow.ANIMATION_OUT);
        }
    }
}
