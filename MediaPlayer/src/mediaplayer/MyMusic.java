package mediaplayer;

public class MyMusic implements Comparable {
    private String songName;
    private String artist;
    private String album;
    private int rate = 0;
    
    public MyMusic(String songName,String artist,String album)
    {
        this.songName = songName;
        this.artist = artist;
        this.album = album;
    }
    
    public String getSongName() {
        return songName;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }
    public String toString()
    {
        return "Song name: "+songName+" Artist: "+artist+" Album: "+album+" Rate "+rate;
    }

    @Override
    public int compareTo(Object object) 
    {   
        MyMusic music =(MyMusic)object;
        String song = music.getSongName();
        
        int len1 = song.length();
        
        int len2 = getSongName().length();
        int lim = Math.min(len1, len2);
        char v1[] = getSongName().toCharArray();
        char v2[] = song.toCharArray();

        int k = 0;
        while (k < lim) {
            char c1 = v1[k];
            char c2 = v2[k];
            if (c1 != c2) {
                return c1 - c2;
            }
            k++;
        }
        return len1 - len2;
    }

    public int getRate() {
        return rate;
    }

    public void setRate() {
        this.rate++;
    }
}
