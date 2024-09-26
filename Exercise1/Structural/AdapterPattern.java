
// Adapter Pattern
interface MediaPlayer {
    void play(String audioType, String fileName);
}

interface AdvancedMediaPlayer {
    void playMp3(String fileName);
    void playMp4(String fileName);
}

class Mp3Player implements AdvancedMediaPlayer {
    public void playMp3(String fileName) {
        System.out.println("Playing mp3 file. Name: " + fileName);
    }
    public void playMp4(String fileName) {
        // do nothing
    }
}

class MediaAdapter implements MediaPlayer {
    AdvancedMediaPlayer advancedMusicPlayer;

    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("mp3")) {
            advancedMusicPlayer = new Mp3Player();
        }
    }

    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3")) {
            advancedMusicPlayer.playMp3(fileName);
        }
    }
}

// Test the Adapter Pattern
public class AdapterPattern {
    public static void main(String[] args) {
        MediaPlayer player = new MediaAdapter("mp3");
        player.play("mp3", "song.mp3");
    }
}
