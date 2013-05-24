package auh.activity;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.SearchView;
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

/*        @Override
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
                AutoCompleteTextView textView = (AutoCompleteTextView)
                        searchMenuItem.getActionView();
                textView.setMinWidth(350);
                textView.setBackgroundColor(Color.WHITE);

                TextView.OnEditorActionListener exampleListener = new TextView.OnEditorActionListener(){

                        @Override
                        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                                if (i == EditorInfo.IME_NULL
                                        && keyEvent.getAction() == KeyEvent.ACTION_DOWN) {
                                        Intent intent = new Intent(MainActivity.this,ProfileActivity.class);
                                        Bundle bundle = new Bundle();
                                        bundle.putString("username", textView.getText().toString());
                                        intent.putExtras(bundle);
                                        startActivity(intent);
                                }
                                return true;
                        }
                };
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
        }*/

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
