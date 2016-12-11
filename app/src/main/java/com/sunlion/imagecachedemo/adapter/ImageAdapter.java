package com.sunlion.imagecachedemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.sunlion.imagecachedemo.R;
import com.sunlion.imagecachedemo.bean.ImageBean;
import com.sunlion.imagecachedemo.utils.ImageManager;

import java.util.List;

/**
 * 加载图片
 * Created by Administrator on 2016/12/11 0011.
 */

public class ImageAdapter extends BaseAdapter{

    private Context mContext;
    private List<ImageBean.TngouBean> mList;

    public ImageAdapter(Context mContext, List<ImageBean.TngouBean> mList) {
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
            view = View.inflate(mContext, R.layout.item_image,null);
        }

        TextView tvTitle = (TextView)view.findViewById(R.id.tv_title);
        ImageView ivImage = (ImageView)view.findViewById(R.id.iv_image);

        //设置显示的数据
        tvTitle.setText(mList.get(i).getTitle());

        String imgUrl = "http://tnfs.tngou.net/image" + mList.get(i).getImg();

        // 使用自己封装的图片缓存工具类加载图片
        ImageManager.with(mContext).load(imgUrl).placeholder(R.mipmap.ic_default).error(R.mipmap.ic_error).into(ivImage);

        return view;
    }
}
