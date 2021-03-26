package com.xuly.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.xuly.project.bean.LoginToken;
import com.xuly.project.utils.HttpUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.TreeMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText username;
    private EditText password;
    private TextView btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username= findViewById(R.id.username);
        username.setText("xuly");
        password= findViewById(R.id.password);
        password.setText("123456");
        btn_login= findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);
    }

    private int ret = 0;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            int what = msg.what;
            String response = String.valueOf(msg.obj);
            if (what == 0) {
                JSONObject json = null;
                String str_msg = "";
                try {
                    json = new JSONObject(response);
                    ret = json.getInt("errorCode");
                    if (ret == 0) {
                        Gson gson = new Gson();
                        LoginToken token = new LoginToken();
                        token = gson.fromJson(response, LoginToken.class);
                        String mtoken = token.getData().getToken();
                        int userId = token.getData().getId();

                        SharedPreferences userinfo = getApplicationContext().getSharedPreferences(
                                "userinfo_sharefile", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = userinfo.edit();

                        editor.putString("tokenkey", mtoken);
                        editor.putInt("userid", userId);
                        editor.commit();

                        Toast.makeText(getApplicationContext(), "登录成功", Toast.LENGTH_SHORT).show();


                    }  else {
                        Toast.makeText(getApplicationContext(), "服务器程序错误", Toast.LENGTH_SHORT).show();
                        btn_login.setEnabled(true);
                    }

                } catch (JSONException ex) {
                    ex.printStackTrace();
                }
//                Intent add_intent = new Intent(getApplicationContext(),MainActivity.class);
//                add_intent.putExtra("fragmenttype","mine");
//                startActivity(add_intent);


            }
        }

    };

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_login){
            if (username.getText().toString().equals("")) {
                Toast.makeText(getApplicationContext(), "用户名不能为空", Toast.LENGTH_SHORT).show();
                return;
            } else if (password.getText().toString().equals("")) {
                Toast.makeText(getApplicationContext(), "密码不能为空", Toast.LENGTH_SHORT).show();
                return;
            }
            else{
                new Thread() {
                    @Override
                    public void run() {

                        TreeMap<String, String> treeMap = new TreeMap<>();
                        treeMap.put("username", username.getText().toString().trim());
                        treeMap.put("password", password.getText().toString().trim());

                        //这里写入子线程需要做的工作
                        String response = HttpUtils.get_post_response(treeMap, HttpUtils.Login_wanandroid_URL);

                        Message message = Message.obtain();
                        message.obj = response;
                        message.what = 0;

                        mHandler.sendMessage(message);

                    }
                }.start();
            }
        }
    }
}