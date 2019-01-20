package gsp.com.dimensionbusiness.di.prenser;


import java.lang.ref.SoftReference;

import gsp.com.dimensionbusiness.data.bean.LoginBean;
import gsp.com.dimensionbusiness.di.consentar.ILoginContract;
import gsp.com.dimensionbusiness.di.mdel.LoginModel;

public class LoginPresenter implements ILoginContract.ILoginPresenter<ILoginContract.ILoginView> {
    ILoginContract.ILoginView loginView;
    private SoftReference<ILoginContract.ILoginView> reference;
    private LoginModel model;

    @Override
    public void attahView(ILoginContract.ILoginView loginView) {
        this.loginView = loginView;
        reference = new SoftReference<>(loginView);
        model = new LoginModel();
    }

    @Override
    public void detachView(ILoginContract.ILoginView loginView) {
        reference.clear();
    }

    @Override
    public void requestData(String name, String password) {
        model.containData(name,password,new ILoginContract.ILoginModel.CallBack() {
            @Override
            public void onCallBack(LoginBean repsoneData) {
                loginView.showData(repsoneData);
            }
        });
    }
}
