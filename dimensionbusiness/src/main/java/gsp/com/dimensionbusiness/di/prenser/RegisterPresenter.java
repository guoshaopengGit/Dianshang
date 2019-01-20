package gsp.com.dimensionbusiness.di.prenser;


import java.lang.ref.SoftReference;

import gsp.com.dimensionbusiness.data.bean.LoginBean;
import gsp.com.dimensionbusiness.data.bean.RegisterBean;
import gsp.com.dimensionbusiness.di.consentar.ILoginContract;
import gsp.com.dimensionbusiness.di.consentar.IRegisterContract;
import gsp.com.dimensionbusiness.di.mdel.LoginModel;
import gsp.com.dimensionbusiness.di.mdel.RegisterModel;

public class RegisterPresenter implements IRegisterContract.IRegisterPresenter<IRegisterContract.IRegisterView> {
    IRegisterContract.IRegisterView registerView;
    private SoftReference<IRegisterContract.IRegisterView> softReference;
    private RegisterModel registerModel;

    @Override
    public void attahView(IRegisterContract.IRegisterView registerView) {
        this.registerView = registerView;
        softReference = new SoftReference<>(registerView);
        registerModel = new RegisterModel();
    }

    @Override
    public void detachView(IRegisterContract.IRegisterView registerView) {
        softReference.clear();
    }

    @Override
    public void requestData(String name, String password) {
        registerModel.containData(name,password,new IRegisterContract.IRegisterModel.CallBack() {
            @Override
            public void onCallBack(RegisterBean registerBean) {
                registerView.showData(registerBean);
            }
        });
    }


}
