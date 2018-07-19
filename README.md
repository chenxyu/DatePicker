[![](https://www.jitpack.io/v/chenxyu/DatePicker.svg)](https://www.jitpack.io/#chenxyu/DatePicker)

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
	        compile 'com.github.chenxyu:DatePicker:1.1.2'
	}
```


# 使用方法

```java
    TextView mDate = findViewById(R.id.date);
    DatePickerView.showDatePickerDialog(this, mDate);
```
