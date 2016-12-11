package com.sunlion.imagecachedemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sunlion.imagecachedemo.bean.CategoryBean;

import java.util.List;

/**
 * 加载文字
 * Created by Administrator on 2016/12/11 0011.
 */

public class CategoryAdapter extends BaseAdapter{

    private Context mContext;
    private List<CategoryBean.TngouBean> mList;

    public CategoryAdapter(Context mContext, List<CategoryBean.TngouBean> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = View.inflate(mContext, android.R.layout.simple_expandable_list_item_1, null);
        }
        TextView tv = (TextView) view;
        tv.setPadding(20,20,20,20);

        //设置显示的数据
        tv.setText(mList.get(i).getTitle());
        return view;
    }
}
