package gsp.com.dimensionbusiness.di.mdel;

import android.util.Log;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import gsp.com.dimensionbusiness.data.Contain;
import gsp.com.dimensionbusiness.data.bean.Molibean;
import gsp.com.dimensionbusiness.data.bean.Pinzhibean;
import gsp.com.dimensionbusiness.data.bean.Rexiaobean;
import gsp.com.dimensionbusiness.di.consentar.OneContract;

public class OneModel implements OneContract.Onemodel {
    @Override
    public void cantainData(final Callback callback) {
        OkGo.<String>get(Contain.SHOUYE).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                //响应数据
                String responsedata = response.body().toString();
                //解析数据
                Gson gson = new Gson();
                //获取bean
                Pinzhibean pinzhibean = gson.fromJson(responsedata, Pinzhibean.class);
                //响应玩数据回传
                callback.onCallback(pinzhibean);
            }
        });

        OkGo.<String>get(Contain.SHOUYE).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                //响应数据
                String responsedata = response.body().toString();
                //解析数据
                Gson gson = new Gson();
                //获取bean
                Molibean molibean = gson.fromJson(responsedata, Molibean.class);
                //响应玩数据回传
                callback.onCallback(molibean);
            }
        });

        OkGo.<String>get(Contain.SHOUYE).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                //响应数据
                String responsedata = response.body().toString();
                //解析数据
                Gson gson = new Gson();
                //获取bean
                Rexiaobean rexiaobean = gson.fromJson(responsedata, Rexiaobean.class);
//                Log.e("OneModel", rexiaobean.toString());
                //响应玩数据回传
                callback.onCallback(rexiaobean);
            }
        });
    }
}
