package device;

import components.ReprodutorMusicalImpl;
import components.AparelhoTelefonicoImpl;
import components.NavegadorInternetImpl;
import components.VideoPlayerImpl;

import interfaces.ReprodutorMusical;
import interfaces.AparelhoTelefonico;
import interfaces.NavegadorInternet;
import interfaces.VideoPlayer;

public class iPhone {
    private ReprodutorMusicalImpl reprodutorMusical;
    private AparelhoTelefonicoImpl aparelhoTelefonico;
    private NavegadorInternetImpl navegadorInternet;
    private VideoPlayerImpl videoPlayer;

    public iPhone() {
        this.reprodutorMusical = new ReprodutorMusicalImpl();
        this.aparelhoTelefonico = new AparelhoTelefonicoImpl();
        this.navegadorInternet = new NavegadorInternetImpl();
        this.videoPlayer = new VideoPlayerImpl();
        System.out.println("iPhone initialized with all components.");
    }

    public ReprodutorMusical getReprodutorMusical() {
        return reprodutorMusical;
    }
    public AparelhoTelefonico getAparelhoTelefonico() {
        return aparelhoTelefonico;
    }
    public NavegadorInternet getNavegadorInternet() {
        return navegadorInternet;
    }
    public VideoPlayer getVideoPlayer() {
        return videoPlayer;
    }
}