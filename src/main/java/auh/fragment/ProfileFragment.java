package auh.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import auh.helper.NativeApp;
import it.auh.R;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {

        private View view;
        private ArrayList<String> autocomplete = new ArrayList<String>();
        private TextView username;

        public ProfileFragment(final LayoutInflater inflater, final ViewGroup group, final Activity activity){

                super();


                for(int i=0;i< NativeApp.getInstance().getUsers().size();i++){
                        autocomplete.add(NativeApp.getInstance().getUsers().get(i).getName());
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(activity,
                        android.R.layout.simple_dropdown_item_1line, this.autocomplete);
                AutoCompleteTextView textView = (AutoCompleteTextView)
                        this.view.findViewById(R.id.searchProfile);
                textView.setAdapter(adapter);


        }

        public View getView(){
                return this.view;
        }

}
