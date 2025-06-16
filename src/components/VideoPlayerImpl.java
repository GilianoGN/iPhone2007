package components;

import interfaces.VideoPlayer;
import models.Music;
import models.Video;

import java.util.List;
import java.util.ArrayList;

public class VideoPlayerImpl implements VideoPlayer {
    private Video currentVideo;
    private boolean isPlaying;
    private List<Video> videoPlaylist;

    public VideoPlayerImpl() {
        this.currentVideo = null;
        this.isPlaying = false;
        this.videoPlaylist = new ArrayList<>();
        this.videoPlaylist.add(new Video("Pirates of the Caribbean", "Espen Sandberg"));
        this.videoPlaylist.add(new Video("The Lord of the Rings", "Peter Jackson"));
        this.videoPlaylist.add(new Video("Matrix", "Lana Wachowski"));
        this.videoPlaylist.add(new Video("Star Wars", "George Lucas"));
        this.videoPlaylist.add(new Video("Harry Potter", "Chris Columbus"));
    }

    @Override
    public void SelectVideo(String videoName) {
        Video videoEncontrada = videoPlaylist.stream()
                                         .filter(m -> m.getFullTitle().equalsIgnoreCase(videoName))
                                         .findFirst()
                                         .orElse(null);
        if (videoEncontrada != null) {
            this.currentVideo = videoEncontrada;
            this.isPlaying = false;
            System.out.println("Selected video: " + currentVideo.getFullTitle());
        } else {
            System.out.println("Video '" + videoName + "' not found. Please try again.");
            this.currentVideo = null;
        }
    }

    @Override
    public void playVideo(String videoName) {
        if (videoName == null || videoName.isEmpty()) {
            System.out.println("Invalid video name.");
            return;
        }
        Video videoParaPlay = videoPlaylist.stream()
                                        .filter(m -> m.getFullTitle().equalsIgnoreCase(videoName))
                                        .findFirst()
                                        .orElse(null);
        if (videoPlaylist.contains(videoName)) {
            currentVideo = videoParaPlay;
            isPlaying = true;
            System.out.println("Playing video: " + videoName);
        } else {
            System.out.println("Video "+ videoName +" not found in playlist.");
        }
    }

    @Override
    public String pauseVideo() {
        if (isPlaying) {
            isPlaying = false;
            return "Video paused: " + currentVideo;
        } else {
            return "No video is currently playing.";
        }
    }

    @Override
    public String stopVideo() {
        if (isPlaying || !currentVideo.equals("No video is selected.")) {
            isPlaying = false;
            currentVideo = null;
            return "Video stopped.";
        } else {
            return "No video is currently playing.";
        }
    }

    @Override
    public String nextVideo() {
        if (videoPlaylist.isEmpty()) {
            return "Empty playlist";
        }
        int currentIndex = videoPlaylist.indexOf(currentVideo);
        if (currentIndex != -1 && currentIndex < videoPlaylist.size() - 1) {
            playVideo(videoPlaylist.get(currentIndex + 1).getFullTitle());
            return "";
        } else {
            playVideo(videoPlaylist.get(0).getFullTitle());
            return "End of playlist, going back to the beginning.";
        }
    }

    @Override
    public String previousVideo() {
        if (videoPlaylist.isEmpty()) {
            return "Empty playlist.";
        }
        int currentIndex = videoPlaylist.indexOf(currentVideo);
        if (currentIndex > 0) {
            playVideo(videoPlaylist.get(currentIndex - 1).getFullTitle());
            return "";
        } else {
            playVideo(videoPlaylist.get(videoPlaylist.size() - 1).getFullTitle()); // Vai para o último
            return "Start of playlist, looping to end.";
        }
    }

    @Override
    public String getCurrentVideo() {
        return currentVideo + (isPlaying ? " (Playing)" : " (Paused/Stopped)");
    }

    public List<Video> getPlaylist() {
        return videoPlaylist;
    }
}