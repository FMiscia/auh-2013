package auh.presentation;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import auh.activity.StreamActivity;
import auh.helper.GAccount;
import it.auh.R;

public class LoginPanel extends Fragment {

        private View view;

        private TextView user;

        public LoginPanel(final LayoutInflater inflater, final ViewGroup group, final Activity activity){
                super();

                this.view = inflater.inflate(R.layout.login_panel, group, true);

                ImageButton googleButton =(ImageButton) view.findViewById(R.id.googleConnect);
                ImageButton facebookButton =(ImageButton) view.findViewById(R.id.facebookConnect);

                final GAccount account = new GAccount(activity.getApplicationContext());

                final String gname = account.getGname();
                final String fname = account.getFBname();

                googleButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                                Intent i = new Intent(activity, StreamActivity.class);
                                Bundle extras = new Bundle();
                                extras.putString("username", gname);
                                i.putExtras(extras);
                                activity.startActivity(i);
                        }
                });

                facebookButton.setOnClickListener(new View.OnClickListener(){

                        @Override
                        public void onClick(View view) {
                                Intent i= new Intent(activity, StreamActivity.class);
                                Bundle extras = new Bundle();
                                extras.putString("username", fname);
                                i.putExtras(extras);
                                activity.startActivity(i);
                        }
                });
        }

        public View getView(){
                return this.view;
        }


}
