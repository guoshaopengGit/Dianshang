package gsp.com.dimensionbusiness.di.mdel;


import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import gsp.com.dimensionbusiness.data.Contain;
import gsp.com.dimensionbusiness.data.bean.RegisterBean;
import gsp.com.dimensionbusiness.di.consentar.IRegisterContract;

public class RegisterModel implements IRegisterContract.IRegisterModel {
    @Override
    public void containData(String name, String password, final CallBack callBack) {
        String urlString = Contain.REGISTER+ "?phone=" + name + "&pwd=" + password;
        OkGo.<String>post(urlString).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                String responseData = response.body().toString();
                Gson gson = new Gson();
                RegisterBean registerBean = gson.fromJson(responseData, RegisterBean.class);
                callBack.onCallBack(registerBean);
            }
        });
    }
}