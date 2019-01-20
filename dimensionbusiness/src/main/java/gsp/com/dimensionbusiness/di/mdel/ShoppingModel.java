package gsp.com.dimensionbusiness.di.mdel;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import gsp.com.dimensionbusiness.data.Contain;
import gsp.com.dimensionbusiness.di.consentar.ShoppingContract;

public class ShoppingModel implements ShoppingContract.ShoppingModel {
    @Override
    public void cantainData(final Callback callback) {
        //OkGo
        OkGo.<String>get(Contain.SHOPPINGCART_URL).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                String requestData = response.body().toString();
                callback.onCallback(requestData);
            }
        });
    }
}
