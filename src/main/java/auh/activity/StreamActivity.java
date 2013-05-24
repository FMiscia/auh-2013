package auh.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.TextView;
import auh.adapter.StreamAdapter;
import auh.helper.NativeApp;
import it.auh.R;

import java.util.ArrayList;

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
        public boolean onCreateOptionsMenu(Menu menu) {
                MenuInflater inflater = getMenuInflater();
                inflater.inflate(R.menu.option_menu, menu);

                /*ArrayList<String> autocomplete = new ArrayList<String>();

                final MenuItem searchMenuItem = menu.findItem(R.id.search);
                for(int i=0;i< NativeApp.getInstance().getUsers().size();i++){
                        autocomplete.add(NativeApp.getInstance().getUsers().get(i).getName());
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                        android.R.layout.simple_dropdown_item_1line, autocomplete);
                final AutoCompleteTextView textView = (AutoCompleteTextView)
                        searchMenuItem.getActionView();
                textView.setMinWidth(350);
                textView.setBackgroundColor(Color.WHITE);
                textView.requestFocus();

                textView.setOnKeyListener(new View.OnKeyListener() {
                        public boolean onKey(View v, int keyCode, KeyEvent event) {
                                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                                        (keyCode == KeyEvent.KEYCODE_ENTER))  {
                                        Intent intent = new Intent(StreamActivity.this,ProfileActivity.class);
                                        Bundle bundle = new Bundle();
                                        bundle.putString("username", textView.getText().toString());
                                        intent.putExtras(bundle);
                                        StreamActivity.this.startActivity(intent);
                                }
                                return true;
                        }
                });
                textView.setAdapter(adapter);*/

                return super.onCreateOptionsMenu(menu);
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {

                // Handle item selection
                switch (item.getItemId()) {

                        case R.id.profile:
                                Intent b = new Intent(this,ProfileActivity.class);
                                Bundle extras = new Bundle();
                                extras.putString("username", NativeApp.getInstance().getLoggedName());
                                b.putExtras(extras);
                                startActivity(b);
                                return true;

                        case R.id.settings:
                                Intent b1 = new Intent(this,SettingsActivity.class);
                                startActivity(b1);
                                return true;

                        case R.id.add:
                                Intent b2 = new Intent(this,NotifyActivity.class);
                                startActivity(b2);
                                return true;

                        default:
                                return super.onOptionsItemSelected(item);

                }
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
