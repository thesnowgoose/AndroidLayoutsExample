# AndroidLayoutsExample
To teach how to use Layouts for Nearsoft's Android School CUU


### What will we see??

1. LinearLayout
2. CustomViews
3. GridLayout

- Add Icons and images from drawables

### LinearLayout

This is the interface we are gonna build now:

![ScreenShot](https://github.com/thesnowgoose/AndroidLayoutsExample/blob/2-cinepolis/app/src/main/res/drawable/cinepolis.jpeg "Logo Title Text 1")

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

2. Lets create the bar under the tool bar

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

### Take time to explain Space

Here are some resources pending to add:

down arrow

![ScreenShot](https://github.com/thesnowgoose/AndroidLayoutsExample/blob/2-cinepolis/app/src/main/res/drawable/ic_arrow_down.png "Logo Title Text 1")

right arrow

![ScreenShot](https://github.com/thesnowgoose/AndroidLayoutsExample/blob/2-cinepolis/app/src/main/res/drawable/ic_arrow_forward.png "Logo Title Text 1")

Lets add them as ImageVector and update our previous layout changing the Views for ImageViews

```
    android:background="@drawable/ic_down_arrow"
```

We are missing some colors here so lets define it, lets define them all
    - colorPrimary #0a599c
    - colorPrimaryDark #0a599c
    - colorAccent #FF4081
    - banner #062b45
    - moviesBackground #222b32

### Try your app

Some text is not being displayed, lets fix it. Just add this field
```
    android:text="@string/text2"
```
And add them to our strings resources.


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
```

use this image for the cover:

![ScreenShot](https://github.com/thesnowgoose/AndroidLayoutsExample/blob/2-cinepolis/app/src/main/res/drawable/cover.png "Logo Title Text 1")

And there is some text below the image, right?
```xml
<TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        tools:text="Show Times"
        android:text="@string/text3"
        android:drawableEnd="@drawable/ic_list_menu"
        android:gravity="center_vertical"
        style="@style/genericTextStyle"
        android:layout_margin="10dp"/>
```

and this icon on the TextView:

![ScreenShot](https://github.com/thesnowgoose/AndroidLayoutsExample/blob/2-cinepolis/app/src/main/res/drawable/ic_menu.png "Logo Title Text 1")

5. Ok now we are gonna add the movies list, to display them we are gonna use the GridLayout
```xml
<GridLayout
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:useDefaultMargins="true"
    android:columnCount="4">

</GridLayout>
```

Let's define our item_movie:
```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <ImageView
        android:layout_width="match_parent"
        android:layout_height="120dp"
        android:src="@drawable/movie1"
        android:layout_gravity="center_horizontal"
        android:layout_margin="6dp"/>

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center_horizontal"
        style="@style/genericTextStyle"
        android:text="@string/text4"/>

</LinearLayout>
```

Now add it to our GridLayout several times
```xml
<include layout="@layout/item_movie"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_columnWeight="1"/>
```

If you want to be able to scroll the view on your phone just wrap the GridLayout with a ScrollView
```xml
<ScrollView
    android:layout_width="match_parent"
    android:layout_height="match_parent" >

    <GridLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:useDefaultMargins="true"
        android:columnCount="4">

        <include layout="@layout/item_movie"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_columnWeight="1"/>
        <include layout="@layout/item_movie"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_columnWeight="1"/>
        <include layout="@layout/item_movie"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_columnWeight="1"/>
        <include layout="@layout/item_movie"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_columnWeight="1"/>

    </GridLayout>

</ScrollView>
```

6. Finally lets fix the toolbar

Change the parent on AppTheme on styles.xml:
```
parent="Theme.AppCompat.NoActionBar"
```

Create a new file toolbar_main.xml
```xml
<android.support.v7.widget.Toolbar
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/toolbar"
    android:layout_width="match_parent"
    android:layout_height="?attr/actionBarSize"
    android:background="@color/colorPrimary"
    android:elevation="4dp"/>
```

And include this layout on top of our activity_main.xml
```xml
<include layout="@layout/toolbar_main"/>
```

Finally add this to our MainActivity.java so it is displayed on runtime:
```java
Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
setSupportActionBar(toolbar);
getSupportActionBar().setDisplayShowTitleEnabled(false);;
```