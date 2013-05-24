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
        private View profilePanel;

        @Override
        protected
        void onCreate(Bundle state){
                super.onCreate(state);

                User user = NativeApp.getInstance().getUsers().get(0);

                LayoutInflater inflater =(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                LinearLayout profileView =(LinearLayout) inflater.inflate(R.layout.profile_activity, null, true);

                TextView username =(TextView) profileView.findViewById(R.id.username);
                username.setText(NativeApp.getInstance().getLoggedName());

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
