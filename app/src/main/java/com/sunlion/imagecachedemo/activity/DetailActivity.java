package com.sunlion.imagecachedemo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.sunlion.imagecachedemo.R;
import com.sunlion.imagecachedemo.bean.ImageBean;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView image = (ImageView)findViewById(R.id.image);

        Intent intent = getIntent();
        ImageBean.TngouBean bean = (ImageBean.TngouBean)intent.getSerializableExtra("bean");

        String img = "http://tnfs.tngou.net/image" + bean.getImg();

        //使用Picasso框架显示图片
        Picasso.with(this).load(img).into(image);
    }
}
