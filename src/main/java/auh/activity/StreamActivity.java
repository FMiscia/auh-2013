package auh.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
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
                this.setContentView(R.layout.stream_activity);

                this.setTitle(this.username);

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
        public boolean onCreateOptionsMenu(Menu menu)
        {
                MenuItem searchButton = menu.add("Search");
                searchButton.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
                searchButton.setIcon(android.R.drawable.ic_menu_search);
                searchButton.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item)
                        {
                                Intent i = new Intent(StreamActivity.this, SearchActivity.class);
                                StreamActivity.this.startActivity(i);

                                return true;
                        }
                });


                MenuItem profileButton = menu.add("Profile");
                profileButton.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
                profileButton.setIcon(android.R.drawable.ic_menu_sort_by_size);
                profileButton.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item)
                        {
                                Intent i = new Intent(StreamActivity.this, ProfileActivity.class);
                                StreamActivity.this.startActivity(i);

                                return true;
                        }
                });

                MenuItem reportButton = menu.add("Report");
                reportButton.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
                reportButton.setIcon(android.R.drawable.ic_menu_add);
                reportButton.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item)
                        {
                                Intent i = new Intent(StreamActivity.this, NotifyActivity.class);
                                StreamActivity.this.startActivity(i);

                                return true;
                        }
                });

                MenuItem settinginsButton = menu.add("Settings");
                settinginsButton.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
                settinginsButton.setIcon(android.R.drawable.ic_menu_preferences);
                settinginsButton.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item)
                        {
                                Intent i = new Intent(StreamActivity.this, SettingsActivity.class);
                                StreamActivity.this.startActivity(i);

                                return true;
                        }
                });

                return true;
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
