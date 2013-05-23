package auh.adapter;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import it.auh.R;

public class StreamAdapter extends BaseAdapter {

        private
        Activity activity;

        private
        ArrayList<HashMap<String, String>> data;

        private static
        LayoutInflater inflater = null;

        public StreamAdapter(Activity a, ArrayList<HashMap<String, String>> d)
        {
                this.activity = a;
                this.data=d;
                this.inflater =(LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
                return data.size();
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
                        vi = inflater.inflate(R.layout.list_row, null);
                }

                TextView title =(TextView) vi.findViewById(R.id.title);
                TextView artist =(TextView) vi.findViewById(R.id.artist);
                TextView duration =(TextView) vi.findViewById(R.id.duration);

                title.setText("titolo");
                artist.setText("artista");
                duration.setText("durata");

                return vi;
        }
}
