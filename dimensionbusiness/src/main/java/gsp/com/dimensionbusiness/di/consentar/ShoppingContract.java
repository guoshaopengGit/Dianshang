package gsp.com.dimensionbusiness.di.consentar;

public interface ShoppingContract {
    //V层
    public interface ShoppingView {
        //显示加载进度
        public void showLoading();

        //取消加载进度
        public void hideLoading();

        public void showData(String responseData);
    }

    //P层
    public interface ShoppingPrenser<ShoppingView> {
        //绑定
        public void attachData(ShoppingContract.ShoppingView shoppingView);

        //解绑
        public void dataData(ShoppingContract.ShoppingView shoppingView);

        //和M层进行交互
        public void resquesData();
    }
    //M层
    public interface ShoppingModel{
        //请求数据
        public void cantainData(Callback callback);

        //接口回调
        public interface Callback{

            //回显数据
            public void onCallback(String responseData);

        }
    }
}
