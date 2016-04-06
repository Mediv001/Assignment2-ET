package com.example.english.assignment2;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    CustomView cv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView number = (TextView)findViewById(R.id.tx1);
        TextView nonmarked = (TextView)findViewById(R.id.tx2);
        number.setText("Mines number : 20");
        Button reset = (Button)findViewById(R.id.reset);
        reset.setText("Reset");
        cv = (CustomView)findViewById(R.id.customview);
        cv.tx = nonmarked;
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cv.reset();
            }
        });

        final Button marked = (Button)findViewById(R.id.button2);
        marked.setText("Marking");
        marked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cv.change();
                changetext(marked);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void changetext(Button cv){
        if(cv.getText() == "Marking"){
            cv.setText("Uncover");
        }else{
            cv.setText("Marking");
        }
    }
}
