package gsp.com.dimensionbusiness.di.consentar;

import gsp.com.dimensionbusiness.data.bean.LoginBean;

public interface ILoginContract {

    public interface ILoginView {
        //回显数据
        public void showData(LoginBean loginBean);
    }

    //P层
    public interface ILoginPresenter<ILoginView> {
        //绑定
        public void attahView(ILoginContract.ILoginView loginView);

        //解绑
        public void detachView(ILoginContract.ILoginView loginView);

        //数据获取
        public void requestData(String name, String password);
    }

    //M层
    public interface ILoginModel {
        //请求数据
        public void containData(String name, String password, CallBack callBack);

        //接口回调
        public interface CallBack {
            public void onCallBack(LoginBean repsoneData);
        }
    }
}

