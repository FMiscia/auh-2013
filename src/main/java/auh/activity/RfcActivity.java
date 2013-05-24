package auh.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.*;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import auh.helper.NativeApp;
import it.auh.R;

import java.util.ArrayList;

public class RfcActivity extends Activity {

        @Override
        protected void onCreate(Bundle state){
                super.onCreate(state);

                 Integer rfcIndex = this.getIntent().getExtras().getInt("rfc_index");


                this.setContentView(R.layout.rfc_activity);
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
                MenuInflater inflater = getMenuInflater();
                inflater.inflate(R.menu.option_menu, menu);

                ArrayList<String> autocomplete = new ArrayList<String>();

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
                                        Intent intent = new Intent(RfcActivity.this,ProfileActivity.class);
                                        Bundle bundle = new Bundle();
                                        bundle.putString("username", textView.getText().toString());
                                        intent.putExtras(bundle);
                                        RfcActivity.this.startActivity(intent);
                                }
                                return true;
                        }
                });
                textView.setAdapter(adapter);

                return super.onCreateOptionsMenu(menu);
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {

                // Handle item selection
                switch (item.getItemId()) {

                        case R.id.profile:
                                Intent b = new Intent(this,ProfileActivity.class);
                                startActivity(b);

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
