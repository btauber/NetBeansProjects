package mediaplayer;

import java.util.ArrayList;
import java.util.Collections;

public class MediaPlayer {

    protected ArrayList<MyMusic> musicContainer = new ArrayList<>();

    public void addMusic(){//String songName,String artist,String album) {
        MyMusic song = new MyMusic("KOL SOSEN", "MBD", "SHALSHELES");
        MyMusic song1 = new MyMusic("AL NAHOROS", "MBb", "ZEMIROIS");
        musicContainer.add(song);
        musicContainer.add(song1);
        Collections.sort(musicContainer);
        for(MyMusic m:musicContainer)
            System.out.println(m);
    }

    public void play(MyMusic song) {
        System.out.println("now playing " + song);
    }

    public String search(String search) {
        for (MyMusic song : musicContainer) {
            if (song.getSongName().equalsIgnoreCase(search)
                    || song.getArtist().equalsIgnoreCase(search)
                    || song.getAlbum().equalsIgnoreCase(search)) {
                return song.toString();
            }
        }
        return "Sorry the Media Player did not find your song";
    }
    
    public void DeleteMusic(MyMusic music)
    {
        musicContainer.remove(music);
    }
}
