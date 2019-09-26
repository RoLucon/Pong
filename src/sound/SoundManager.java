package sound;

import javax.sound.sampled.*;
import java.io.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class SoundManager {
    private Media trackS;
    private static Clip collision, score, select;

    public SoundManager() {
        try {
            File file = new File("src\\res\\collision.wav");
            AudioInputStream sound = AudioSystem.getAudioInputStream(file);
            collision = AudioSystem.getClip();
            collision.open(sound);
            file = new File("src\\res\\score.wav");
            sound = AudioSystem.getAudioInputStream(file);
            score = AudioSystem.getClip();
            score.open(sound);
            file = new File("src\\res\\select.wav");
            sound = AudioSystem.getAudioInputStream(file);
            select = AudioSystem.getClip();
            select.open(sound);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }

    }

    public static void playCollision(){
        collision.setFramePosition(0);
        collision.start();
    }

    public static void playScore(){
        score.setFramePosition(0);
        score.start();
    }

    public static void playSelect(){
        select.setFramePosition(0);
        select.start();
    }

}
//LINK SOUNDS CREDITS
//https://freesound.org/people/jeckkech/sounds/391663/
//https://freesound.org/people/LittleRobotSoundFactory/sounds/270303/
//https://freesound.org/people/NoiseCollector/sounds/4359/