package models;

public record Music(String title, String artist) {
    public String getFullTitle() {
        return title + " by " + artist;
    }
}