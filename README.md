# KeywordsFlowView
###随机布满屏幕的文字，飞入飞出动画效果的控件。

文字颜色随机，数量可设置,支持滑动屏幕切换文字
##示例
![1](https://github.com/wenhuaijun/KeywordsFlowView/blob/master/introduce/S60225-134045.jpg " ")
![2](https://github.com/wenhuaijun/KeywordsFlowView/blob/master/introduce/S60225-135726.jpg " ")
![3](https://github.com/wenhuaijun/KeywordsFlowView/blob/master/introduce/S60225-135738.jpg " ")

##KeywordsFlowView的布局

         <com.wenhuaijun.keywordsflowdemo.KeywordsFlowView
           android:id="@+id/keywordsFlowView"
           android:layout_width="match_parent"
           android:layout_height="match_parent"
           />
##KeywordsFlowView的java代码

          public static final String[] keywords = { "Apple", "Android", "呵呵",
            "高富帅","女神","拥抱","旅行","爱情","屌丝","搞笑","暴走漫画","重邮","信科",
            "唯美","汪星人","秋天","雨天","科幻","黑夜",
            "孤独","星空","东京食尸鬼","金正恩","张全蛋","东京热","陈希妍",
            "明星","NBA","马云","码农","动漫","时尚","熊孩子","地理","伤感",
            "二次元"
    };
         keywordsFlowView = (KeywordsFlowView)findViewById(R.id.keywordsFlowView);
         //设置每次随机飞入文字的个数
         keywordsFlowView.setTextShowSize(15);
         //设置是否允许滑动屏幕切换文字
         keywordsFlowView.shouldScroolFlow(true);
         //开始展示
         keywordsFlowView.show(keywords, KeywordsFlow.ANIMATION_IN);//文字随机飞入
         keywordsFlowView.show(keywords,KeywordsFlow.ANIMATION_OUT);//文字随机飞出
         //监听文字的点击事件
         keywordsFlowView.setOnItemClickListener(this);//点击文字会将TextView返回到onClick（View view）回调中
   
   
