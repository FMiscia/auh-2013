package auh.fragment;

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
import auh.helper.AccountHelper;
import auh.helper.NativeApp;
import it.auh.R;

public class LoginFragment extends Fragment {

        private View view;

        private TextView user;

        public LoginFragment(final LayoutInflater inflater, final ViewGroup group, final Activity activity){
                super();

                this.view = inflater.inflate(R.layout.login_panel, group, true);

                ImageButton googleButton =(ImageButton) view.findViewById(R.id.googleConnect);
                ImageButton facebookButton =(ImageButton) view.findViewById(R.id.facebookConnect);

                final AccountHelper account = new AccountHelper(activity.getApplicationContext());

                final String gname = account.getGname();
                final String fname = account.getFBname();

                googleButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                                Intent i = new Intent(activity, StreamActivity.class);
                                Bundle extras = new Bundle();
                                extras.putString("username", gname);
                                i.putExtras(extras);
                                NativeApp.getInstance().setLoggedName(gname);
                                activity.startActivity(i);
                        }
                });

                facebookButton.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {
                                Intent i= new Intent(activity, StreamActivity.class);
                                Bundle extras = new Bundle();
                                extras.putString("username", fname);
                                i.putExtras(extras);
                                NativeApp.getInstance().setLoggedName(fname);
                                activity.startActivity(i);
                        }
                });
        }

        @Override
        public View getView(){
                return this.view;
        }


}
