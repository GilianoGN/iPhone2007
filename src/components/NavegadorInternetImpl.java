package components;

import interfaces.NavegadorInternet;
import models.WebPage;
import exceptions.NavegadorException;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class NavegadorInternetImpl implements NavegadorInternet {
    private WebPage currentPage;
    private List<WebPage> openTabs;
    private Stack<WebPage> history;

    public NavegadorInternetImpl() {
        this.openTabs = new ArrayList<>();
        this.history = new Stack<>();
        WebPage homePage = new WebPage("http://www.google.com", "Google's homepage");
        this.openTabs.add(homePage);
        this.currentPage = homePage;
    }

    @Override
    public void viewPage(String url) {
        try {
            if (url == null || url.trim().isEmpty()) {
                throw new NavegadorException("URL cannot be empty.");
            }
            if (!url.startsWith("http://") && !url.startsWith("https://")) {
                url = "https://" + url;
            }
            System.out.println("Loading page: " + url);
            if (currentPage != null) {
                history.push(currentPage);
            } else if (openTabs.isEmpty()) {
                WebPage newTab = new WebPage(url, "Page content " + url);
                openTabs.add(newTab);
                this.currentPage = newTab;
                System.out.println("Page displayed: " + currentPage.url());
                return; 
            }
            WebPage newPageContent = new WebPage(url, "Page content " + url);
            int currentTabIndex = openTabs.indexOf(currentPage);
            if (currentTabIndex == -1) {
                if (!openTabs.isEmpty()) {
                    currentTabIndex = openTabs.size() - 1;
                    System.out.println("Warning: currentPage not found in openTabs. Using last tab as current.");
                } else {
                    throw new NavegadorException("Internal error: No open tabs to display page.");
                }
            }
            openTabs.set(currentTabIndex, newPageContent);
            this.currentPage = newPageContent;
            System.out.println("Page displayed: " + currentPage.url());
        } catch (NavegadorException e) {
            System.out.println("Browser error: " + e.getMessage());
        }
    }

    @Override
    public String RefreshPage() {
        if (currentPage != null) {
            return ("Refreshing page: " + currentPage.url() + "\nPage updated.");
        } else {
            return "No page to refresh.";
        }
    }

    @Override
    public String goBack() {
        if (!history.isEmpty()) {
            this.currentPage = history.pop();
            return ("Returning to: " + currentPage.url());
        } else {
            return "There is no history to go back to.";
        }
    }

    @Override
    public String closeTab() {
        if (openTabs.isEmpty()) {
            return "No tabs to close.";
        } 
        if (openTabs.size() == 1) {
            openTabs.clear();
            currentPage = null;
            history.clear();
            return "Last tab closed. No pages open now.";
        }
        int currentIndex = openTabs.indexOf(currentPage);
        if (currentIndex == -1) {
            openTabs.remove(openTabs.size() - 1);
            if (!openTabs.isEmpty()) {
                currentPage = openTabs.get(openTabs.size() - 1);
            } else {
                currentPage = null;
            }
            history.clear();
            return "Tab closed. Current page is now: " + (currentPage != null ? currentPage.url() : "No page open.");
        }
        if (currentIndex == openTabs.size() - 1) {
            openTabs.remove(currentIndex);
            if (!openTabs.isEmpty()) {
                currentPage = openTabs.get(openTabs.size() - 1);
            } else {
                currentPage = null;
            }
        } else {
            openTabs.remove(currentIndex);
            currentPage = openTabs.get(currentIndex);
        }
        history.clear();
        return "Tab closed. Current page is now: " + (currentPage != null ? currentPage.url() : "No page open.");
    }

    @Override
    public void addNewTab(String url) {
        try {
            if (url == null || url.trim().isEmpty()) {
                throw new NavegadorException("URL for new tab cannot be empty.");
            }
            if (!url.startsWith("http://") && !url.startsWith("https://")) {
                url = "https://" + url;
            }
            System.out.println("Adding new tab with: " + url);
            WebPage newTab = new WebPage(url, "New tab content " + url);
            openTabs.add(newTab);
            this.currentPage = newTab; 
            history.clear(); 
            System.out.println("New tab opened and displaying: " + currentPage.url());
        } catch (NavegadorException e) {
            System.out.println("Error adding tab: " + e.getMessage());
        }
    }

    @Override
    public String getCurrentPage() {
        return currentPage != null ? currentPage.url() : "No page open.";
    }

    @Override
    public int getNumberOfTabs() {
        return openTabs.size();
    }
}