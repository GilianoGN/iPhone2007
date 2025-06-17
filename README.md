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
    main <|-- iPhone
    main <|-- iPhoneMenu
    iPhoneMenu <|-- iPhone
    iPhoneMenu <|-- Music
    iPhoneMenu <|-- Video
    iPhoneMenu <|-- Contact
    iPhoneMenu <|-- WebPage
    iPhone <|-- ReprodutorMusicalImpl
    iPhone <|-- VideoPlayerImpl
    iPhone <|-- AparelhoTelefonicoImpl
    iPhone <|-- NavegadorInternetImpl
    iPhone <|-- ReprodutorMusical
    iPhone <|-- VideoPlayer
    iPhone <|-- AparelhoTelefonico
    iPhone <|-- NavegadorInternet
    ReprodutorMusical <|-- Music
    VideoPlayer <|-- Video
    AparelhoTelefonico <|-- Contact
    NavegadorInternet <|-- WebPage
    
    class main {
    	<<Import>>
    	# device.iPhone : class
    	# menu.iPhoneMenu: class
    	<<Operations>>
    	+ main()
    }
    class iPhoneMenu {
    	<<Import>>
    	# models.Music : record
    	# models.Video : record
    	# models.Contact : record
    	# models.WebPage : record
    	# device.iPhone : record
    	<<Attributes>>
    	- iphoneInstance : iPhone
    	- Alerta : String
    	<<Operations>>
    	+ setIphoneInstace()
    	+ displayMusicMenu()
    	+ displayVideoMenu()
    	+ displayPhoneMenu()
    	+ displayInternetMenu()
    }
    class iPhone {
    	<<Import>>
    	# components.ReprodutorMusicalImpl : class
    	# components.VideoPlayerImpl : class
    	# components.AparelhotelefonicoImpl : class
    	# components.NavegadorInterntImpl : class
    	# interfaces.ReprodutorMusical : interfaces
    	# interfaces.VideoPlayer : interfaces
    	# interfaces.AparelhoTelefonico : interfaces
    	# interfaces.Navegador : interfaces
    	<<Attributes>>
    	- reprodutorMusical : ReprodutorMusicalImpl
    	- videoPlayer : VideoPlayerImpl
    	- aparelhoTelefonico : AparelhoTelefonicoImpl
    	- navegadorInternet : NavegadorInternetImpl
    	<<Operations>>
    	+ Iphone()
    	+ getReprodutorMusical()
    	+ getVideoPlayer()
    	+ getAparelhoTelefonico()
    	+ getNavegadorInternet()
    }
    class Music {
    	<<Attributes>>
    	- title : String
    	- artist : String
    	<<Operations>>
    	+ getFullTitle()
    }
    class Video {
    	<<Attributes>>
    	- title : String
    	- director : String
    	<<Operations>>
    	+ getFullTitle()
    }
    class Contact {
    	<<Attributes>>
    	- name : String
    	- phoneNumber : String
    }
    class WebPage {
    	<<Attributes>>
    	- url : String
    	- content : String
    	<<Operations>>
    	+ equals() : boolean
    	+ hashCode() : Int
    }
    class ReprodutorMusical {
    	<<Import>>
    	# models.Music : record
    	<<Operations>>
    	+ SelectMusic()
    	+ playMusic()
    	+ pauseMusic() : String
    	+ stopMusic() : String
    	+ nextSong() : String
    	+ previusSong() : String
    	+ getCurrentSong() : String
    	+ getPlaylist() : List(Music)
    }
    class VideoPlay {
    	<<Import>>
    	# models.Video : record
    	<<Operations>>
    	+ SelectVideo()
    	+ playVideo()
    	+ pauseVideo() : String
    	+ stopVideo() : String
    	+ nextVideo() : String
    	+ previusVideo() : String
    	+ getCurrentVideo() : String
    	+ getPlaylist() : List(Video)
    }
    class AparelhoTelefonico {
    	<<Import>>
    	# models.Contact : record
    	<<Operations>>
    	+ selectContact() : String
    	+ makeCall() : String
    	+ receiveCall() : String
    	+ endCall() : String
    	+ sendMessageVoice() : String
    	+ receiveMessageVoice() : String
    	+ getContatoAtual(): String
    	+ isOnCall() : boolean
    	+ getContatcs() : Map(String, Contact)
    }
    class NavegadorInternet {
    	<<Operations>>
    	+ viewPage()
    	+ addNewTab()
    	+ closetab() : String
    	+ RefreshPage() : String
    	+ goBack() : String
    	+ getCurrentPage() : String
    	+ getNumberOfTabs() : int
    }
    class ReprodutorMusicaImpl {
    	<<Import>>
    	# interfaces.ReprodutorMusical : interfaces
    	# models.Music : record
    	<<Attributes>>
    	- musicaAtual : Music
    	- isPlaying : boolean
    	- playlist : List(Music)
    	<<Operations>>
    	+ ReprodutorMusicalImpl()
    	+ SelectMusic()
    	+ playMusic()
    	+ pauseMusic() : String
    	+ stopMusic() : String
    	+ nextSong() : String
    	+ previusSong() : String
    	+ getCurrentSong() : String
    	+ getPlaylist() : List(Music)
    }
    class VideoPlayerImpl {
    	<<Import>>
    	# interfaces.VideoPlayer : interfaces
    	# models.Video : record
    	<<Attributes>>
    	- currentVideo : Video
    	- isPlaying : boolean
    	- videoPlaylist : List(Video)
    	<<Operations>>
    	+ VideoPlayerImpl()
    	+ SelectVideo()
    	+ playVideo()
    	+ pauseVideo() : String
    	+ stopVideo() : String
    	+ nextVideo() : String
    	+ previusVideo() : String
    	+ getCurrentVideo() : String
    	+ getPlaylist() : List(Video)
    }
    class AparelhoTelefonicoImpl {
    	<<Import>>
    	# interfaces.AparelhoTelefonico : interfaces
    	# models.Contact : record
    	# exceptions.ChamadaException : class
    	<<Attributes>>
    	- currentContact : Contact
    	- isOnCall : boolean
    	- contacts : Map(String, Contact)
    	- currentMessage : String
    	<<Operations>>
    	+ AparelhoTelefonicoImpl()
    	+ selectContact() : String
    	+ makeCall() : String
    	+ receiveCall() : String
    	+ endCall() : String
    	+ sendMessageVoice() : String
    	+ receiveMessageVoice() : String
    	+ getContatoAtual(): String
    	+ isOnCall() : boolean
    	+ getContatcs() : Map(String, Contact)
    }
    class NavegadorInternetImpl {
    	<<Import>>
    	# interfaces.NavegadorInternet : interfaces
    	# models.WebPage : record
    	# exception.NavegadorException : class
    	<<Attributes>>
    	- currentPage : WebPage
    	- openTabs : List(WebPage)
    	- history : Stack(WebPage)
    	<<Operations>>
    	+ NavegadorInternetImpl()
    	+ viewPage()
    	+ addNewTab()
    	+ closetab() : String
    	+ RefreshPage() : String
    	+ goBack() : String
    	+ getCurrentPage() : String
    	+ getNumberOfTabs() : int
    }
    class ChamadaException {
    	<<Extend>>
    	# RuntimeException
    	<<Operations>>
    	+ ChamadaException()
    }
    class NavegadorException {
    	<<Extend>>
    	# RuntimeException
    	<<Operations>>
    	+ NavegadorException()
    }
```
