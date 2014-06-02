package com.leocardz.android.multiple.layout.listview;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listview);

        final ListViewItem[] items = new ListViewItem[40];

        for (int i = 0; i < items.length; i++) {
            if (i == 4) {
                items[i] = new ListViewItem("White " + i, CustomAdapter.TYPE_WHITE);
            } else if (i == 9) {
                items[i] = new ListViewItem("Black " + i, CustomAdapter.TYPE_BLACK);
            } else if (i % 2 == 0) {
                items[i] = new ListViewItem("EVEN " + i, CustomAdapter.TYPE_EVEN);
            } else {
                items[i] = new ListViewItem("ODD " + i, CustomAdapter.TYPE_ODD);
            }
        }

        CustomAdapter customAdapter = new CustomAdapter(this, R.id.text, items);
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getBaseContext(), items[i].getText(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public class ListViewItem {
        private String text;
        private int type;

        public ListViewItem(String text, int type) {
            this.text = text;
            this.type = type;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

    }


    public class CustomAdapter extends ArrayAdapter<ListViewItem> {

        public static final int TYPE_ODD = 0;
        public static final int TYPE_EVEN = 1;
        public static final int TYPE_WHITE = 2;
        public static final int TYPE_BLACK = 3;

        private ListViewItem[] objects;

        @Override
        public int getViewTypeCount() {
            return 4;
        }

        @Override
        public int getItemViewType(int position) {
            return objects[position].getType();
        }

        public CustomAdapter(Context context, int resource, ListViewItem[] objects) {
            super(context, resource, objects);
            this.objects = objects;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder viewHolder = null;
            ListViewItem listViewItem = objects[position];
            int listViewItemType = getItemViewType(position);


            if (convertView == null) {

                if (listViewItemType == TYPE_EVEN) {
                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.type_even, null);
                } else if (listViewItemType == TYPE_ODD) {
                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.type_odd, null);
                } else if (listViewItemType == TYPE_WHITE) {
                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.type_white, null);
                } else {
                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.type_black, null);
                }

                TextView textView = (TextView) convertView.findViewById(R.id.text);
                viewHolder = new ViewHolder(textView);

                convertView.setTag(viewHolder);

            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            viewHolder.getText().setText(listViewItem.getText());

            return convertView;
        }

    }

    public class ViewHolder {
        TextView text;

        public ViewHolder(TextView text) {
            this.text = text;
        }

        public TextView getText() {
            return text;
        }

        public void setText(TextView text) {
            this.text = text;
        }

    }

}
