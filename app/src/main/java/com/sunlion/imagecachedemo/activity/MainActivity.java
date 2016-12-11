package com.sunlion.imagecachedemo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.sunlion.imagecachedemo.R;
import com.sunlion.imagecachedemo.adapter.CategoryAdapter;
import com.sunlion.imagecachedemo.bean.CategoryBean;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private CategoryBean mBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listview);

        // 联网获取数据
        // 请求队列
        RequestQueue queue = Volley.newRequestQueue(this);

        String url = "http://apis.baidu.com/tngou/gallery/classify";
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // 使用gson框架解析
                Gson gson = new Gson();
                // 将字符串封装到bean中
                mBean = gson.fromJson(response,CategoryBean.class);

                // 设置适配器
                listView.setAdapter(new CategoryAdapter(MainActivity.this,mBean.getTngou()));

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // 请求发生错误时调用
                error.printStackTrace();
            }
        }){
            // 重写请求头方法
            @Override
            public Map<String,String> getHeaders() throws AuthFailureError{
                // 将请求参数返回
                Map<String,String> map = new HashMap<>();
                map.put("apikey", "75e0aecf9a0d887adf328cb770f3a8ea");
                return map;
            }
        };
        // 添加队列
        queue.add(request);

        // 设置点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // 获取bean对象
                CategoryBean.TngouBean tngouBean = mBean.getTngou().get(i);

                Intent intent = new Intent(MainActivity.this,ImageActivity.class);
                // 携带当前分类的id过去
                intent.putExtra("cid", tngouBean.getId());
                startActivity(intent);
            }
        });

    }
}
