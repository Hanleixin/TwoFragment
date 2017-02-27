package com.bwei.hanleixin1502h0220.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.bwei.hanleixin1502h0220.R;
import com.bwei.hanleixin1502h0220.WebViewActivity;
import com.bwei.hanleixin1502h0220.adapter.NewsAdapter;
import com.bwei.hanleixin1502h0220.bean.Bean;
import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

import java.util.List;

/**
 * Author ${韩磊鑫} on 2017/2/20 14:23
 * 邮箱：leixinhan@foxmail.com
 * 项目名称：
 * 类描述：
 * 修改人：${Oliver}
 * 修改备注：
 * 修改时间：
 */

public class FragmentMenu extends Fragment {

    private ListView lv;
    private List<Bean.ResultBean.DataBean> list;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_menu,null);

        //查找相关控件
        lv = (ListView) view.findViewById(R.id.menu_listview);

        //监听事件
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {

                Intent intent = new Intent(getActivity(),WebViewActivity.class);
                intent.putExtra("url",list.get(position).getUrl());
                startActivity(intent);
            }
        });

        return  view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        int num = bundle.getInt("num");
        switch(num){

            case 0:
                getData("top");
                break;
            case 1:
                getData("yule");
                break;
            case 2:
                getData("shehui");
                break;
            case 3:
                getData("guoji");
                break;
            case 4:
                getData("tiyu");
                break;
        }
    }

    private Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bean bean = (Bean) msg.obj;
            list = bean.getResult().getData();
            lv.setAdapter(new NewsAdapter(getActivity(),list));
        }
    };

    private void getData(final String url) {

        String path = "http://v.juhe.cn/toutiao/index?type="+url+"&key=3e6eb5d1e02ce13a6cbfc44eb41758bb";
//            http://v.juhe.cn/toutiao/index?type=top&key=0863c5f38bfa7a84bcceb6b629f91a35
        HttpUtils h = new HttpUtils();

        h.send(HttpMethod.GET, path, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String string = responseInfo.result;
                Gson g = new Gson();
                Bean bean = g.fromJson(string, Bean.class);

                Message m = new Message();
                m.obj = bean;
                handler.sendMessage(m);
            }

            @Override
            public void onFailure(HttpException e, String s) {

            }
        });

    }


}
