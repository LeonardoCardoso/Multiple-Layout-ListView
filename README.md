Multiple Layout ListView For Android
========================

Developed by <a href='https://github.com/LeonardoCardoso' target='_blank'>@LeonardoCardoso</a>. 

This is an app to show how to use multiple layouts on Android.

Basically, you have to follow these steps:

1. Create the custom layous;
2. Create a custom adapter;
3. Override getViewTypeCount() method in your custom adapter with the amount of layouts you're gonna use in your listview;
4. Override getItemViewType(int position) method also in your custom adapter to return the current item's view type;
5. Additionally, it's essential to use a view holder to avoid memory leaks.


For more details, visit http://android.leocardz.com/multiple-layout-listview/


![Normal](http://i.imgur.com/pb1jDHY.gif)


## License

    Copyright 2015 Leonardo Cardoso

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
