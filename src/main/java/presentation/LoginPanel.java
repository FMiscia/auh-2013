package presentation;

import android.app.Fragment;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import helper.GAccount;
import it.auh.R;

/**
 * Created by francesco on 22/05/13.
 */
public class LoginPanel extends Fragment {

        private View view;

        private TextView user;

        public LoginPanel(LayoutInflater inflater, ViewGroup group){
                super();
                this.view = inflater.inflate(R.layout.login_panel, group, true);
                user = (TextView)view.findViewById(R.id.user);
                GAccount account = new GAccount(this.view.getContext());
                user.setText(account.getUsername());

        }

        public View getView(){
                return this.view;
        }


}
