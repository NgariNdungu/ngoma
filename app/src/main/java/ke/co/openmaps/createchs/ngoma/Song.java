package ke.co.openmaps.createchs.ngoma;


public class Song {
    private String mSongTitle;
    private String mArtist;
    private String mAlbum;

    public Song(String songTitle, String artist, String album) {
        this.mSongTitle = songTitle;
        this.mArtist = artist;
        this.mAlbum = album;
    }

    public String getSongTitle() {
        return mSongTitle;
    }

    public String getArtist() {
        return mArtist;
    }

    public String getAlbum() {
        return mAlbum;
    }

    public String[] getFields() {
        String[] fields = {
                mSongTitle,
                mArtist,
                mAlbum
        };
        return fields;
    }
}
