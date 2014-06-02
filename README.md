Multiple Layout ListView For Android
========================

This is an app to show how to use multiple layouts on Android.

Basically, you have to follow these steps:

1. Create the custom layous;
2. Create a custom adapter;
3. Override getViewTypeCount() method in your custom adapter with the amount of layouts you're gonna use in your listview;
4. Override getItemViewType(int position) method also in your custom adapter to return the current item's view type;
5. Additionally, it's essential to use a view holder to avoid memory leaks.


For more details, visit http://android.leocardz.com/multiple-layout-listview/


![Normal](https://dl.dropbox.com/s/b0iuiso6wis2c1m/multi.gif)
