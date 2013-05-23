package presentation;

import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import it.auh.R;

/**
 * Created by francesco on 23/05/13.
 */
public class WelcomePanel extends Fragment {

        private View view;

        public WelcomePanel(LayoutInflater inflater, ViewGroup group){
                super();
                this.view = inflater.inflate(R.layout.welcome_panel,group,true);

        }


}
