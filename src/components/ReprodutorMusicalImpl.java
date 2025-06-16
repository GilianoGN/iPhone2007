package components;

import interfaces.ReprodutorMusical;
import models.Music;
import java.util.List;
import java.util.ArrayList;

public class ReprodutorMusicalImpl implements ReprodutorMusical {
    private Music musicaAtual;
    private boolean isPlaying;
    private List<Music> playlist;

    public ReprodutorMusicalImpl() {
        this.musicaAtual = null;
        this.isPlaying = false;
        this.playlist = new ArrayList<>();
        this.playlist.add(new Music("Hight Power", "Coldplay"));
        this.playlist.add(new Music("November Rain", "Guns N' Roses"));
        this.playlist.add(new Music("Callifornication", "Red Hot Chili Peppers"));
        this.playlist.add(new Music("The Cientist", "Coldplay"));
        this.playlist.add(new Music("Believer", "Imagine Dragons"));
    }

    @Override
    public void SelectMusic(String songName) {
        Music musicaEncontrada = playlist.stream()
                                         .filter(m -> m.getFullTitle().equalsIgnoreCase(songName))
                                         .findFirst()
                                         .orElse(null);
        if (musicaEncontrada != null) {
            this.musicaAtual = musicaEncontrada;
            this.isPlaying = false;
            System.out.println("Selected music: " + musicaAtual.getFullTitle());
        } else {
            System.out.println("Song '" + songName + "' not found. Please try again.");
            this.musicaAtual = null;
        }
    }

    @Override
    public void playMusic(String songName) {
        if (songName == null || songName.isEmpty()) {
            System.out.println("No music to play. Please select one first.");
            return;
        }
        Music musicaParaTocar = playlist.stream()
                                        .filter(m -> m.getFullTitle().equalsIgnoreCase(songName))
                                        .findFirst()
                                        .orElse(null);

        if (musicaParaTocar != null) {
            this.musicaAtual = musicaParaTocar;
            this.isPlaying = true;
            System.out.println("Playing: " + musicaAtual.getFullTitle());
        } else {
            System.out.println("Song '" + songName + "' not found in playlist.");
            this.musicaAtual = null;
            this.isPlaying = false;
        }
    }

    @Override
    public String pauseMusic() {
        if (isPlaying) {
            isPlaying = false;
            return ("Music paused: " + (musicaAtual != null ? musicaAtual.getFullTitle() : ""));
        } else {
            return "No music is playing to pause.";
        }
    }

    @Override
    public String stopMusic() {
        if (isPlaying || musicaAtual != null) {
            isPlaying = false;
            musicaAtual = null; 
            return "Stopped music playback.";
        } else {
            return "No music is playing or selected to stop.";
        }
    }

    @Override
    public String nextSong() {
        if (playlist.isEmpty()) {
            return "Empty playlist.";
        }
        int currentIndex = (musicaAtual != null) ? playlist.indexOf(musicaAtual) : -1;
        if (currentIndex != -1 && currentIndex < playlist.size() - 1) {
            SelectMusic(playlist.get(currentIndex + 1).getFullTitle()); 
            playMusic(playlist.get(currentIndex + 1).getFullTitle()); 
            return "";
        } else {
            SelectMusic(playlist.get(0).getFullTitle()); 
            playMusic(playlist.get(0).getFullTitle());
            return "End of playlist, going back to the beginning.";
        }
    }

    @Override
    public String previousSong() {
        if (playlist.isEmpty()) {
            return "Empty playlist.";
        }
        int currentIndex = (musicaAtual != null) ? playlist.indexOf(musicaAtual) : -1;
        if (currentIndex > 0) {
            SelectMusic(playlist.get(currentIndex - 1).getFullTitle()); 
            playMusic(playlist.get(currentIndex - 1).getFullTitle()); 
            return "";
        } else {
            SelectMusic(playlist.get(playlist.size() - 1).getFullTitle()); 
            playMusic(playlist.get(playlist.size() - 1).getFullTitle());
            return "Start of playlist, looping to end.";
        }
    }

    @Override
    public String getCurrentSong() {
        if (musicaAtual == null) {
            return "No music selected.";
        }
        return musicaAtual.getFullTitle() + (isPlaying ? " (Playing)" : " (Paused)");
    }

    public List<Music> getPlaylist() {
        return playlist;
    }
}