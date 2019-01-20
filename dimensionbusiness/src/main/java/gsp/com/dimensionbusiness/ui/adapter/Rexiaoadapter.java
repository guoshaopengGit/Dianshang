package gsp.com.dimensionbusiness.ui.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import gsp.com.dimensionbusiness.R;
import gsp.com.dimensionbusiness.data.bean.Rexiaobean;

public class Rexiaoadapter extends BaseQuickAdapter<Rexiaobean.ResultBean.RxxpBean.CommodityListBean,BaseViewHolder> {
    public Rexiaoadapter(int layoutResId, @Nullable List<Rexiaobean.ResultBean.RxxpBean.CommodityListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Rexiaobean.ResultBean.RxxpBean.CommodityListBean item) {
        //获取文字
        helper.setText(R.id.title,item.getCommodityName());
        //获取价格
        helper.setText(R.id.price,item.getPrice()+"￥");
        //获取图片   记得强转一下helper.getView(R.id.image)
        Glide.with(mContext).load(item.getMasterPic()).into((ImageView) helper.getView(R.id.image));
    }
}
