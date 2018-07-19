package com.chenxyu.datepickerlibrary;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @author ChenXingYu
 * @date 2017/3/3
 */
public class DatePickerView {
    /**
     * 显示日期选择器
     *
     * @param context Context
     * @param view    TextView
     */
    public static void showDatePickerDialog(Context context, TextView view) {
        showDatePickerDialog(context, view, -1);
    }

    /**
     * 显示日期选择器
     *
     * @param context  Context
     * @param view     TextView
     * @param colorRes 颜色
     */
    public static void showDatePickerDialog(Context context, TextView view, int colorRes) {
        Handler mHandler = new Handler(context.getMainLooper());
        //获得当前日期
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.setTime(new Date());

        int mYear = calendar.get(Calendar.YEAR);
        int mMonth = calendar.get(Calendar.MONTH);
        int mDay = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog mDialog = new MyDatePickerDialog(context, R.style.DatePickerDialogPanel, null, mYear, mMonth, mDay);
        final DatePicker mDatePicker = mDialog.getDatePicker();
        mDialog.setButton(DialogInterface.BUTTON_POSITIVE, context.getString(R.string.picker_ok), (dialog, which) -> {
            final String mYear1 = String.valueOf(mDatePicker.getYear());
            final String mDay1;
            if (10 <= mDatePicker.getDayOfMonth()) {
                mDay1 = String.valueOf(mDatePicker.getDayOfMonth());
            } else {
                mDay1 = 0 + String.valueOf(mDatePicker.getDayOfMonth());
            }
            final String mMonth1;
            if (10 <= (mDatePicker.getMonth() + 1)) {
                mMonth1 = String.valueOf(mDatePicker.getMonth() + 1);
            } else {
                mMonth1 = 0 + String.valueOf(mDatePicker.getMonth() + 1);
            }

            mHandler.post(() -> {
                view.setText(String.format("%s-%s-%s", mYear1, mMonth1, mDay1));
                if (-1 != colorRes) {
                    view.setTextColor(context.getResources().getColor(colorRes));
                }
            });
        });
        mDialog.setButton(DialogInterface.BUTTON_NEGATIVE, context.getString(R.string.picker_no), (dialog, which) -> dialog.cancel());
        mDialog.show();
    }
}
