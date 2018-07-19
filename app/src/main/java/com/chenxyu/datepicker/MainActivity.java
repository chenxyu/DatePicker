package com.chenxyu.datepicker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.chenxyu.datepickerlibrary.DatePickerView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDate = findViewById(R.id.date);
        findViewById(R.id.btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                DatePickerView.showDatePickerDialog(this, mDate);
                break;
            default:
                break;
        }
    }
}
