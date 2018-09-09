package ke.co.openmaps.createchs.ngoma;

import android.Manifest;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView songList = (ListView) findViewById(R.id.song_list);

        final Intent currentSongIntent = new Intent(this, CurrentSong.class);
        songList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("MainActivity", "Clicked on " + position);
                startActivity(currentSongIntent);
            }
        });

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED) {
            // Retrieve list of media files on device
            Uri mediaUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            // Columns to retrieve
            String[] mediaColumns = {
                    "_ID",
                    "TITLE",
                    "ARTIST",
                    "ALBUM"
                    // "DATA"
            };
            Cursor musicCursor = getContentResolver().query(
                    mediaUri,
                    mediaColumns,
                    null,
                    null,
                    "ARTIST"
            );
            MusicCursorAdapter adapter = new MusicCursorAdapter(this, musicCursor);
            songList.setAdapter(adapter);

        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    777);
        }

    }
}
