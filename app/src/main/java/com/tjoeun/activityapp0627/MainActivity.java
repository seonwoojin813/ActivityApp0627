package com.tjoeun.activityapp0627;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //startActivityForResult 메소드로 하위 액티비티를 출력한 경우
    //하위 액티비티가 소멸될 때 호출되는 메소드
    @Override
    public void onActivityResult(
            int requestCode, int resultCode, Intent intent){
        String data = intent.getStringExtra("data");
        Toast.makeText(MainActivity.this, data, Toast.LENGTH_LONG ).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(MainActivity.this, "Create MainActivity",
                Toast.LENGTH_LONG).show();


        Button subbtn = (Button)findViewById(R.id.subbtn);
        subbtn.setOnClickListener((view)->{
            //SubActivity를 호출할 수 있는 Intent 만들기
            //부모가 될 Activity의 참조
            //출력될 Activity의 클래스 이름을 가지고 생성
            Intent intent = new Intent(
                    MainActivity.this, SubActivity.class);
            //하위 Activity에게 전달할 데이터 만들기
            EditText edit = (EditText)findViewById(R.id.message);
            String data = edit.getText().toString();
            intent.putExtra("message", data);

            //새로운 인테트를 출력
            //startActivity(intent);

            //데이터를 넘겨받을 수 있도록 인텐트를 출력
            //두번째로 넘겨주는 정수는 하위 Activity들을 구분하기 위한 코드
            startActivityForResult(intent, 1);
        });
    }

    //Activity가 사라졌다가 다시 출력되는 경우 호출되는 메소드
    //Activity가 화면에 보여지면 무조건 호출되는 메소드
    @Override
    public void onResume(){
        super.onResume();
        Toast.makeText(
                MainActivity.this,
                "MainActivity 계속",
                Toast.LENGTH_LONG).show();

    }


}
