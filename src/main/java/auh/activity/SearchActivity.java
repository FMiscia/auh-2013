package auh.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import auh.helper.NativeApp;
import it.auh.R;

import java.util.ArrayList;

public class SearchActivity extends Activity {

        private ArrayList<String> autocomplete = new ArrayList<String>();

        @Override
        protected
        void onCreate(Bundle state){
                super.onCreate(state);

                this.setContentView(R.layout.search_activity);

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                        android.R.layout.simple_dropdown_item_1line, this.autocomplete);

                final AutoCompleteTextView textView = (AutoCompleteTextView)
                                findViewById(R.id.searchProfile);

                for(int i=0;i< NativeApp.getInstance().getUsers().size();i++){
                        autocomplete.add(NativeApp.getInstance().getUsers().get(i).getName());
                }

                textView.setAdapter(adapter);
                textView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                        @Override
                        public void onFocusChange(View view, boolean b) {
                                textView.setText("");
                        }
                });
                textView.setOnKeyListener(new View.OnKeyListener() {
                        public boolean onKey(View v, int keyCode, KeyEvent event) {
                                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                                        (keyCode == KeyEvent.KEYCODE_ENTER))  {
                                        Intent intent = new Intent(SearchActivity.this,ProfileActivity.class);
                                        Bundle bundle = new Bundle();
                                        bundle.putString("username", textView.getText().toString());
                                        intent.putExtras(bundle);
                                        SearchActivity.this.startActivity(intent);
                                }
                                return false;
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
