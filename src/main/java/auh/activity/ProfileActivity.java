package auh.activity;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
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

                String n = NativeApp.getInstance().getLoggedName();
                try{
                        String s = this.getIntent().getExtras().getString("username");
                        n = s;
                }catch (NullPointerException ex){
                }
                //

                final String name = n;

                ArrayList<User> users = NativeApp.getInstance().getUsers();
                User user = new User(null,null,null);

                for(int i=0,l=users.size(); i<l; i++)
                        if(users.get(i).getName().equals(name))
                                user = users.get(i);

                /*debugging*/
                if(user.getName()==null)
                        user = users.get(0);

                LayoutInflater inflater =(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                ScrollView profileView =(ScrollView) inflater.inflate(R.layout.profile_activity, null, true);

                TextView username =(TextView) profileView.findViewById(R.id.username);
                username.setText(NativeApp.getInstance().getLoggedName());

                ImageView img = (ImageView) profileView.findViewById(R.id.profile_photo);
                LinearLayout profileLayout =(LinearLayout) profileView.findViewById(R.id.profile_layout);
                TextView Name = (TextView) profileView.findViewById(R.id.username);
                Name.setText(name);
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

                        if ( name.equals("fra.miscia@gmail.com") || name.equals("francesco.miscia.14")) {
                                checkBox =(CheckBox) profileEntry.findViewById(R.id.checkBox);
                                checkBox.setVisibility(View.INVISIBLE);

                        }else
                        {
                                checkBox =(CheckBox) profileEntry.findViewById(R.id.checkBox);
                                checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                        @Override
                                        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                                                if(b)
                                                        Toast.makeText(getApplicationContext(),"You have skilled "+name+" !",Toast.LENGTH_LONG).show();
                                                else
                                                        Toast.makeText(getApplicationContext(),"You have unskilled "+name+" !",Toast.LENGTH_LONG).show();
                                        }
                                });
                                int imageResource = getResources().getIdentifier("drawable/"+user.getPhoto(), null, getPackageName());
                                img.setImageResource(imageResource);

                        }

                        profileLayout.addView(profileEntry);
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
