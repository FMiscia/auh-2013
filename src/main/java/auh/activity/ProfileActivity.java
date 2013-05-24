package auh.activity;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import auh.domain.User;
import auh.fragment.ProfileFragment;
import auh.helper.NativeApp;
import auh.helper.Skill;

import it.auh.R;

import java.util.ArrayList;

public class ProfileActivity extends Activity {
        private Fragment profilePanel;

        @Override
        protected
        void onCreate(Bundle state){
                super.onCreate(state);

                User user = NativeApp.getInstance().getUsers().get(0);

                LayoutInflater inflater =(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                this.profilePanel = new ProfileFragment(inflater, null, this);

                LinearLayout profileView =(LinearLayout) this.profilePanel.getView();
                RelativeLayout profileEntry;
                TextView textView;
                ProgressBar progressBar;
                CheckBox checkBox;

                for (String skill: Skill.skills) {
                        profileEntry =(RelativeLayout) inflater.inflate(R.layout.profile_entry, null);

                        textView =(TextView) profileEntry.findViewById(R.id.textView);
                        textView.setText(skill);

                        progressBar =(ProgressBar) profileEntry.findViewById(R.id.progressBar);
                        Double rank =(Double) Skill.getWeightedScore(user.getSkill().get(skill)) * 10;
                        progressBar.setProgress(rank.intValue());

                        if ((! user.getName().equals("fra.miscia@gmail.com")) && (! user.getName().equals("francesco.miscia.14"))) {
                                checkBox =(CheckBox) profileEntry.findViewById(R.id.checkBox);
                                checkBox.setVisibility(View.INVISIBLE);
                        }

                        profileView.addView(profileEntry);
                }

                this.setContentView(profileView);
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
                                        Intent intent = new Intent(ProfileActivity.this,ProfileActivity.class);
                                        Bundle bundle = new Bundle();
                                        bundle.putString("username", textView.getText().toString());
                                        intent.putExtras(bundle);
                                        ProfileActivity.this.startActivity(intent);
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

                        case R.id.settings:
                                Intent b1 = new Intent(this,SettingsActivity.class);
                                startActivity(b1);

                        case R.id.add:
                                Intent b2 = new Intent(this,NotifyActivity.class);
                                startActivity(b2);

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
