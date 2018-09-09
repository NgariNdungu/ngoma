package ke.co.openmaps.createchs.ngoma;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import ke.co.openmaps.createchs.ngoma.R;

public class MusicCursorAdapter extends CursorAdapter {
    public MusicCursorAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }

/*
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }
*/

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.song_list_item, parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView songTitleTextView = (TextView) view.findViewById(R.id.song_title);
        TextView artistTextView = (TextView) view.findViewById(R.id.song_artist);
        ImageView albumArtImage = (ImageView) view.findViewById(R.id.album_art);

        String title = cursor.getString(cursor.getColumnIndex("TITLE"));
        String artist = cursor.getString(cursor.getColumnIndex("ARTIST"));

        songTitleTextView.setText(title);
        artistTextView.setText(artist);
    }
}
