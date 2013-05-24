package auh.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import auh.domain.Comment;
import it.auh.R;

import java.util.ArrayList;

public class CommentsAdapter extends ArrayAdapter<Comment>
{

        Activity _activity;
        LayoutInflater _inflater;
        int _layout;

        ArrayList<Comment> _data;

        public CommentsAdapter(Activity activity, int layout, ArrayList<Comment> data) {
                super(activity, layout, data);

                this._activity = activity;
                this._inflater =(LayoutInflater) this._activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                this._layout = layout;
                this._data = data;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
                View vi = convertView;
                if (convertView == null) {
                        vi = this._inflater.inflate(R.layout.comment_row, null);
                }

                TextView title =(TextView) vi.findViewById(R.id.content);
                title.setText(this._data.get(position).getContent());

                return vi;
        }
}
