package gsp.com.dimensionbusiness.ui.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.CheckBox;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import gsp.com.dimensionbusiness.R;
import gsp.com.dimensionbusiness.data.bean.Shoppingbean;

public class BusinessAdapter extends BaseQuickAdapter<Shoppingbean.DataBean, BaseViewHolder> {
    public BusinessAdapter(int layoutResId, @Nullable List<Shoppingbean.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Shoppingbean.DataBean item) {
        helper.setText(R.id.tv_business_name,item.getSellerName());

        RecyclerView rv_goods = helper.getView(R.id.rv_goods);
        CheckBox cb_business = helper.getView(R.id.cb_business);
        cb_business.setOnCheckedChangeListener(null);

        List<Shoppingbean.DataBean.ListBean> goodslist = item.getList();
        LinearLayoutManager manager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        rv_goods.setLayoutManager(manager);
        GoodsAdapter goodsAdapter = new GoodsAdapter(R.layout.activity_shopping,goodslist);
        rv_goods.setAdapter(goodsAdapter);

    }
}
