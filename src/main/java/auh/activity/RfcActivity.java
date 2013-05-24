package auh.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import auh.adapter.CommentsAdapter;
import auh.domain.Comment;
import auh.domain.Rfc;
import auh.helper.NativeApp;
import it.auh.R;

import java.util.ArrayList;
import java.util.Queue;

public class RfcActivity extends Activity {

        @Override
        protected void onCreate(Bundle state){
                super.onCreate(state);

                this.setContentView(R.layout.rfc_activity);

                Integer rfcIndex = this.getIntent().getExtras().getInt("rfc_index");
                Rfc rfc = NativeApp.getInstance().getRfcs().get(rfcIndex);

                CommentsAdapter adapter = new CommentsAdapter(this, R.layout.comment_row, this._getData(rfc.getComments()));

                ImageView splash =(ImageView) this.findViewById(R.id.widget_splash);
                splash.setImageResource(rfc.getContent());

                ListView list =(ListView) this.findViewById(R.id.comments_list);
                list.setAdapter(adapter);
        }

        private ArrayList<Comment> _getData(Queue<Comment> comments)
        {
                ArrayList<Comment> cs = new ArrayList<Comment>();
                for (Comment comment: comments) {
                        cs.add(comment);
                }

                return cs;
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
