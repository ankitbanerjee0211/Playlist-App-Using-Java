import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String name;
    private String artist;
    private List<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setAlbum(List<Song> songs) {
        this.songs = songs;
    }

    // find song
    boolean findSong(String name){
        for(Song song: songs){
            if(song.getTitle().equals(name)){
                return true;
            }
        }

        return false;
    }

    // add song to album
    String addSongToAlbum(String title, double duration){
        if(!findSong(title)) {
            Song s = new Song(title, duration);
            songs.add(s);
            return "Song added to album";
        }

        return "Song already exists";
    }

    String addSongToPlaylistFromAlbum(String title, LinkedList<Song> playlist){
        if(findSong(title)){
            for(Song s: this.songs){
                if(s.getTitle().equals(title)){
                    playlist.add(s);
                    return "Song added to your playlist";
                }
            }
        }
        return "Song not present in this album";
    }

    String addSongToPlaylistFromAlbum(int trackNo, LinkedList<Song> playlist){
        int idx = trackNo-1;

        if(idx>=0 && idx<this.songs.size()){
            playlist.add(this.songs.get(idx));
            return "Song added to your playlist";
        }

        return "Invalid position of song";
    }
}
