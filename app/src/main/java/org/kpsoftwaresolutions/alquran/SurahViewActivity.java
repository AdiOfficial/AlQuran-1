package org.kpsoftwaresolutions.alquran;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SurahViewActivity extends AppCompatActivity {

    TextView textView;
    int no;
    String value;
    String data = "";
    StringBuffer sb;
    InputStream is;
    BufferedReader br;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah_view);

        Bundle bundle = getIntent().getExtras();

        if(bundle != null) {
            value = bundle.getString("no");
            no = Integer.parseInt(value);
        }

        textView = findViewById(R.id.surahView);

        sb = new StringBuffer();

        switch (no) {
            case 1:
                is = this.getResources().openRawResource(R.raw.surah1);
                getData();
                break;
            case 2:
                is = this.getResources().openRawResource(R.raw.surah2);
                getData();
                break;
        }
    }
    public void getData() {

        br = new BufferedReader(new InputStreamReader(is));

        try{
            while((data = br.readLine()) != null) {
                sb.append(data).append("\n");
            }
            textView.setText(sb);
            is.close();
        } catch (IOException ex) {
            Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
        }
    }
}
