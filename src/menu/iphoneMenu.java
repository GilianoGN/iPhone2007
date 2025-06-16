package menu;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;

import models.Music;
import models.Video;
import models.Contact;
import models.WebPage;
import device.iPhone;

public class iphoneMenu {
    private static final Scanner scanner = new Scanner(System.in);
    private static iPhone iphoneInstance;
    private static String Alerta = "";
    //Método para limpar a tela do console
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void setIphoneInstance(iPhone iphone) {
        iphoneInstance = iphone;
    }

    public static void displayMusicMenu() {
        if (iphoneInstance == null) {
            Alerta = "iPhone instance is not set. Please set it before displaying the menu.";
            return;
        }
        int option = 0;
        do {
            clearScreen();
            System.out.println("================================================");
            System.out.println("Welcome to the Music Menu");
            System.out.println("================================================");
            System.out.println("Please select an option:");
            System.out.println("1  -  Search Music");
            System.out.println("2  -  Play Music");
            System.out.println("3  -  Pause Music");
            System.out.println("4  -  Stop Music");
            System.out.println("5  -  Next Song");
            System.out.println("6  -  Previous Song");
            System.out.println("7  -  Back to Main Menu");
            System.out.println("================================================");
            System.out.println("Status: " + iphoneInstance.getReprodutorMusical().getCurrentSong());
            System.out.println("Alert: " + Alerta);
            System.out.println("================================================");
            Alerta = "";
            try {
                option = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                Alerta = "Invalid input. Please enter a number between 1 and 7.";
                scanner.nextLine();
                continue;
            }
            switch (option) {
                case 1 -> {
                    List<Music> playlist = iphoneInstance.getReprodutorMusical().getPlaylist(); // Pega a playlist
                    if (playlist.isEmpty()) {
                        Alerta = "No songs available in playlist.";
                        break;
                    }
                    System.out.println("================================================");
                    System.out.println("music available:");
                    for (int i = 0; i < playlist.size(); i++) {
                        System.out.println((i + 1) + " - " + playlist.get(i).getFullTitle());
                    }
                    System.out.println("================================================");
                    System.out.print("Enter the number of the song you want to select: ");
                    try {
                        int songIndex = scanner.nextInt();
                        scanner.nextLine();
                        if (songIndex > 0 && songIndex <= playlist.size()) {
                            String musicTitle = playlist.get(songIndex - 1).getFullTitle();
                            iphoneInstance.getReprodutorMusical().SelectMusic(musicTitle);
                        } else {
                            Alerta = ("Invalid song number.");
                        }
                    } catch (InputMismatchException e) {
                        Alerta = "Invalid input. Please enter a number.";
                        scanner.nextLine();
                    }
                }
                case 2 -> {
                    iphoneInstance.getReprodutorMusical().playMusic(iphoneInstance.getReprodutorMusical().getCurrentSong().split(" \\(")[0]); 
                }
                case 3 -> Alerta = iphoneInstance.getReprodutorMusical().pauseMusic();
                case 4 -> Alerta = iphoneInstance.getReprodutorMusical().stopMusic();
                case 5 -> Alerta = iphoneInstance.getReprodutorMusical().nextSong();
                case 6 -> Alerta = iphoneInstance.getReprodutorMusical().previousSong();
                default -> Alerta = "Invalid option. Please try again.";
            }
        } while (option != 7);
    }

    public static void displayVideoMenu() {
        if (iphoneInstance == null) {
            Alerta = "iPhone instance is not set. Please set it before displaying the menu.";
            return;
        }
        int option = 0;
        do {
            clearScreen();
            System.out.println("================================================");
            System.out.println("Welcome to the Video Menu");
            System.out.println("================================================");
            System.out.println("Please select an option:");
            System.out.println("1  -  Search Video");
            System.out.println("2  -  Play Video");
            System.out.println("3  -  Pause Video");
            System.out.println("4  -  Stop Video");
            System.out.println("5  -  Next Video");
            System.out.println("6  -  Previous Video");
            System.out.println("7  -  Back to Main Menu");
            System.out.println("================================================");
            System.out.println("Status: " + iphoneInstance.getVideoPlayer().getCurrentVideo());
            System.out.println("Alert: " + Alerta);
            System.out.println("================================================");
            Alerta = "";
            try {
                option = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                Alerta = "Invalid input. Please enter a number between 1 and 7.";
                scanner.nextLine();
                continue;
            }
            switch (option) {
                case 1 -> {
                    List<Video> playlist = iphoneInstance.getVideoPlayer().getPlaylist();
                    if (playlist.isEmpty()) {
                        Alerta = "No videos available in playlist.";
                        break;
                    }
                    System.out.println("================================================");
                    System.out.println("Video available:");
                    for (int i = 0; i < playlist.size(); i++) {
                        System.out.println((i + 1) + " - " + playlist.get(i).getFullTitle());
                    }
                    System.out.println("================================================");
                    System.out.print("Enter the number of the video you want to select: ");
                    try {
                        int videoIndex = scanner.nextInt();
                        scanner.nextLine();
                        if (videoIndex > 0 && videoIndex <= playlist.size()) {
                            String videoTitle = playlist.get(videoIndex - 1).getFullTitle();
                            iphoneInstance.getVideoPlayer().SelectVideo(videoTitle);
                        } else {
                            Alerta = "Invalid video number.";
                        }
                    } catch (InputMismatchException e) {
                        Alerta = "Invalid input. Please enter a number.";
                        scanner.nextLine();
                    }
                }
                case 2 -> {
                    iphoneInstance.getVideoPlayer().playVideo(iphoneInstance.getVideoPlayer().getCurrentVideo().split(" \\(")[0]); 
                }
                case 3 -> Alerta = iphoneInstance.getVideoPlayer().pauseVideo();
                case 4 -> Alerta = iphoneInstance.getVideoPlayer().stopVideo();
                case 5 -> Alerta = iphoneInstance.getVideoPlayer().nextVideo();
                case 6 -> Alerta = iphoneInstance.getVideoPlayer().previousVideo();
                default -> Alerta = "Invalid option. Please try again.";
            }
        } while (option != 7);
    }

    public static void displayPhoneMenu() {
        if (iphoneInstance == null) {
            Alerta = "iPhone instance is not set. Please set it before displaying the menu.";
            return;
        }
        int option = 0;
        do {
            clearScreen();
            System.out.println("================================================");
            System.out.println("Welcome to the Phone Menu");
            System.out.println("================================================");
            System.out.println("Please select an option:");
            System.out.println("1  -  Select Contact");
            System.out.println("2  -  Discard Number");
            System.out.println("3  -  Call");
            System.out.println("4  -  Hang Up");
            System.out.println("5  -  Send Voicemail");
            System.out.println("6  -  Receive Voicemail");
            System.out.println("7  -  Back to Main Menu");
            System.out.println("================================================");
            System.out.println("Contact: " + iphoneInstance.getAparelhoTelefonico().getContatoAtual());
            System.out.println("Call status: " + (iphoneInstance.getAparelhoTelefonico().isOnCall() ? "On call" : "Idle"));
            System.out.println("Alert: " + Alerta);
            System.out.println("================================================");
            Alerta = "";
            try {
                option = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                Alerta = "Invalid input. Please enter a number between 1 and 7.";
                scanner.nextLine();
                continue;
            }
            switch (option) {
                case 1 -> {
                    System.out.println("Available contacts:");
                    iphoneInstance.getAparelhoTelefonico().getContacts().forEach((k, v) -> System.out.println("- " + v.name() + " (" + v.phoneNumber() + ")"));
                    System.out.print("Enter contact name or number to select: ");
                    String contactIdentifier = scanner.nextLine();
                    Alerta = iphoneInstance.getAparelhoTelefonico().selectContact(contactIdentifier);
                }
                case 2 -> Alerta = iphoneInstance.getAparelhoTelefonico().makeCall("");
                case 3 -> Alerta = iphoneInstance.getAparelhoTelefonico().receiveCall(null);
                case 4 -> Alerta = iphoneInstance.getAparelhoTelefonico().endCall();
                case 5 -> Alerta = iphoneInstance.getAparelhoTelefonico().sendMessageVoice("","");
                case 6 -> Alerta = iphoneInstance.getAparelhoTelefonico().receiveMessageVoice();
                default -> Alerta = "Invalid option. Please try again.";
            }
        } while (option != 7);
    }

    public static void displayInternetMenu() {
        if (iphoneInstance == null) {
            Alerta = "iPhone instance is not set. Please set it before displaying the menu.";
            return;
        }
        int option = 0;
        do {
            clearScreen();
            System.out.println("================================================");
            System.out.println("Welcome to the Internet Menu");
            System.out.println("================================================");
            System.out.println("Please select an option:");
            System.out.println("1  -  View Page");
            System.out.println("2  -  Refresh Page");  
            System.out.println("3  -  Go Back");
            System.out.println("4  -  Add New Tab");
            System.out.println("5  -  Close Tab");
            System.out.println("6  -  Back to Main Menu");
            System.out.println("================================================");
            System.out.println("Current Page: " + iphoneInstance.getNavegadorInternet().getCurrentPage());
            System.out.println("open Tabs: " + iphoneInstance.getNavegadorInternet().getNumberOfTabs());
            System.out.println("Alert: " + Alerta);
            System.out.println("================================================");
            Alerta = "";
            try {
                option = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                Alerta = "Invalid input. Please enter a number between 1 and 6.";
                scanner.nextLine();
                continue;
            }
            switch (option) {
                case 1 -> {
                    System.out.print("Enter the page URL: ");
                    String url = scanner.nextLine();
                    iphoneInstance.getNavegadorInternet().viewPage(url);
                }
                case 2 -> Alerta = iphoneInstance.getNavegadorInternet().RefreshPage();
                case 3 -> Alerta = iphoneInstance.getNavegadorInternet().goBack();
                case 4 -> {
                    System.out.print("Enter the URL for the new tab: ");
                    String url = scanner.nextLine();
                    iphoneInstance.getNavegadorInternet().addNewTab(url);
                }
                case 5 -> Alerta = iphoneInstance.getNavegadorInternet().closeTab();
                default -> Alerta = "Invalid option. Please try again.";
            }
        } while (option != 6);
    }
}