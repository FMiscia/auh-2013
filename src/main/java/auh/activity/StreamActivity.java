package auh.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import auh.adapter.StreamAdapter;
import auh.helper.NativeApp;
import it.auh.R;

public class StreamActivity extends Activity
{
        StreamAdapter adapter;
        private String username;

        @Override
        protected void onCreate(Bundle state)
        {
                super.onCreate(state);

                this.username = this.getIntent().getExtras().getString("username");
                this.setContentView(R.layout.stream_panel);

                TextView userView = (TextView) findViewById(R.id.username);
                userView.setText(this.username);

                ListView list =(ListView) findViewById(R.id.list);

                // Getting adapter by passing xml data ArrayList
                adapter = new StreamAdapter(this, NativeApp.getInstance().getRfcs());
                list.setAdapter(adapter);

                // Click event for single list row
                list.setOnItemClickListener(new OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                        {
                                Intent i = new Intent(StreamActivity.this, RfcActivity.class);
                                Bundle extras = new Bundle();
                                extras.putInt("rfc_index", position);
                                i.putExtras(extras);
                                StreamActivity.this.startActivity(i);
                        }
                });

        }

        @Override
        protected
        void onRestart()
        {
                super.onRestart();
        }

        @Override
        protected
        void onStart()
        {
                super.onStart();
        }

        @Override
        protected
        void onResume()
        {
                super.onResume();
        }

        @Override
        protected
        void onPause()
        {
                super.onPause();
        }

        @Override
        protected
        void onStop()
        {
                super.onStop();
        }

        @Override
        protected
        void onDestroy()
        {
                super.onDestroy();
        }
}
