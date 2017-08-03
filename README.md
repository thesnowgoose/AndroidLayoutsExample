# AndroidLayoutsExample
To teach how to use Layouts for Nearsoft's Android School CUU


### What will we see??

1. 9Patch

A NinePatchDrawable graphic is a stretchable bitmap image that you can use as the background of a view. Android automatically resizes the graphic to accommodate the contents of the view. An example use of a NinePatch image is the background used by standard Android buttons.
Is a standard PNG image that includes an extra 1-pixel border. It must be saved with the 9.png extension in the res/drawable/ directory of your project.

This extra border is used to define the stretchable area (border on top and left) and the fill area (border on bottom and right).

![ScreenShot](https://github.com/thesnowgoose/AndroidLayoutsExample/blob/4-9patch/app/src/main/res/drawable/guide_9patch_borders.png "Logo Title Text 1")

The TOP and LEFT border lines are used to define the scalable portion of your image - LEFT for scaling height, TOP for scaling width, everything else, such as the corners, will remain the same size. This allows you to have buttons that can scale to any size and maintain a uniform look.

![ScreenShot](https://github.com/thesnowgoose/AndroidLayoutsExample/blob/4-9patch/app/src/main/res/drawable/guide_9patch_scalable_area.png "Logo Title Text 1")

It's important to note that 9-patch images don't scale down - they only scale up. So it's best to start as small as possible.

![ScreenShot]( "Logo Title Text 1")

Fill area guides are optional and provide a way define the area for stuff like your text label. Fill determines how much room there is within your image to place text, or an icon, or other things. 9-patch isn't just for buttons, it works for background images as well.

![ScreenShot](https://github.com/thesnowgoose/AndroidLayoutsExample/blob/4-9patch/app/src/main/res/drawable/npatch_button_green.9.png "Logo Title Text 1")
