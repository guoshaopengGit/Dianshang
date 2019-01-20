package gsp.com.dimensionbusiness.di.consentar;

import gsp.com.dimensionbusiness.data.bean.LoginBean;
import gsp.com.dimensionbusiness.data.bean.Molibean;
import gsp.com.dimensionbusiness.data.bean.Pinzhibean;
import gsp.com.dimensionbusiness.data.bean.Rexiaobean;

public interface OneContract {
    //V层
    public interface Oneview {
        //回显数据热销
        public void shapeData(Rexiaobean resqonsData);

        //回显数据魔力
        public void shapeData(Molibean resqonsData);

        //回显数据品质
        public void shapeData(Pinzhibean resqonsData);
    }

    //P层
    public interface Onepresenter<Oneinview> {
        //绑定服务
        public void attachview(OneContract.Oneview oneview);

        //解绑服务
        public void detachview(OneContract.Oneview oneview);

        //获取数据
        public void resquesData();
    }

    //M层
    public interface Onemodel {
        //请求数据
        public void cantainData(Callback callback);

        //接口回调
        public interface Callback {
            //
            void onCallback(Rexiaobean resqonsData);

            //
            void onCallback(Molibean resqonsData);

            //
            void onCallback(Pinzhibean resqonsData);
        }

    }
}
