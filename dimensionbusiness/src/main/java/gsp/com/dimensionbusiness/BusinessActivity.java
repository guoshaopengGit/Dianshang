package gsp.com.dimensionbusiness;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import gsp.com.dimensionbusiness.data.bean.LoginBean;
import gsp.com.dimensionbusiness.di.consentar.ILoginContract;
import gsp.com.dimensionbusiness.di.prenser.LoginPresenter;

public class BusinessActivity extends AppCompatActivity implements ILoginContract.ILoginView {


    @BindView(R.id.login_phone)
    ImageView loginPhone;
    @BindView(R.id.EditText_name)
    EditText EditTextName;
    @BindView(R.id.view1)
    View view1;
    @BindView(R.id.login_icon_lock)
    ImageView loginIconLock;
    @BindView(R.id.EditText_password)
    EditText EditTextPassword;
    @BindView(R.id.view2)
    View view2;
    @BindView(R.id.yan)
    ImageView yan;
    @BindView(R.id.button_jizhu)
    CheckBox buttonJizhu;
    @BindView(R.id.button_register)
    TextView buttonRegister;
    @BindView(R.id.login)
    Button login;
    private int eyeType = 0;
    private LoginPresenter loginPresenter;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business);
        ButterKnife.bind(this);
        //创建P层
        loginPresenter = new LoginPresenter();
        loginPresenter.attahView(this);
        //记住密码
        sp = getSharedPreferences("login", MODE_PRIVATE);
        if (sp.getBoolean("c1", false)) {
            EditTextName.setText(sp.getString("name", ""));
            EditTextPassword.setText(sp.getString("pwd", ""));
            buttonJizhu.setChecked(true);
        }

        //点击跳转页面
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BusinessActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        isPasswordShowListener();
    }

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
                EditTextPassword.setSelection(EditTextPassword.getText().length());

            }
        });
    }

    @Override
    public void showData(final LoginBean loginBean) {
        //判断是否登录成功
        //getStatus是成功的状态码0000
        if (loginBean.getStatus().equals("0000")) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    //getMessage是成功码
                    Toast.makeText(BusinessActivity.this, "" + loginBean.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
            startActivity(new Intent(BusinessActivity.this, ShowActivity.class));
        } else {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(BusinessActivity.this, "" + loginBean.getMessage(), Toast.LENGTH_SHORT).show();
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
                loginPresenter.requestData(name, password);
                //记住密码
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("name", name);
                editor.putString("pwd", password);
                editor.putBoolean("c1", buttonJizhu.isChecked());
                editor.commit();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //P
        loginPresenter.detachView(this);
    }

}

