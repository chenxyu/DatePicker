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
	        compile 'com.github.chenxyu:DatePicker:1.0.1'
	}
```


# 使用方法

```java
    DatePickerView.showDatePickerDialog(this, mDate);
```
