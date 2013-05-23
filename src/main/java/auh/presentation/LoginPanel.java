package auh.presentation;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import it.auh.R;

public class LoginPanel extends Fragment {

        private View view;

        private TextView user;

        public LoginPanel(final LayoutInflater inflater, final ViewGroup group, final Activity activity){
                super();

                this.view = inflater.inflate(R.layout.login_panel, group, true);

                ImageButton googleButton =(ImageButton) view.findViewById(R.id.googleConnect);
                ImageButton facebookButton =(ImageButton) view.findViewById(R.id.facebookConnect);

                googleButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public
                        void onClick(View v)
                        {
                                View view = LayoutInflater.from(activity).inflate(R.layout.stream_panel, null);

                                activity.setContentView(view);
                                //inflater.inflate(R.id.stream, (RelativeLayout) LoginPanel.this.view, true);
                        }
                });
        }

        public View getView(){
                return this.view;
        }


}
