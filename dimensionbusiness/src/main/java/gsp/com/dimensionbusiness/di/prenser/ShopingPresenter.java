package gsp.com.dimensionbusiness.di.prenser;

import java.lang.ref.SoftReference;

import gsp.com.dimensionbusiness.di.consentar.ShoppingContract;
import gsp.com.dimensionbusiness.di.mdel.ShoppingModel;

public class ShopingPresenter implements ShoppingContract.ShoppingPrenser<ShoppingContract.ShoppingView> {
    ShoppingContract.ShoppingView shoppingView;
    private SoftReference<ShoppingContract.ShoppingView> softReference;
    private ShoppingModel shoppingModel;

    @Override
    public void attachData(ShoppingContract.ShoppingView shoppingView) {
        this.shoppingView=shoppingView;
        //创建软引用
        softReference = new SoftReference<>(shoppingView);
        //获取M层
        shoppingModel = new ShoppingModel();
    }

    @Override
    public void dataData(ShoppingContract.ShoppingView shoppingView) {
        softReference.clear();
    }

    @Override
    public void resquesData() {
       shoppingModel.cantainData(new ShoppingContract.ShoppingModel.Callback() {
           @Override
           public void onCallback(String responseData) {
               shoppingView.showData(responseData);
           }
       });
    }
}
