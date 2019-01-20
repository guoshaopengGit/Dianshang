package gsp.com.dimensionbusiness.di.prenser;

import java.lang.ref.SoftReference;

import gsp.com.dimensionbusiness.data.bean.Molibean;
import gsp.com.dimensionbusiness.data.bean.Pinzhibean;
import gsp.com.dimensionbusiness.data.bean.Rexiaobean;
import gsp.com.dimensionbusiness.di.consentar.OneContract;
import gsp.com.dimensionbusiness.di.mdel.OneModel;

public class OnePresenter implements OneContract.Onepresenter<OneContract.Oneview> {
    OneContract.Oneview oneview;
    private SoftReference<OneContract.Oneview> softReference;
    private OneModel oneModel;

    @Override
    public void attachview(OneContract.Oneview oneview) {
        this.oneview=oneview;
        //创建软引用
        softReference = new SoftReference<>(oneview);
        //创建M层
        oneModel = new OneModel();
    }

    @Override
    public void detachview(OneContract.Oneview oneview) {
        softReference.clear();
    }

    @Override
    public void resquesData() {
        oneModel.cantainData(new OneContract.Onemodel.Callback() {
            @Override
            public void onCallback(Rexiaobean resqonsData) {
                oneview.shapeData(resqonsData);
            }

            @Override
            public void onCallback(Molibean resqonsData) {
                oneview.shapeData(resqonsData);
            }

            @Override
            public void onCallback(Pinzhibean resqonsData) {
                oneview.shapeData(resqonsData);
            }
        });
    }
}
