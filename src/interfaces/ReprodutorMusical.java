package interfaces;

import java.util.List;

import models.Music;

public interface ReprodutorMusical {
    //Comportamento esperado
    void SelectMusic(String songName);
    void playMusic(String songName);
    String pauseMusic();
    String stopMusic();
    String nextSong();
    String previousSong();

    //Métodos para verificar
    String getCurrentSong();
    List<Music> getPlaylist();
}