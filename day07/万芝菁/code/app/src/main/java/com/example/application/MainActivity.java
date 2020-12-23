package com.example.application;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText name;
    private EditText yan;
    private TextView dao;
    private EditText psw;
    private Button button;
    private Disposable subscribe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        name = (EditText) findViewById(R.id.name);
        yan = (EditText) findViewById(R.id.yan);
        dao = (TextView) findViewById(R.id.dao);
        psw = (EditText) findViewById(R.id.psw);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(this);
        dao.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View view) {
                subscribe = Observable.intervalRange(0, 6, 0, 1, TimeUnit.SECONDS)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<Long>() {
                            @Override
                            public void accept(Long aLong) throws Exception {
                                long time = 5 - aLong;

                                dao.setText(time + "s");
                                if (time == 0) {
                                    dao.setText("重新发送");
                                    String base = "0123456789";
                                    Random random = new Random();
                                    StringBuffer sb = new StringBuffer();
                                    for (int i = 0; i < 4; i++) {
                                        int number = random.nextInt(base.length());
                                        sb.append(base.charAt(number));
                                    }
                                    yan.setText(sb.toString());
                                }
                            }
                        });
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                Intent intent = new Intent(this, HomeActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void submit() {
        // validate
        String nameString = name.getText().toString().trim();
        if (TextUtils.isEmpty(nameString)) {
            Toast.makeText(this, "nameString不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String yanString = yan.getText().toString().trim();
        if (TextUtils.isEmpty(yanString)) {
            Toast.makeText(this, "yanString不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String pswString = psw.getText().toString().trim();
        if (TextUtils.isEmpty(pswString)) {
            Toast.makeText(this, "pswString不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }
}
