# AndroidLayoutsExample
To teach how to use Layouts for Nearsoft's Android School CUU


### What will we see??

1. LinearLayout
2. CustomViews
3. GridLayout

### LinearLayout

This is the interface we are gonna build now:

![ScreenShot](https://github.com/thesnowgoose/AndroidLayoutsExample/blob/2-cinepolis/app/src/main/res/drawable/movies/cinepolis.jpeg "Logo Title Text 1")

1. First let's edit our activity_main.xml. This is gonna be our view container or how it is called on Android a 'View Group'. A ViewGroup can contain other views called children

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:background="@color/moviesBackground">


</LinearLayout>

```

We have set the orientation to vertical, meaning all elements inside the LinearLayout are gonna be displayed below the previous one.

2. Lets create the bar under the under the tool bar

```xml
<LinearLayout
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="horizontal"
    android:background="@color/banner"
    android:padding="10dp">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="match_parent"
        tools:text="Pune"
        android:textColor="@android:color/white"
        android:textSize="15sp"
        android:textStyle="bold" />

    <View
        android:layout_width="20dp"
        android:layout_height="20dp"
        android:background="@android:color/white"/>

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="match_parent"
        tools:text="All the cinemas"
        android:textColor="@android:color/white"
        android:textSize="15sp"
        android:textStyle="bold" />

    <Space
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:layout_weight="1" />

    <View
        android:layout_width="20dp"
        android:layout_height="20dp"
        android:background="@android:color/white" />

</LinearLayout>
```

down arrow

![ScreenShot](https://github.com/thesnowgoose/AndroidLayoutsExample/blob/2-cinepolis/app/src/main/res/drawable/icons/ionicons_2-0-1_ios-arrow-down_256_0_333333_none.png "Logo Title Text 1")

right arrow

![ScreenShot](https://github.com/thesnowgoose/AndroidLayoutsExample/blob/2-cinepolis/app/src/main/res/drawable/icons/ionicons_2-0-1_ios-arrow-forward_256_0_333333_none.png "Logo Title Text 1")

We are missing a color here so lets define it, lets define all
    - colorPrimary #0a599c
    - colorPrimaryDark #0a599c
    - colorAccent #FF4081
    - banner #062b45
    - moviesBackground #222b32

### Try your app

Some text is not being displayed, lets fix it. Just add this field
```xml
android:text="@string/text2"
```
And lets define our strings resources.


3. Lets use common styles, abstracting the styles on our TextViews. Add this content to the styles.xml file on values/

```xml
<style name="genericTextStyle">
    <item name="android:textColor">@android:color/white</item>
    <item name="android:textSize">15sp</item>
    <item name="android:textStyle">bold</item>
</style>
```

And lets reduce our two TextViews on activity_main.xml

```xml
style="@style/genericTextStyle"
```

4. Now let's add the cover image above the movies
```xml
<ImageView
    android:layout_width="match_parent"
    android:layout_height="130dp"
    android:background="@drawable/cover"/>

<TextView
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    tools:text="Show Times"
    android:text="@string/text3"
    style="@style/genericTextStyle"
    android:drawableEnd="@drawable/"
    android:layout_margin="10dp"/>
```

use this image for the cover:

![ScreenShot](https://github.com/thesnowgoose/AndroidLayoutsExample/blob/2-cinepolis/app/src/main/res/drawable/cover.png "Logo Title Text 1")

and this icon on the TextView:

![ScreenShot](https://github.com/thesnowgoose/AndroidLayoutsExample/blob/2-cinepolis/app/src/main/res/drawable/icons/ic_menu.png "Logo Title Text 1")

