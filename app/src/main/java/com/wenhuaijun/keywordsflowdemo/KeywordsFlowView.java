package com.wenhuaijun.keywordsflowdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;

import java.util.Random;

/**
 * Created by Administrator on 2016/2/24 0024.
 */
public class KeywordsFlowView extends KeywordsFlow{
    //手势滑动
    public static final int SNAP_VELOCITY = 50;
    private float yDown;
    private float yMove;
    private float yUp;
    private String[] words;
    private boolean shouldScroolFlow = true;
    //用于计算手指滑动的速度。
    private VelocityTracker mVelocityTracker;
    public KeywordsFlowView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public KeywordsFlowView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public KeywordsFlowView(Context context) {
        super(context);
    }



    public void  setWords(String[] words){
        this.words =words;
    }
    public void show(String[] words,int animType){
        setWords(words);
        rubKeywords();
        feedKeywordsFlow(this, words);
        go2Show(animType);
    }
    private static void feedKeywordsFlow(KeywordsFlow keywordsFlow, String[] words) {
        Random random = new Random();
        for (int i = 0; i < KeywordsFlow.MAX; i++) {
            int ran = random.nextInt(words.length);
            String tmp = words[ran];
            keywordsFlow.feedKeyword(tmp);
        }
    }
    public void setTextShowSize(int size){
        MAX=size;
    }
    public void shouldScroolFlow(boolean shouldScroolFlow){
        this.shouldScroolFlow =shouldScroolFlow;
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(!shouldScroolFlow){
            return  super.onTouchEvent(event);
        }
        createVelocityTracker(event);
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                yDown=event.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                yMove=event.getRawY();
                break;
            case MotionEvent.ACTION_UP:
                yUp=event.getRawY();
                float distance=yUp-yDown;
                if(distance<-100&& getScrollVelocity() > SNAP_VELOCITY){
                    rubKeywords();
                     feedKeywordsFlow(this, words);
                    go2Show(KeywordsFlow.ANIMATION_OUT);
                }else if(distance>30&&getScrollVelocity() > SNAP_VELOCITY){
                    rubKeywords();
                    feedKeywordsFlow(this, words);
                    go2Show(KeywordsFlow.ANIMATION_IN);
                }
                break;

        }
        return true;
    }
    private void createVelocityTracker(MotionEvent event) {
        if (mVelocityTracker == null) {
            mVelocityTracker = VelocityTracker.obtain();
        }
        mVelocityTracker.addMovement(event);
    }
    private int getScrollVelocity() {
        mVelocityTracker.computeCurrentVelocity(1000);
        int velocity = (int) mVelocityTracker.getXVelocity();
        return Math.abs(velocity);
    }
}
