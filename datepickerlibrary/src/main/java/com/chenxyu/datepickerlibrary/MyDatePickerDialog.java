package com.chenxyu.datepickerlibrary;

import android.app.DatePickerDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

/**
 * Created by ChenXingYu on 2017/3/3.
 */

public class MyDatePickerDialog extends DatePickerDialog {
    private int mModule;
    private static final int YEAR_MONTH_DAY = 0; //默认
    private static final int YEAR_MONTH = 1;

    public MyDatePickerDialog(Context context, int theme, OnDateSetListener listener, int year, int monthOfYear, int dayOfMonth, int module) {
        super(context, theme, listener, year, monthOfYear, dayOfMonth);
        this.mModule = module;
        switch (mModule) {
            case YEAR_MONTH_DAY:
                this.setTitle(year + "年" + (monthOfYear + 1) + "月" + dayOfMonth + "日");
                break;
            case YEAR_MONTH:
                this.setTitle(year + "年" + (monthOfYear + 1) + "月");
                ((ViewGroup) ((ViewGroup) this.getDatePicker().getChildAt(0)).getChildAt(0)).getChildAt(2).setVisibility(View.GONE);
                break;
        }
    }

    @Override
    public void onDateChanged(@NonNull DatePicker view, int year, int month, int day) {
        super.onDateChanged(view, year, month, day);
        switch (mModule) {
            case YEAR_MONTH_DAY:
                this.setTitle(year + "年" + (month + 1) + "月" + day + "日");
                break;
            case YEAR_MONTH:
                this.setTitle(year + "年" + (month + 1) + "月");
                break;
        }
    }
}
