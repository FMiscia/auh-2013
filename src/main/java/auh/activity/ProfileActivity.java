package auh.activity;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;
import auh.fragment.LoginFragment;
import auh.fragment.ProfileFragment;
import auh.helper.NativeApp;
import it.auh.R;

import java.util.ArrayList;

/**
 * Created by francesco on 23/05/13.
 */
public class ProfileActivity extends Activity {


        private Fragment profilePanel;

        @Override
        protected
        void onCreate(Bundle state){
                super.onCreate(state);

                LayoutInflater inflater =(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                this.profilePanel= new ProfileFragment(inflater, (LinearLayout) this.findViewById(R.layout.profile_activity), this);

                this.setContentView(this.profilePanel.getView());


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
