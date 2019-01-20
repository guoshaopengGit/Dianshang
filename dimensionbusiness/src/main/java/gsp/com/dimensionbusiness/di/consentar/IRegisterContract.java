package gsp.com.dimensionbusiness.di.consentar;

import gsp.com.dimensionbusiness.data.bean.RegisterBean;

public interface IRegisterContract {

    public interface IRegisterView {
        //回显数据
        public void showData(RegisterBean registerBean);
    }

    //P层
    public interface IRegisterPresenter<IRegisterView> {
        //绑定
        public void attahView(IRegisterContract.IRegisterView registerView);

        //解绑
        public void detachView(IRegisterContract.IRegisterView registerView);

        //数据获取
        public void requestData(String name, String password);
    }

    //M层
    public interface IRegisterModel {
        //请求数据
        public void containData(String name, String password, CallBack callBack);

        //接口回调
        public interface CallBack {
            public void onCallBack(RegisterBean registerBean);
        }
    }
}

