package auh.activity;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.Toast;
import auh.fragment.LoginFragment;
import it.auh.R;

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
