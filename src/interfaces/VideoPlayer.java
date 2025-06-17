package interfaces;

import java.util.List;

import models.Video;

public interface VideoPlayer {
    //Comportamento esperado
    void SelectVideo(String videoName);
    void playVideo(String videoName);
    String pauseVideo();
    String stopVideo();
    String nextVideo();
    String previousVideo();

    // Métodos para verificar
    String getCurrentVideo();
    List<Video> getPlaylist();
}