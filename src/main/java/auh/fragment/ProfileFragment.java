package auh.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import auh.activity.ProfileActivity;
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
                final AutoCompleteTextView textView = (AutoCompleteTextView)
                        this.view.findViewById(R.id.searchProfile);
                textView.setAdapter(adapter);
                textView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                        @Override
                        public void onFocusChange(View view, boolean b) {
                                textView.setText("");
                        }
                });
                textView.setOnKeyListener(new View.OnKeyListener() {
                        public boolean onKey(View v, int keyCode, KeyEvent event) {
                                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                                        (keyCode == KeyEvent.KEYCODE_ENTER))  {
                                        Intent intent = new Intent(activity,ProfileActivity.class);
                                        Bundle bundle = new Bundle();
                                        bundle.putString("username", textView.getText().toString());
                                        intent.putExtras(bundle);
                                        activity.startActivity(intent);
                                }
                                return true;
                        }
                });



        }

        public View getView(){
                return this.view;
        }

}
