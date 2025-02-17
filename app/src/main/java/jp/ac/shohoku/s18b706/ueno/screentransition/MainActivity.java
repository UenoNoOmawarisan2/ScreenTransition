package jp.ac.shohoku.s18b706.ueno.screentransition;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.view.View.OnClickListener;
//import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends Activity { //AppCompatActivity → Activity
    int count = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ボタンを押したときにイベントを取得できるようにする
        Button button1 =  findViewById(R.id.button1);
        button1.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v){
                if(count == 1){
                    // 変更したいレイアウトを取得する
                    LinearLayout layout = findViewById(R.id.linearlayout1);
                    // レイアウトのビューをすべて削除する
                    layout.removeAllViews();
                    // レイアウトをR.layout.sampleに変更する
                    getLayoutInflater().inflate(R.layout.view2,layout);
                    count=2;
                }else if(count == 2){
                    LinearLayout layout =  findViewById(R.id.linearlayout2);
                    layout.removeAllViews();
                    getLayoutInflater().inflate(R.layout.view1,layout);
                    count=1;
                }
            }
        });
    }
}
