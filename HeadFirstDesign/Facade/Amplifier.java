package HeadFirstDesign.Facade;

public class Amplifier {
    StreamingPlayer streamingPlayer;
    boolean surroundSound;
    int volume;

    public void on() {
    }

    public void setStreamingPlayer(StreamingPlayer streamingPlayer) {
        this.streamingPlayer = streamingPlayer;
        this.surroundSound = false;
        this.volume = 0;
    }

    public void setSurroundSound() {
        surroundSound = true;
    }

    public void setVolume(int i) {
        volume = i;
    }
}
