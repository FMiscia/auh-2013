package auh.activity;

import android.app.Fragment;
import presentation.LoginPanel;
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

                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                if(!logged){
                        mainPanel = new LoginPanel(inflater,(LinearLayout)findViewById(R.id.home));
                }
                else{
                        mainPanel = null;
                }

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