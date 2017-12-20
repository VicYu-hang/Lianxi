package com.bwie.yuekao.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bwie.yuekao.R;
import com.bwie.yuekao.bean.ShouYeBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerClickListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VICYU on 2017/12/20.
 */

public class ShowYeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ShouYeBean shouYeBean;

    public ShowYeAdapter(Context context, ShouYeBean shouYeBean) {
        this.context = context;
        this.shouYeBean = shouYeBean;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == 0) {
            View view = View.inflate(context, R.layout.shouye_item, null);
            return new ViewHolder(view);
        } else {
            View view = View.inflate(context, R.layout.shouye_item2, null);
            return new ViewHolder1(view);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


        if (position==0) {
                ViewHolder viewHolder = (ViewHolder) holder;
                List<String> bannerList = new ArrayList<>();
                List<ShouYeBean.RetBean.ListBean> listBeen = shouYeBean.getRet().getList();
            for (int i = 0; i < shouYeBean.getRet().getList().size(); i++) {
                try {
                    bannerList.add(listBeen.get(i).getChildList().get(position).getPic());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            viewHolder.mBanner.setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    Glide.with(context).load(path).into(imageView);
                }
            });
            viewHolder.mBanner.setImages(bannerList);
            viewHolder.mBanner.start();
            viewHolder.mBanner.setOnBannerClickListener(new OnBannerClickListener() {
                @Override
                public void OnBannerClick(int position) {
                    Toast.makeText(context, "这里可以跳转", Toast.LENGTH_SHORT).show();
                }
            });
          }else {
            ViewHolder1 viewHolder1=(ViewHolder1)holder;

            List<ShouYeBean.RetBean.ListBean> listBeen = shouYeBean.getRet().getList();
            Uri uri = Uri.parse(listBeen.get(5).getChildList().get(position).getPic());
            viewHolder1.mMyImageView.setImageURI(uri);
            viewHolder1.mText.setText(shouYeBean.getRet().getList().get(5).getChildList().get(position).getTitle());
        }
    }


    @Override
    public int getItemViewType(int position) {

        if (position == 0) {
            return 0;
        } else  {
            return 1;
        }

    }

    @Override
    public int getItemCount() {
        return shouYeBean.getRet().getList().get(0).getChildList().size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        Banner mBanner;

        ViewHolder(View view) {
            super(view);
            mBanner = (Banner) view.findViewById(R.id.banner);
        }
    }

    static class ViewHolder1 extends RecyclerView.ViewHolder {
        SimpleDraweeView mMyImageView;
        TextView mText;

        ViewHolder1(View v) {
            super(v);
            this.mMyImageView = (SimpleDraweeView) v.findViewById(R.id.my_image_view);
            this.mText = (TextView) v.findViewById(R.id.text);
        }
    }
}
