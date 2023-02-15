import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Album album1 = new Album("Bohemian Rhapsody", "Queen");
        album1.addSongToAlbum("Bohemian Rhapsody", 6.2);
        album1.addSongToAlbum("I Want to Break Free", 6.2);
        album1.addSongToAlbum("Supersonic", 6.2);

        Album album2 = new Album("End of the World", "Queen");
        album2.addSongToAlbum("Blue Bird", 6.2);
        album2.addSongToAlbum("Faded", 6.2);
        album2.addSongToAlbum("Champion", 6.2);

        LinkedList<Song> myPlaylist = new LinkedList<>();
        System.out.println(album1.addSongToPlaylistFromAlbum("Supersonic", myPlaylist));
        System.out.println(album2.addSongToPlaylistFromAlbum("Faded", myPlaylist));
        System.out.println(album2.addSongToPlaylistFromAlbum("Blue Bird", myPlaylist));

        play(myPlaylist);
    }

    private static void printMenu(){
        System.out.println("""
                OPTIONS
                ----------------------------------
                Press 1 -> Play next song
                Press 2 -> Play previous song
                Press 3 -> Play current song again
                Press 4 -> Delete current song
                Press 5 -> Show all songs
                Press 6 -> Show menu
                Press 7 -> Exit
                ----------------------------------
                
                """);
    }

    public static void play(LinkedList<Song> playlist){

        ListIterator<Song> itr = playlist.listIterator();

        if(playlist.size() == 0){
            System.out.println("Playlist is empty");
            return;
        }

        boolean isNext;

        System.out.print("Currently playing: ");
        System.out.println(itr.next().getTitle());
        isNext = true;

        Scanner in = new Scanner(System.in);

        printMenu();
        while(true){
            System.out.print("Enter your choice: ");
            int choice = in.nextInt();

            switch(choice){
                case 1:
                    if(!isNext){
                        itr.next();
                        isNext = true;
                    }
                    if(itr.hasNext()){
                        System.out.println("Now playing: " + itr.next());
                        isNext = true;
                    }
                    else System.out.println("You have reached the end of the playlist.");
                    break;
                case 2:
                    if(isNext){
                        itr.previous();
                        isNext = false;
                    }
                    if(itr.hasPrevious()){
                        System.out.println("Now playing: " + itr.previous());
                        isNext = false;
                    }
                    else System.out.println("You have reached the start of the playlist.");
                    break;
                case 3:
                    if(!isNext){
                        System.out.println("Now playing: " + itr.next());
                        isNext = true;
                    } else {
                        System.out.println("Now playing: " + itr.previous());
                        isNext = false;
                    }
                    break;
                case 4:
                    itr.remove();
                    System.out.println("Song has been deleted successfully");
                    break;
                case 5: printSongs(playlist);
                    break;
                case 6: // print menu
                    printMenu();
                    break;
                case 7: return; // exit
            }
        }

    }

    private static void printSongs(LinkedList<Song> playlist){
        for(Song s: playlist){
            System.out.println(s);
        }
        return;
    }

}