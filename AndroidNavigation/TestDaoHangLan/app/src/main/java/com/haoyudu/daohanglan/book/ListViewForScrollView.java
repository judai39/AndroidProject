package com.haoyudu.daohanglan.book;


import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

//继承ListView是为了?--->重写onMeasure()以便于动态的获取
public class ListViewForScrollView extends ListView {
    public ListViewForScrollView(Context context) {
        super(context);
    }

    public ListViewForScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ListViewForScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        2：源码里有这么一段，如果测量模式是UNSPECIFIED，去执行的代码块{…}，这个模式很少用，一般都是match，或者wrap，对应的也就是EXACTLY和AT_MOST
//        3：如果高度测量模式是EXACTLY，不管内部子view如何，ListView的高度测量值就是该值，子view可以滚动的，不影响ListView的高度测量。
//        4：如果高度测量模式是AT_MOST，则会去测量子view的高度，但是测量的高度不会超过listView的父容器给他的最大高度，测量方法measureHeightOfChildren();
        /** Integer.MAX_VALUE表示int数据类型的最大取值数：2 147 483 647
            Integer.MIN_VALUE表示int数据类型的最小取值数：-2 147 483 648*/
        int expected = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expected);
    }
}
