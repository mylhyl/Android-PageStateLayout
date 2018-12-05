# 简介
Adnroid界面数据从网络加载情况下的状态切换：包括加载中、加载失败、加载空数据、网络异常

# 引用
 [ ![Download](https://api.bintray.com/packages/mylhyl/maven/pageStateLayout/images/download.svg) ](https://bintray.com/mylhyl/maven/pageStateLayout/_latestVersion)
 `implementation 'com.mylhyl:pageStateLayout:latestVersion'`
 [下载APK体验](https://fir.im/vnqd)或手机扫描下面二维码
 <img src="preview/qrdown.png"/>

# 使用
* layout中使用
```xml
    <com.mylhyl.pagestate.PageStateLayout
        android:id="@+id/pageStateLayout"
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <com.scwang.smartrefresh.layout.SmartRefreshLayout
            android:id="@+id/smartRefreshLayout"
            android:layout_width="match_parent"
            android:layout_height="match_parent">

            <android.support.v7.widget.RecyclerView
                android:id="@+id/recyclerView"
                android:layout_width="match_parent"
                android:layout_height="match_parent"/>

        </com.scwang.smartrefresh.layout.SmartRefreshLayout>
    </com.mylhyl.pagestate.PageStateLayout>
```
* 代码中使用
```java
PageStateLayout.wrap(Activity activity, int contentId)
PageStateLayout.wrap(Fragment fragment, int contentId)
```
更多请查看`wrap`方法重载

# 提供方法
[代码支持的方法](https://github.com/mylhyl/Android-PageStateLayout/blob/master/library/src/main/java/com/mylhyl/pagestate/PageState.java)  
[layout支持的属性](https://github.com/mylhyl/Android-PageStateLayout/blob/master/library/src/main/res/values/library_psl_attrs.xml)

# 全局替换
* layout.xml 在工程中新建需要自定义的布局，文件名必须与[library-layout](https://github.com/mylhyl/Android-PageStateLayout/tree/master/library/src/main/res/layout)相同，且view的id也必须相同  
* color.xml资源文件的name必须相同，[传送门](https://github.com/mylhyl/Android-PageStateLayout/blob/master/library/src/main/res/values/library_psl_colors.xml)  
* `正在加载...`、`暂无数据`、`加载失败`、`网络异常请检查`不喜欢可替换，string.xml资源文件的[name](https://github.com/mylhyl/Android-PageStateLayout/blob/master/library/src/main/res/values/library_psl_strings.xml)必须相同
