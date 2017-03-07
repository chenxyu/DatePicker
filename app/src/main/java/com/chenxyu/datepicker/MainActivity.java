package com.chenxyu.datepicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.chenxyu.datepickerlibrary.DatePickerView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDate = (TextView) findViewById(R.id.date);
        findViewById(R.id.btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                DatePickerView.showDatePickerDialog(this, DatePickerView.YEAR_MONTH_DAY, new DatePickerView.CallBack() {
                    @Override
                    public void showDate(int module, String year, String month, String day) {
                        switch (module) {
                            case DatePickerView.YEAR_MONTH_DAY:
                                mDate.setText(String.format("%s年%s月%s日", year, month, day));
                                break;
                            case DatePickerView.YEAR_MONTH:
                                mDate.setText(String.format("%s年%s月", year, month));
                                break;
                        }
                    }
                });
                break;
        }
    }
}
