package gsp.com.dimensionbusiness;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import gsp.com.dimensionbusiness.ui.fragment.FiveFragment;
import gsp.com.dimensionbusiness.ui.fragment.FrouFragment;
import gsp.com.dimensionbusiness.ui.fragment.OneFragment;
import gsp.com.dimensionbusiness.ui.fragment.ThreeFragment;
import gsp.com.dimensionbusiness.ui.fragment.TwoFragment;
import gsp.com.dimensionbusiness.weight.BottomBar;

public class ShowActivity extends AppCompatActivity {


    @BindView(R.id.frag)
    FrameLayout frag;
    @BindView(R.id.bar)
    BottomBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        ButterKnife.bind(this);


        ViewPager pager=findViewById(R.id.page);


        bar.setContainer(R.id.frag)
                .setTitleBeforeAndAfterColor("#999999", "#ff5d5e")
                .addItem(OneFragment.class,
                        "",
                        R.mipmap.onetwo,
                        R.mipmap.oneone)
                .addItem(TwoFragment.class,
                        "",
                        R.mipmap.twotwo,
                        R.mipmap.twoone)
                .addItem(ThreeFragment.class,
                        "",
                        R.mipmap.gouwucheone,
                        R.mipmap.gouwucheone)
                .addItem(FrouFragment.class,
                        "",
                        R.mipmap.fromtwo,
                        R.mipmap.formtwo)
                .addItem(FiveFragment.class,
                        "",
                        R.mipmap.fisttwo,
                        R.mipmap.fistone)
                .build();

    }
}
