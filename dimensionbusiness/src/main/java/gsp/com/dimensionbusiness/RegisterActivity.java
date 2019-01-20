package gsp.com.dimensionbusiness;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import gsp.com.dimensionbusiness.data.bean.RegisterBean;
import gsp.com.dimensionbusiness.di.consentar.IRegisterContract;
import gsp.com.dimensionbusiness.di.prenser.RegisterPresenter;

public class RegisterActivity extends AppCompatActivity implements IRegisterContract.IRegisterView {

    @BindView(R.id.sign_phone)
    ImageView signPhone;
    @BindView(R.id.EditText_name)
    EditText EditTextName;
    @BindView(R.id.view1)
    View view1;
    @BindView(R.id.lipai)
    ImageView lipai;
    @BindView(R.id.EditText_Verification)
    EditText EditTextVerification;
    @BindView(R.id.sign_get_code)
    TextView signGetCode;
    @BindView(R.id.view2)
    View view2;
    @BindView(R.id.sign_lock)
    ImageView signLock;
    @BindView(R.id.EditText_password)
    EditText EditTextPassword;
    @BindView(R.id.yan)
    ImageView yan;
    @BindView(R.id.view3)
    View view3;
    @BindView(R.id.keep)
    TextView keep;
    @BindView(R.id.login)
    Button login;
    private int eyeType = 0;
    private RegisterPresenter registerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        isPasswordShowListener();


        //创建P层
        registerPresenter = new RegisterPresenter();
        registerPresenter.attahView(this);


        //
        keep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, BusinessActivity.class);
                startActivity(intent);
            }
        });


    }

    //这块是显示和隐藏密码的
    private void isPasswordShowListener() {
        yan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (eyeType == 0) {
                    //点击隐藏密码
                    EditTextPassword.setInputType(false ?
                            (InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD) :
                            (InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD));
                    eyeType = 1;
                } else {
                    //或者显示密码
                    EditTextPassword.setInputType(true ?
                            (InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD) :
                            (InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD));
                    eyeType = 0;
                }
                //以上，还有一个问题，切换显隐后，光标会跳到最前面，为了解决这个问题，需要加上以下代码
                EditTextPassword.setSelection(EditTextPassword.getText().length());
            }
        });


    }

    @Override
    public void showData(final RegisterBean registerBean) {
        //判断是否注册成功
        //getStatus是成功的状态码0000
        if (registerBean.getStatus().equals("0000")) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(RegisterActivity.this, "" + registerBean.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
            startActivity(new Intent(RegisterActivity.this, BusinessActivity.class));
        } else {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(RegisterActivity.this, "" + registerBean.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }

    }

    @OnClick({R.id.login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login:
                String name = EditTextName.getText().toString();
                String password = EditTextPassword.getText().toString();
                registerPresenter.requestData(name, password);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //P
        registerPresenter.detachView(this);
    }

}
