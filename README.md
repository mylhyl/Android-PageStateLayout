# 简介
Adnroid界面数据从网络加载情况下的状态切换：包括加载中、加载失败、加载空数据、网络异常

# 引用
 ```xml
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

 `implementation 'com.github.mylhyl:Android-PageStateLayout:1.0.4'`

 [下载APK体验](https://fir.im/vnqd)或手机扫描下面二维码  
 <img src="preview/qrdown.png"/>

# 使用
* layout中使用，注意PageStateLayout中只能包含一个子布局（需要显示的数据内容）
```xml
    <com.scwang.smartrefresh.layout.SmartRefreshLayout
        android:id="@+id/smartRefreshLayout"
        android:layout_width="match_parent"
        android:layout_height="match_parent">
        <!--app:psl_contentLayoutId="@id/recyclerView" 如果不指定，那么只能包含一个子视图-->
        <!--也可直接用原生 FrameLayout或 RelativeLayout 代替PageStateLayout，代码中则使有用 PageStateLayout.wrap(activity,int,int)-->
        <com.mylhyl.pagestate.PageStateLayout
            android:id="@+id/pageStateLayout"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            app:psl_contentLayoutId="@id/recyclerView"
            app:psl_emptyImgSrc="@mipmap/ic_push_msg_empty"
            app:psl_errorImgSrc="@mipmap/ic_pager_invalid"
            app:psl_errorNetImgSrc="@mipmap/ic_network_invalid">

            <android.support.v7.widget.RecyclerView
                android:id="@+id/recyclerView"
                android:layout_width="match_parent"
                android:layout_height="match_parent"/>

        </com.mylhyl.pagestate.PageStateLayout>
```
* 代码中使用
```java
 //contentId：是与其它4个状态切换显示的数据内容布局id
PageStateLayout.wrap(Activity activity, int contentId)
PageStateLayout.wrap(Fragment fragment, int contentId)
PageStateLayout.wrap(Activity activity, int contentParentId, int contentId)
PageStateLayout.wrap(View rootLayout, @IdRes int contentId)
```
更多请查看`wrap`方法重载

如下：
PageStateLayout.wrap(MainActivity.this, R.id.psl_content)
[xml](https://github.com/mylhyl/Android-PageStateLayout/blob/v1/app/src/main/res/layout/activity_detail_no_action_bar.xml)


# 提供方法
[代码支持的方法](https://github.com/mylhyl/Android-PageStateLayout/blob/master/library/src/main/java/com/mylhyl/pagestate/PageState.java)  
[layout支持的属性](https://github.com/mylhyl/Android-PageStateLayout/blob/master/library/src/main/res/values/library_psl_attrs.xml)

# 全局替换
* layout.xml 在工程中新建需要自定义的布局，文件名必须与[library-layout](https://github.com/mylhyl/Android-PageStateLayout/tree/master/library/src/main/res/layout)相同，且view的id也必须相同  
* color.xml资源文件的name必须相同，[传送门](https://github.com/mylhyl/Android-PageStateLayout/blob/master/library/src/main/res/values/library_psl_colors.xml)  
* `正在加载...`、`暂无数据`、`加载失败`、`网络异常请检查`不喜欢可替换，string.xml资源文件的[name](https://github.com/mylhyl/Android-PageStateLayout/blob/master/library/src/main/res/values/library_psl_strings.xml)必须相同
