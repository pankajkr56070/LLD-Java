package HeadFirstDesign.Facade;

public class HomeTheatreFacade {

    Amplifier amplifier;
    Tuner tuner;
    StreamingPlayer streamingPlayer;
    Projector projector;
    TheatreLights theatreLights;
    Screen screen;
    PopcornPopper popcornPopper;

    public HomeTheatreFacade(Amplifier amplifier, PopcornPopper popcornPopper, Projector projector,
                             Screen screen, StreamingPlayer streamingPlayer, TheatreLights theatreLights,
                             Tuner tuner) {
        this.amplifier = amplifier;
        this.popcornPopper = popcornPopper;
        this.projector = projector;
        this.screen = screen;
        this.streamingPlayer = streamingPlayer;
        this.theatreLights = theatreLights;
        this.tuner = tuner;
    }


    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        popcornPopper.on();
        popcornPopper.pop();
        theatreLights.dim(10);
        screen.down();
        projector.on();
        projector.wideScreenMode();
        amplifier.on();
        amplifier.setStreamingPlayer(streamingPlayer);
        amplifier.setSurroundSound();
        amplifier.setVolume(5);
        streamingPlayer.on();
        streamingPlayer.play(movie);
    }
}
