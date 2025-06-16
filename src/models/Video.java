package models;

public record Video(String title, String director) {
    public String getFullTitle() {
        return title + " by " + director;
    }
}