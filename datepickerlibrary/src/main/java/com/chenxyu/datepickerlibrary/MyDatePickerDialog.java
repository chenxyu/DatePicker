package com.chenxyu.datepickerlibrary;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.DatePicker;

/**
 * @author ChenXingYu
 */
public class MyDatePickerDialog extends DatePickerDialog {
    MyDatePickerDialog(Context context, int theme, OnDateSetListener listener, int year, int monthOfYear, int dayOfMonth) {
        super(context, theme, listener, year, monthOfYear, dayOfMonth);
        this.setTitle(year + "年" + (monthOfYear + 1) + "月" + dayOfMonth + "日");
    }

    @Override
    public void onDateChanged(DatePicker view, int year, int month, int day) {
        super.onDateChanged(view, year, month, day);
        this.setTitle(year + "年" + (month + 1) + "月" + day + "日");
    }
}
