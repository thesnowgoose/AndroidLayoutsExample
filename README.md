# AndroidLayoutsExample
To teach how to use Layouts for Nearsoft's Android School CUU


### What will we see??

1. Splash screen
2. Selectors
2. RelativeLayout

### Splash Screen

First lets start easy, lets define our splash screen layout that's gonna start our app.

1. This is the splash screen I've choosed:

![alt text](https://s-media-cache-ak0.pinimg.com/236x/98/5b/ca/985bcaef215c825ff4e7730d5c6eeb88--pillows-splash-screen.jpg "Logo Title Text 1")

2. Change our app style colors
    - colorPrimary #7c27a0
    - colorPrimaryDark #15052a

3. Define our selector, what does a selector is?
    - Right click on drawable and New > New Drawable Resource file
    ```xml
    <item>
        <shape>
            <gradient
                android:angle="45"
                android:startColor="@color/colorPrimary"
                android:endColor="@color/colorPrimaryDark"
                android:type="linear" />
        </shape>
    </item>
    ```

4. Set the new selector as background on our SplashActivity layout
```xml
android:background="@drawable/background_splash_activity"
```

5. Use these image to set it as the logo on SplashScreen
----

![ScreenShot](https://github.com/thesnowgoose/AndroidLayoutsExample/blob/1-SplashBase/app/src/main/res/drawable/pillow.png "Logo Title Text 1")

----

![ScreenShot](https://github.com/thesnowgoose/AndroidLayoutsExample/blob/1-SplashBase/app/src/main/res/drawable/neybox.png "Logo Title Text 1")

----

![ScreenShot](https://github.com/thesnowgoose/AndroidLayoutsExample/blob/1-SplashBase/app/src/main/res/drawable/neybox_logo.png "Logo Title Text 1")

----
6. ShplashActivity layout
```xml
    <ImageView
        android:layout_width="150dp"
        android:layout_height="wrap_content"
        android:src="@drawable/pillow"
        android:layout_centerInParent="true"
        android:scaleType="fitStart"
        android:paddingBottom="60dp" />

    <TextView
        android:id="@+id/splash_version"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        tools:text="v.1.2"
        android:textSize="17sp"
        android:textStyle="bold"
        android:textColor="@color/purple_text"
        android:layout_centerHorizontal="true"
        android:layout_alignParentBottom="true"
        android:layout_marginBottom="25dp"/>

    <ImageView
        android:id="@+id/splash_company_label"
        android:layout_width="60dp"
        android:layout_height="wrap_content"
        android:src="@drawable/neybox"
        android:layout_above="@id/splash_version"
        android:layout_centerHorizontal="true"/>

    <ImageView
        android:id="@+id/splash_company_logo"
        android:layout_width="25dp"
        android:layout_height="wrap_content"
        android:src="@drawable/neybox_logo"
        android:layout_above="@id/splash_company_label"
        android:layout_centerHorizontal="true"/>
```
