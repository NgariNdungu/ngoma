package ke.co.openmaps.createchs.ngoma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CurrentSong extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_song);

        // get current song details from intent
        String[] songDetails = getIntent().getStringArrayExtra(MainActivity.CURRENT_SONG);

        // get text views
        TextView song = (TextView) findViewById(R.id.playing_song_title);
        TextView album = (TextView) findViewById(R.id.playing_album);
        TextView artist = (TextView) findViewById(R.id.playing_artist);

        // set values
        song.setText(songDetails[0]);
        artist.setText(songDetails[1]);
        album.setText(songDetails[2]);

    }
}
