package com.chenxyu.datepickerlibrary;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by ChenXingYu on 2017/3/3.
 */

public class DatePickerView {
    public static final int YEAR_MONTH_DAY = 0; //默认
    public static final int YEAR_MONTH = 1;

    /**
     * @param callBack 返回日期
     */
    public static void showDatePickerDialog(Context context, CallBack callBack) {
        showDatePickerDialog(context, YEAR_MONTH_DAY, callBack);
    }

    /**
     * @param module   显示年月日（YEAR_MONTH_DAY 默认），显示年月（YEAR_MONTH）
     * @param callBack 返回日期
     */
    public static void showDatePickerDialog(final Context context, final int module, final CallBack callBack) {
        final Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.setTime(new Date());

        int mYear = calendar.get(Calendar.YEAR);
        int mMonth = calendar.get(Calendar.MONTH);
        int mDay = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog mDialog = new MyDatePickerDialog(context, R.style.DatePickerDialogPanel, null, mYear, mMonth, mDay, module);
        final DatePicker mDatePicker = mDialog.getDatePicker();
        mDialog.setButton(DialogInterface.BUTTON_POSITIVE, context.getString(R.string.picker_ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final String mYear = String.valueOf(mDatePicker.getYear());
                final String mDay;
                if (mDatePicker.getDayOfMonth() >= 10)
                    mDay = String.valueOf(mDatePicker.getDayOfMonth());
                else
                    mDay = 0 + String.valueOf(mDatePicker.getDayOfMonth());
                final String mMonth;
                if ((mDatePicker.getMonth() + 1) >= 10)
                    mMonth = String.valueOf(mDatePicker.getMonth() + 1);
                else
                    mMonth = 0 + String.valueOf(mDatePicker.getMonth() + 1);


                switch (module) {
                    case YEAR_MONTH_DAY:
                        callBack.showDate(module, mYear, mMonth, mDay);
                        break;
                    case YEAR_MONTH:
                        callBack.showDate(module, mYear, mMonth, mDay);
                        break;
                }
            }
        });
        mDialog.setButton(DialogInterface.BUTTON_NEGATIVE, context.getString(R.string.picker_no), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        mDialog.show();
    }

    public interface CallBack {
        void showDate(int module, String year, String month, String day);
    }
}
