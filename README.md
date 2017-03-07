# DatePicker
时间选择控件(滚动式)


# Gradle 依赖

1.root build.gradle

```java
allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
```

2.app build.gradle

```java
dependencies {
	        compile 'com.github.chenxyu:DatePicker:1.0.0'
	}
```


# 使用方法

```java
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
```
