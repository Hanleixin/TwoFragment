package com.bwei.hanleixin1502h0220.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwei.hanleixin1502h0220.R;
import com.bwei.hanleixin1502h0220.bean.Bean;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Author ${韩磊鑫} on 2017/2/20 19:09
 * 邮箱：leixinhan@foxmail.com
 * 项目名称：
 * 类描述：
 * 修改人：${Oliver}
 * 修改备注：
 * 修改时间：
 */

public class NewsAdapter extends BaseAdapter {

    private Context context;
    private List<Bean.ResultBean.DataBean> list;

    public NewsAdapter(Context context,List<Bean.ResultBean.DataBean> list){
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup parent) {

        ViewHolder v = null;

        if(convertview == null){
            convertview = View.inflate(context, R.layout.item_listview,null);

            v = new ViewHolder();

            v.im = (ImageView) convertview.findViewById(R.id.web_imageview);
            v.tv = (TextView) convertview.findViewById(R.id.web_textview1);
            v.tv2 = (TextView) convertview.findViewById(R.id.web_textview2);
        }else{
            v= (ViewHolder) convertview.getTag();
        }

        Bean.ResultBean.DataBean listbean = list.get(position);
        ImageLoader imageLoader=ImageLoader.getInstance();
        imageLoader.displayImage(listbean.getThumbnail_pic_s(),v.im);
        v.tv.setText(listbean.getTitle());
        v.tv2.setText(listbean.getAuthor_name());

        return convertview;
    }

    static class ViewHolder{
        TextView tv;
        TextView tv2;
        ImageView im;
    }
}
