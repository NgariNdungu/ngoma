package ke.co.openmaps.createchs.ngoma;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {

    public static final String DIVIDER = "|";

    public SongAdapter(Context context, ArrayList<Song> songs) {
        super(context, 0, songs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.song_list_item, parent, false);
        }
        TextView songTitle = (TextView) convertView.findViewById(R.id.song_title);
        TextView artist = (TextView) convertView.findViewById(R.id.song_artist);

        // song in current position
        Song currentSong = getItem(position);
        songTitle.setText(currentSong.getSongTitle());
        artist.setText(String.format("%s %s %s", currentSong.getArtist(), DIVIDER,
                currentSong.getAlbum()));
        // set selected state to enable marquee
        artist.setSelected(true);

        return convertView;
    }
}
