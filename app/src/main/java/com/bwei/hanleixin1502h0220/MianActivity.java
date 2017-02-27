package com.bwei.hanleixin1502h0220;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.bwei.hanleixin1502h0220.fragment.FragmentMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * Author ${韩磊鑫} on 2017/2/20 13:43
 * 邮箱：leixinhan@foxmail.com
 * 项目名称：
 * 类描述：
 * 修改人：${Oliver}
 * 修改备注：
 * 修改时间：
 */

public class MianActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //查找相关控件
        final ListView listView = (ListView) findViewById(R.id.other_listview);
        final List<String> list = new ArrayList<>();

        //添加数据
        list.add("第一页");
        list.add("第二页");
        list.add("第三页");
        list.add("第四页");
        list.add("第五页");

        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list));

        //添加listview(item)的点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public static final String TAG = "MainActivity";

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int poition, long id) {

                FragmentMenu fragmentMenu = new FragmentMenu();
                Bundle bundle = new Bundle();
                bundle.putInt("num",poition);
                fragmentMenu.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment,fragmentMenu).commit();
            }
        });
    }
}
