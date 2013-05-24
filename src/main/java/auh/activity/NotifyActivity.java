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
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;
import auh.helper.NativeApp;
import it.auh.R;

import java.util.ArrayList;

public class NotifyActivity extends Activity
{
        @Override
        protected
        void onCreate(Bundle state){
                super.onCreate(state);
                setContentView(R.layout.notify_panel);
                Button notify = (Button) findViewById(R.id.notificabutton);
                notify.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                                Toast.makeText(NotifyActivity.this.getApplicationContext(),"Your Notification Has Been Sent",Toast.LENGTH_LONG).show();
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
