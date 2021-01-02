package com.example.myapplication.fragment;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.example.mvplibrary.base.BaseFragment;
import com.example.mvplibrary.base.BasePresenter;
import com.example.myapplication.R;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

import butterknife.BindView;

public class HomeFragment extends BaseFragment {

    @BindView(R.id.home_toolbar)
    Toolbar homeToolbar;
    @BindView(R.id.banner)
    Banner banner;
    private ArrayList<Integer> imgs;

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void init() {
        homeToolbar.setNavigationIcon(R.drawable.services);
        homeToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "services", Toast.LENGTH_SHORT).show();
            }
        });
        initMenu();
        initBanner();
    }

    private void initBanner() {
        imgs = new ArrayList<>();
        imgs.add(R.mipmap.qq);
        imgs.add(R.mipmap.rr);
        imgs.add(R.mipmap.timg);
        imgs.add(R.mipmap.tt);
        imgs.add(R.mipmap.ww);
        imgs.add(R.mipmap.yy);
        banner.setImages(imgs).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Integer img = (Integer) path;
                Glide.with(getContext()).load(img).into(imageView);
            }
        }).start();
    }

    private void initMenu() {
        homeToolbar.inflateMenu(R.menu.fragment_home_menu);
        homeToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.item1){
                    Toast.makeText(getContext(), "搜索", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getContext(), "邮箱", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }
}
