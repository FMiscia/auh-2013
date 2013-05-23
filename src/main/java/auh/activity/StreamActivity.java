package auh.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import it.auh.R;

/**
 * Created by francesco on 23/05/13.
 */
public class StreamActivity extends Activity {

        private String username;

        @Override
        protected void onCreate(Bundle state){
                super.onCreate(state);
                this.username = getIntent().getExtras().getString("username");
                this.setContentView(R.layout.stream_panel);
                TextView userView = (TextView) findViewById(R.id.username);
                userView.setText(this.username);
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
