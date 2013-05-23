package auh.activity;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import auh.adapter.StreamAdapter;
import it.auh.R;

public class StreamActivity extends Activity
{
        ListView list;
        StreamAdapter adapter;

        @Override
        public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);

                this.setContentView(R.layout.stream_panel);

                ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

                HashMap<String, String> keyval = new HashMap<String, String>();
                keyval.put("key", "val");

                list.add(keyval);
                list.add(keyval);
                list.add(keyval);

                this.list =(ListView) findViewById(R.id.list);

                // Getting adapter by passing xml data ArrayList
                adapter=new StreamAdapter(this, list);
                this.list.setAdapter(adapter);

                // Click event for single list row
                this.list.setOnItemClickListener(new OnItemClickListener()
                {

                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                        {
                                Log.i(StreamActivity.class.getName(), "clickato");
                        }
                });
        }
}
