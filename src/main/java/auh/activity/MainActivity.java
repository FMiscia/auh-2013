package auh.activity;

import android.app.Fragment;
import auh.data.KeyVal;
import auh.fragment.LoginFragment;
import auh.helper.SQLiteHelper;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import it.auh.R;

public class MainActivity extends Activity
{
        private Fragment mainPanel;

        private Boolean logged = false;

        @Override
        protected
        void onCreate(Bundle state)
        {
                super.onCreate(state);

                SQLiteHelper sqlite = new SQLiteHelper(this);
                KeyVal kv = sqlite.getKeyValStore();

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