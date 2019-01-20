package gsp.com.dimensionbusiness.ui.adapter;

import android.support.annotation.Nullable;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import gsp.com.dimensionbusiness.R;
import gsp.com.dimensionbusiness.data.bean.Shoppingbean;

public class GoodsAdapter extends BaseQuickAdapter<Shoppingbean.DataBean.ListBean, BaseViewHolder> {

    public GoodsAdapter(int layoutResId, @Nullable List<Shoppingbean.DataBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Shoppingbean.DataBean.ListBean item) {
        helper.setText(R.id.tv_goodsPrice,"￥:"+item.getPrice());
        helper.setText(R.id.tv_goodsTitle,item.getTitle());
        ImageView iv_goodsIcon = helper.getView(R.id.iv_goodsIcon);
        String[] imageStr = item.getImages().split("\\|");
        Glide.with(mContext).load(imageStr[0]).into(iv_goodsIcon);
        CheckBox cb_goods = helper.getView(R.id.cb_goods);
        cb_goods.setOnCheckedChangeListener(null);
    }
}
