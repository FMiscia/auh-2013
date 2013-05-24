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
import android.widget.ImageView;
import android.widget.ListView;
import auh.adapter.CommentsAdapter;
import auh.domain.Comment;
import auh.domain.Rfc;
import auh.helper.NativeApp;
import it.auh.R;

import java.util.ArrayList;
import java.util.Queue;

public class RfcActivity extends Activity {

        @Override
        protected void onCreate(Bundle state){
                super.onCreate(state);

                this.setContentView(R.layout.rfc_activity);

                Integer rfcIndex = this.getIntent().getExtras().getInt("rfc_index");
                Rfc rfc = NativeApp.getInstance().getRfcs().get(rfcIndex);

                CommentsAdapter adapter = new CommentsAdapter(this, R.layout.comment_row, this._getData(rfc.getComments()));

                ImageView splash =(ImageView) this.findViewById(R.id.widget_splash);
                splash.setImageResource(rfc.getContent());

                ListView list =(ListView) this.findViewById(R.id.comments_list);
                list.setAdapter(adapter);
        }

        private ArrayList<Comment> _getData(Queue<Comment> comments)
        {
                ArrayList<Comment> cs = new ArrayList<Comment>();
                for (Comment comment: comments) {
                        cs.add(comment);
                }

                return cs;
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
                MenuInflater inflater = getMenuInflater();
                inflater.inflate(R.menu.option_menu, menu);

                /*ArrayList<String> autocomplete = new ArrayList<String>();

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
                textView.setAdapter(adapter);*/

                return super.onCreateOptionsMenu(menu);
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {

                // Handle item selection
                switch (item.getItemId()) {

                        case R.id.profile:
                                Intent b = new Intent(this,ProfileActivity.class);
                                startActivity(b);
                                Bundle extras = new Bundle();
                                extras.putString("username", NativeApp.getInstance().getLoggedName());
                                b.putExtras(extras);
                                return true;

                        case R.id.settings:
                                Intent b1 = new Intent(this,SettingsActivity.class);
                                startActivity(b1);
                                return true;

                        case R.id.add:
                                Intent b2 = new Intent(this,NotifyActivity.class);
                                startActivity(b2);
                                return true;

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
