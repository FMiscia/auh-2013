package auh.adapter;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import it.auh.R;

public class StreamAdapter extends BaseAdapter {

        private
        Activity _activity;

        private
        ArrayList<String> _data;

        private static
        LayoutInflater _inflater = null;

        public StreamAdapter(Activity activity, ArrayList<String> data)
        {
                this._activity = activity;
                this._data = data;
                this._inflater =(LayoutInflater) _activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
                return _data.size();
        }

        @Override
        public Object getItem(int position) {
                return position;
        }

        @Override
        public long getItemId(int position) {
                return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
                View vi = convertView;
                if (convertView == null) {
                        vi = this._inflater.inflate(R.layout.list_row, null);
                }

                TextView title =(TextView) vi.findViewById(R.id.title);

                title.setText(this._data.get(position));

                return vi;
        }
}
