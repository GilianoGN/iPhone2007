package interfaces;

public interface NavegadorInternet {
    //Comportamento esperado
    void viewPage(String url);
    void addNewTab(String url);
    String closeTab();
    String RefreshPage();
    String goBack();

    //Metodos para verificar
    String getCurrentPage();
    int getNumberOfTabs();
}