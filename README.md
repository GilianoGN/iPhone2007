# Projeto iPhone Digital
Este projeto simula as funcionalidades básicas de um iPhone, integrando reprodutor musical, aparelho telefônico e navegador de internet. Desenvolvido em Java, o sistema oferece uma experiência interativa via console, permitindo ao usuário explorar as diversas capacidades de um smartphone moderno.

## Visão Geral do Projeto
O iPhone Digital é uma aplicação em Java que emula um iPhone, centralizando três módulos principais:

* Reprodutor Musical: Permite ao usuário selecionar e reproduzir músicas, pausar, avançar e retroceder faixas.
* Aparelho Telefônico: Simula chamadas, recebimento de chamadas, encerramento de ligações e envio de mensagens de voz.
* Navegador na Internet: Oferece funcionalidades como navegação por URLs, atualização de página, navegação no histórico e gerenciamento de abas.
O objetivo principal foi integrar esses componentes em um único sistema coeso, demonstrando o uso de interfaces, classes e tratamento de exceções em Java.

## Características do Projeto
* Modularidade: Divisão das funcionalidades em componentes (ReprodutorMusicalImpl, AparelhoTelefonicoImpl, NavegadorInternetImpl) que implementam interfaces específicas, promovendo um design limpo e extensível.
* Gerenciamento de Músicas: Capacidade de reproduzir, pausar, selecionar próxima/anterior música.
* Gerenciamento de Chamadas: Simulação de chamadas em andamento, recebimento e encerramento de ligações.
* Navegação Web: Navegação entre páginas, recarregar, voltar no histórico e manipulação de abas.
* Tratamento de Exceções: Implementação de classes de exceção personalizadas (NavegadorException, TelefoneException, MusicaException) para um controle de erros robusto.
* Interatividade: Interface de console que guia o usuário através dos menus de cada funcionalidade do iPhone.
Tecnologias Utilizadas
* Linguagem: Java
IDE: Visual Studio Code (ou qualquer IDE Java compatível como Eclipse, IntelliJ IDEA)
* Estruturas de Dados: ArrayList para listas de itens, Stack para histórico de navegação.
## Diagrama UML
O diagrama de classes a seguir ilustra a estrutura e os relacionamentos entre os principais componentes do projeto iPhone Digital.

```mermaid
classDiagram
    direction LR

    %% RELACIONAMENTOS PRINCIPAIS
    main ..> iphoneMenu : inicia
    iphoneMenu ..> IPhone : controla

    IPhone "1" *-- "1" ReprodutorMusicalImpl : possui
    IPhone "1" *-- "1" VideoPlayerImpl : possui
    IPhone "1" *-- "1" AparelhoTelefonicoImpl : possui
    IPhone "1" *-- "1" NavegadorInternetImpl : possui

    ReprodutorMusicalImpl ..|> ReprodutorMusical : implementa
    VideoPlayerImpl ..|> VideoPlayer : implementa
    AparelhoTelefonicoImpl ..|> AparelhoTelefonico : implementa
    NavegadorInternetImpl ..|> NavegadorInternet : implementa

    ReprodutorMusicalImpl "1" o-- "*" Music : gerencia
    VideoPlayerImpl "1" o-- "*" Video : gerencia
    AparelhoTelefonicoImpl "1" o-- "*" Contact : gerencia
    NavegadorInternetImpl "1" o-- "*" WebPage : gerencia

    AparelhoTelefonicoImpl ..> TelefoneException : lança
    NavegadorInternetImpl ..> NavegadorException : lança
    ReprodutorMusicalImpl ..> MusicaException : lança

    %% DEFINIÇÃO DAS CLASSES E INTERFACES

    class main {
        +main(String[] args) void
    }

    class iphoneMenu {
        - iphoneInstance : IPhone
        - Alerta : String
        + iphoneMenu()
        + displayMainMenu() void
        + displayMusicMenu() void
        + displayVideoMenu() void
        + displayPhoneMenu() void
        + displayInternetMenu() void
    }

    class IPhone {
        - reprodutorMusical : ReprodutorMusicalImpl
        - videoPlayer : VideoPlayerImpl
        - aparelhoTelefonico : AparelhoTelefonicoImpl
        - navegadorInternet : NavegadorInternetImpl
        + IPhone()
        + getReprodutorMusical() : ReprodutorMusical
        + getVideoPlayer() : VideoPlayer
        + getAparelhoTelefonico() : AparelhoTelefonico
        + getNavegadorInternet() : NavegadorInternet
    }

    class Music {
        - title : String
        - artist : String
        - duration : String
        + Music(String title, String artist, String duration)
        + getFullTitle() : String
    }

    class Video {
        - title : String
        - director : String
        - duration : String
        + Video(String title, String director, String duration)
        + getFullTitle() : String
    }

    class Contact {
        - name : String
        - phoneNumber : String
        + Contact(String name, String phoneNumber)
    }

    class WebPage {
        - url : String
        - content : String
        + WebPage(String url, String content)
        + equals(Object o) : boolean
        + hashCode() : int
    }

    class ReprodutorMusical {
        + playMusic(String title) String
        + pauseMusic() String
        + selectNextMusic() String
        + selectPreviousMusic() String
    }

    class VideoPlayer {
        + playVideo(String title) String
        + pauseVideo() String
        + selectNextVideo() String
        + selectPreviousVideo() String
    }

    class AparelhoTelefonico {
        + makeCall(String phoneNumber) String
        + receiveCall(String phoneNumber) String
        + endCall() String
        + sendMessageVoice(String recipient, String message) String
        + getContact(String name) Contact
        + isOnCall() : boolean
    }

    class NavegadorInternet {
        + viewPage(String url) void
        + RefreshPage() String
        + goBack() String
        + closeTab() String
        + addNewTab(String url) void
        + getCurrentPage() String
        + getNumberOfTabs() int
    }

    class ReprodutorMusicalImpl {
        - currentMusic : Music
        - isPlaying : boolean
        - playlist : List~Music~
        + ReprodutorMusicalImpl()
        + playMusic(String title) String
        + pauseMusic() String
        + selectNextMusic() String
        + selectPreviousMusic() String
    }

    class VideoPlayerImpl {
        - currentVideo : Video
        - isPlaying : boolean
        - videoPlaylist : List~Video~
        + VideoPlayerImpl()
        + playVideo(String title) String
        + pauseVideo() String
        + selectNextVideo() String
        + selectPreviousVideo() String
    }

    class AparelhoTelefonicoImpl {
        - currentContact : Contact
        - isOnCall : boolean
        - contacts : Map~String, Contact~
        + AparelhoTelefonicoImpl()
        + makeCall(String phoneNumber) String
        + receiveCall(String phoneNumber) String
        + endCall() String
        + sendMessageVoice(String recipient, String message) String
        + getContact(String name) Contact
        + isOnCall() : boolean
    }

    class NavegadorInternetImpl {
        - currentPage : WebPage
        - openTabs : List~WebPage~
        - history : Stack~WebPage~
        + NavegadorInternetImpl()
        + viewPage(String url) void
        + addNewTab(String url) void
        + closeTab() String
        + RefreshPage() String
        + goBack() String
        + getCurrentPage() String
        + getNumberOfTabs() int
    }

    class MusicaException {
        + MusicaException(String message)
    }

    class TelefoneException {
        + TelefoneException(String message)
    }

    class NavegadorException {
        + NavegadorException(String message)
    }

    MusicaException --|> RuntimeException
    TelefoneException --|> RuntimeException
    NavegadorException --|> RuntimeException
```
