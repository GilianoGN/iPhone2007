package interfaces;

import java.util.Map;

import models.Contact;

public interface AparelhoTelefonico {
    //Comportamento esperado
    String selectContact(String phoneNumber);
    String makeCall(String phoneNumber);
    String receiveCall(String phoneNumber);
    String endCall();
    String sendMessageVoice(String phoneNumber, String message);
    String receiveMessageVoice();

    //Métodos de verificação
    String getContatoAtual();
    boolean isOnCall();
    Map<String, Contact> getContacts();
}
