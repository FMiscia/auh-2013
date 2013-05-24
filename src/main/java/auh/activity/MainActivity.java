package auh.activity;

import android.app.Fragment;
import android.app.SearchManager;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;
import auh.data.KeyVal;
import auh.domain.User;
import auh.fragment.LoginFragment;
import auh.helper.NativeApp;
import auh.helper.SQLiteHelper;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import it.auh.R;

import java.util.ArrayList;

public class MainActivity extends Activity
{
        private Fragment mainPanel;

        private SearchView searchView;

        private Boolean logged = false;

        @Override
        protected
        void onCreate(Bundle state)
        {
                super.onCreate(state);

                /*SQLiteHelper sqlite = new SQLiteHelper(this);
                KeyVal kv = sqlite.getKeyValStore();*/

                LayoutInflater inflater =(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                mainPanel = new LoginFragment(inflater, (LinearLayout) this.findViewById(R.layout.home_activity), this);

                this.setContentView(mainPanel.getView());

                try {
                        Thread.sleep(5000);
                        Intent i = new Intent(this,ProfileActivity.class);
                        startActivity(i);
                } catch (InterruptedException e) {
                        e.printStackTrace();
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