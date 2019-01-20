package gsp.com.dimensionbusiness.ui.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import gsp.com.dimensionbusiness.R;
import gsp.com.dimensionbusiness.data.bean.Molibean;
import gsp.com.dimensionbusiness.data.bean.Pinzhibean;
import gsp.com.dimensionbusiness.data.bean.Rexiaobean;
import gsp.com.dimensionbusiness.di.consentar.OneContract;
import gsp.com.dimensionbusiness.di.prenser.OnePresenter;
import gsp.com.dimensionbusiness.ui.adapter.MOliadapter;
import gsp.com.dimensionbusiness.ui.adapter.Pinzhiadapter;
import gsp.com.dimensionbusiness.ui.adapter.Rexiaoadapter;

public class OneFragment extends Fragment implements OneContract.Oneview {

    @BindView(R.id.rexiaoxinpin)
    RecyclerView rexiaoxinpin;
    @BindView(R.id.molishishang)
    RecyclerView molishishang;
    @BindView(R.id.pinzhishenghuo)
    RecyclerView pinzhishenghuo;
    Unbinder unbinder;
    private MZBannerView mMZBanner;
    private OnePresenter onePresenter;
    private Rexiaoadapter rexiaoadapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_one, null);

        //banner轮播图的组件
        mMZBanner = (MZBannerView) view.findViewById(R.id.banner);
        // 设置页面点击事件
        mMZBanner.setBannerPageClickListener(new MZBannerView.BannerPageClickListener() {
            @Override
            public void onPageClick(View view, int position) {
                Toast.makeText(getContext(), "click page:" + position, Toast.LENGTH_LONG).show();
            }
        });

        //创建list的类把图片放到list类中
        List<String> list = new ArrayList<>();
        list.add("http://mobile.bwstudent.com/images/small/banner/cj.png");
        list.add("http://mobile.bwstudent.com/images/small/banner/hzp.png");
        list.add("http://mobile.bwstudent.com/images/small/banner/lyq.png");
        list.add("http://mobile.bwstudent.com/images/small/banner/px.png");
        list.add("mobile.bwstudent.com/images/small/banner/wy.png");

        // 设置数据
        mMZBanner.setPages(list, new MZHolderCreator<BannerViewHolder>() {
            @Override
            public BannerViewHolder createViewHolder() {
                return new BannerViewHolder();
            }
        });
        unbinder = ButterKnife.bind(this, view);




        //现在开始设置购物车的数据

        //创建P层
        onePresenter = new OnePresenter();
        onePresenter.attachview(this);

        //热销
        onePresenter.resquesData();
        //魔力
        onePresenter.resquesData();
        //品质
        onePresenter.resquesData();
        return view;


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void shapeData(Rexiaobean resqonsData) {

        List<Rexiaobean.ResultBean.RxxpBean.CommodityListBean> rxxp = resqonsData.getResult().getRxxp().get(0).getCommodityList();

        //波浪型的布局需要设置RecyclerView   其他类型的不需要设置了
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        rexiaoxinpin.setLayoutManager(manager);


        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        //横向展示
        layoutManager.setOrientation(OrientationHelper.HORIZONTAL);


        //设置适配器
        rexiaoadapter = new Rexiaoadapter(R.layout.rexiao, rxxp);
        rexiaoxinpin.setAdapter(rexiaoadapter);

    }

    @Override
    public void shapeData(Molibean resqonsData) {
        List<Molibean.ResultBean.MlssBean.CommodityListBeanXX> moll = resqonsData.getResult().getMlss().get(0).getCommodityList();

        //波浪型的布局需要设置RecyclerView   其他类型的不需要设置了
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        molishishang.setLayoutManager(manager);


        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        //横向展示
        layoutManager.setOrientation(OrientationHelper.HORIZONTAL);


        //设置适配器
        MOliadapter mOliadapter = new MOliadapter(R.layout.moli,moll);
        molishishang.setAdapter(mOliadapter);

    }

    @Override
    public void shapeData(Pinzhibean resqonsData) {
        List<Pinzhibean.ResultBean.PzshBean.CommodityListBeanX> pz = resqonsData.getResult().getPzsh().get(0).getCommodityList();

        //波浪型的布局需要设置RecyclerView   其他类型的不需要设置了
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        pinzhishenghuo.setLayoutManager(manager);


        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        //横向展示
        layoutManager.setOrientation(OrientationHelper.HORIZONTAL);


        //设置适配器
        Pinzhiadapter pinzhiadapter = new Pinzhiadapter(R.layout.pinzhi, pz);
        pinzhishenghuo.setAdapter(pinzhiadapter);
    }


    //banner轮播图
    public static class BannerViewHolder implements MZViewHolder<String> {
        private ImageView mImageView;

        @Override
        public View createView(Context context) {
            // 返回页面布局
            View view = LayoutInflater.from(context).inflate(R.layout.banner_item, null);
            mImageView = (ImageView) view.findViewById(R.id.banner_image);
            return view;
        }

        @Override
        public void onBind(Context context, int position, String data) {
            // 数据绑定
            Glide.with(context).load(data).into(mImageView);
        }
    }
}
