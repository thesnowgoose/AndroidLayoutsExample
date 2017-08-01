# AndroidLayoutsExample
To teach how to use Layouts for Nearsoft's Android School CUU


### What will we see??

1. Custom Views
2. merge tag


### Custom View

A custom view is used when none of the existing views fits with your app needs. So just Extending for any of the View Classes you can define your oun custom view.

![ScreenShot](https://github.com/thesnowgoose/AndroidLayoutsExample/blob/3-CustomViewBase/app/src/main/res/drawable/view-hierarchy.png "Logo Title Text 1")

To build a basic custom view we need this:

1. Define our custom view layout
2. Create a java class for your custom view implementing any of the views classes above.
3. Define attributes for our custom view on attrs.xml
4. Add our custom view to any existing layout (activity_main.xml)
5. Get in working on MainActivity.java

First let's define the layout for our custom view. We are gonna use <merge> tag. What does it do?

It save us from using any ViewGroup when its not necessary. Merge help us to only wrap many views together.
https://stackoverflow.com/questions/8834898/what-is-the-purpose-of-androids-merge-tag-in-xml-layouts
https://developer.android.com/training/improving-layouts/reusing-layouts.html

view_color_options.xml
```xml
<merge xmlns:android="http://schemas.android.com/apk/res/android" >

    <TextView
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_weight="1"
        android:layout_centerVertical="true"
        android:layout_marginLeft="16dp"
        android:textSize="18sp"
        />

    <View
        android:layout_width="26dp"
        android:layout_height="26dp"
        android:layout_centerVertical="true"
        android:layout_marginLeft="16dp"
        android:layout_marginRight="16dp"
        />

    <ImageView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginRight="16dp"
        android:layout_centerVertical="true"
        android:visibility="gone"
        />

</merge>
```

Now our ColorOptionsView.java is gonna implement LinearLayout
```java
public class ColorOptionsView extends LinearLayout {

    private View mValue;
    private ImageView mImage;

    public ColorOptionsView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.ColorOptionsView, 0, 0);
        String titleText = a.getString(R.styleable.ColorOptionsView_titleText);
        @SuppressWarnings("ResourceAsColor")
        int valueColor = a.getColor(R.styleable.ColorOptionsView_valueColor,
                android.R.color.holo_blue_light);
        a.recycle();

        setOrientation(LinearLayout.HORIZONTAL);
        setGravity(Gravity.CENTER_VERTICAL);

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.view_color_options, this, true);

        TextView title = (TextView) getChildAt(0);
        title.setText(titleText);

        mValue = getChildAt(1);
        mValue.setBackgroundColor(valueColor);

        mImage = (ImageView) getChildAt(2);
    }

    public ColorOptionsView(Context context) {
        this(context, null);
    }

    public void setValueColor(int color) {
        mValue.setBackgroundColor(color);
    }

    public void setImageVisible(boolean visible) {
        mImage.setVisibility(visible ? View.VISIBLE : View.GONE);
    }

}
```

Now that it has extended from LinearLayout we have access to the life cycle of the view:
![ScreenShot](https://github.com/thesnowgoose/AndroidLayoutsExample/blob/3-CustomViewBase/app/src/main/res/drawable/view-lifecycle.png "Logo Title Text 1")


As we can see, our custom attributes are gonna be a text and a color. So we are gonna define this attributes in values/attrs.xml
```xml
<resources>
    <declare-styleable name="ColorOptionsView">
        <attr name="titleText" format="string" localization="suggested" />
        <attr name="valueColor" format="color" />
    </declare-styleable>
</resources>
```

Now let's add our custom view to the activity_main.xml
```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:custom="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/background"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:divider="?android:attr/listDivider"
    android:orientation="vertical"
    android:showDividers="middle"
    tools:context="com.thesnowgoose.androidlayoutexamples.MainActivity">

    <com.thesnowgoose.androidlayoutexamples.ColorOptionsView
        android:id="@+id/view1"
        android:layout_width="match_parent"
        android:layout_height="?android:attr/listPreferredItemHeight"
        android:background="?android:selectableItemBackground"
        android:onClick="onClicked"
        custom:titleText="Green Background"
        custom:valueColor="@android:color/holo_green_light"
        />

    <com.thesnowgoose.androidlayoutexamples.ColorOptionsView
        android:id="@+id/view2"
        android:layout_width="match_parent"
        android:layout_height="?android:attr/listPreferredItemHeight"
        android:background="?android:selectableItemBackground"
        android:onClick="onClicked"
        custom:titleText="Orange Background"
        custom:valueColor="@android:color/holo_orange_dark" />

</LinearLayout>
```

Adding behaviour to our MainActivity.java
```java
    LinearLayout contentHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contentHolder = (LinearLayout) findViewById(R.id.background);
    }

    public void onClicked(View view) {
        String text = view.getId() == R.id.view1 ? "Green" : "Orange";

        if (view.getId() == R.id.view1) {
            contentHolder.setBackgroundColor(
                    ResourcesCompat.getColor(getResources(), android.R.color.holo_green_light, null));
        } else if (view.getId() == R.id.view2) {
            contentHolder.setBackgroundColor(
                    ResourcesCompat.getColor(getResources(), android.R.color.holo_orange_dark, null));
        }
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
```

