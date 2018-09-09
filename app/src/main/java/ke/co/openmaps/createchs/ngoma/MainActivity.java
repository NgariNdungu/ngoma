package ke.co.openmaps.createchs.ngoma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    public static final String CURRENT_SONG = "current_song";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // song list
        final ArrayList<Song> songArrayList = new ArrayList<>(Arrays.asList(
                new Song("Paradise", "Coldplay", "unknown"),
                new Song("Welcome To New York", "Taylor Swift", "1989"),
                new Song("How You Get the Girl", "Taylor Swift", "1989"),
                new Song("BLOOD", "Kendrick Lamar", "DAMN"),
                new Song("DNA", "Kendrick Lamar", "DAMN"),
                new Song("HUMBLE", "Kendrick Lamar", "DAMN"),
                new Song("SuperHeroes", "The Script", "No Sound Without Silence"),
                new Song("It's Not Right For You", "The Script",
                        "No Sound Without Silence"),
                new Song("The Phoenix", "Fall Out Boy", "Save Rock and Roll"),
                new Song("Young Volcanoes", "Fall Out Boy", "Save Rock and Roll"),
                new Song("Shape of You", "Ed Sheeran", "Divide"),
                new Song("Nancy Mulligan", "Ed Sheeran", "Divide")
        ));

        final SongAdapter songAdapter = new SongAdapter(this, songArrayList);

        // get parent list view
        ListView songList = (ListView) findViewById(R.id.song_list);

        final Intent currentSongIntent = new Intent(this, CurrentSong.class);
        songList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                currentSongIntent.putExtra(CURRENT_SONG, songAdapter.getItem(position).getFields());
                startActivity(currentSongIntent);
            }
        });
        // attach adapter
        songList.setAdapter(songAdapter);
    }
}
