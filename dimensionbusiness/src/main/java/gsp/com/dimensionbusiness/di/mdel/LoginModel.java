package gsp.com.dimensionbusiness.di.mdel;


import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import gsp.com.dimensionbusiness.data.Contain;
import gsp.com.dimensionbusiness.data.bean.LoginBean;
import gsp.com.dimensionbusiness.di.consentar.ILoginContract;

public class LoginModel implements ILoginContract.ILoginModel {
    @Override
    public void containData(String name, String password, final CallBack callBack) {
        String urlString = Contain.LOGIN + "?phone=" + name + "&pwd=" + password;
        OkGo.<String>post(urlString).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                String responseData = response.body().toString();
                Gson gson = new Gson();
                LoginBean loginBean = gson.fromJson(responseData, LoginBean.class);
                callBack.onCallBack(loginBean);
            }
        });
    }
}