package com.example.guge.exp1;

import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void IMADialog(){
        final String[] name = {"拍摄","从相册选择"};
        AlertDialog.Builder dia =
                new  AlertDialog.Builder(MainActivity.this);
        dia.setTitle("上传头像");
        dia.setItems(name, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(i==0)Toast.makeText(MainActivity.this,"您选择了[拍摄]",Toast.LENGTH_SHORT).show();
                else if(i==1)Toast.makeText(MainActivity.this,"您选择了[从相册选择]",Toast.LENGTH_SHORT).show();
            }
        });


        dia.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"您选择了[取消]",Toast.LENGTH_SHORT).show();
            }
        });
        dia.show();
    }

    public void imaclick(View target){
        IMADialog();
    }

    public void radio_stu(View target){
        Snackbar.make(target,"您选择了学生",Snackbar.LENGTH_SHORT)
                .setAction("确定",new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Toast.makeText(MainActivity.this,"Snackbar 的确定按钮被点击了",Toast.LENGTH_SHORT).show();
                    }
                }).show();
    }

    public void radio_tea(View target){
        Snackbar.make(target,"您选择了教职工",Snackbar.LENGTH_SHORT)
                .setAction("确定",new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Toast.makeText(MainActivity.this,"Snackbar 的确定按钮被点击了",Toast.LENGTH_SHORT).show();
                    }
                }).show();
    }
    
    public void reg_message(View target){
        RadioButton stu = (RadioButton)findViewById(R.id.radioButton2);
        RadioButton tea = (RadioButton)findViewById(R.id.radioButton);
        if(stu.isChecked()){
            Snackbar.make(target,"学生注册功能尚未启用",Snackbar.LENGTH_SHORT)
                    .setAction("确定",new View.OnClickListener(){
                        @Override
                        public void onClick(View v){
                            Toast.makeText(MainActivity.this,"Snackbar 的确定按钮被点击了",Toast.LENGTH_SHORT).show();
                        }
                    }).show();
        }
        if(tea.isChecked()){
            Toast.makeText(MainActivity.this, "教职工注册功能尚未启用", Toast.LENGTH_SHORT).show();
        }

    }

    public void login_check(View target){
        TextInputLayout Lnumbertext = (TextInputLayout)findViewById(R.id.textInputLayout_num);
        TextInputLayout Lpasstext = (TextInputLayout)findViewById(R.id.textInputLayout_pass);
        String num = Lnumbertext.getEditText().getText().toString();
        String pas = Lpasstext.getEditText().getText().toString();
            if(num.equals("123456") & pas.equals("6666")){
                Snackbar.make(target,"登录成功",Snackbar.LENGTH_SHORT)
                        .setAction("确定",new View.OnClickListener(){
                            @Override
                            public void onClick(View v){
                                Toast.makeText(MainActivity.this,"Snackbar 的确定按钮被点击了",Toast.LENGTH_SHORT).show();
                            }
                        }).show();
                Lnumbertext.setErrorEnabled(false);
                Lpasstext.setErrorEnabled(false);
            }
            else{
                Lnumbertext.setErrorEnabled(true);
                Lpasstext.setErrorEnabled(true);
                if(num.isEmpty()){
                    Lnumbertext.setError("学号不能为空");
                    Lpasstext.setErrorEnabled(false);
                }
                else if(pas.isEmpty()){
                    Lpasstext.setError("密码不能为空");
                    Lnumbertext.setErrorEnabled(false);
                }
                else{
                    Snackbar.make(target,"学号或密码错误",Snackbar.LENGTH_SHORT)
                            .setAction("确定",new View.OnClickListener(){
                                @Override
                                public void onClick(View v){
                                    Toast.makeText(MainActivity.this,"Snackbar 的确定按钮被点击了",Toast.LENGTH_SHORT).show();
                                }
                            }).show();
                }
            }

    }
}
