package components;

import interfaces.AparelhoTelefonico;
import models.Contact;
import exceptions.ChamadaException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class AparelhoTelefonicoImpl implements AparelhoTelefonico {
    private Contact currentContact;
    private boolean isOnCall;
    private Map<String, Contact> contacts;
    private String currentMessage;

    public AparelhoTelefonicoImpl() {
        this.currentContact = null;
        this.isOnCall = false;
        this.contacts = new HashMap<>();
        this.currentMessage = "No voicemail received.";
        contacts.put("Father", new Contact("Father", "12345-6789"));
        contacts.put("Mother", new Contact("Mother", "98765-4321"));
        contacts.put("Brother", new Contact("Brother", "55555-5555"));
        contacts.put("Friend", new Contact("Friend", "11111-1111"));
    }

    @Override
    public String selectContact(String phoneNumber) {
        Contact foundContact = contacts.values().stream()
                                     .filter(c -> c.name().equalsIgnoreCase(phoneNumber) || c.phoneNumber().equals(phoneNumber))
                                     .findFirst()
                                     .orElse(null);

        if (foundContact != null) {
            this.currentContact = foundContact;
            return ("Selected contact: " + currentContact.name() + " (" + currentContact.phoneNumber() + ")");
        } else {
            this.currentContact = null;
            return ("Contact '" + phoneNumber + "' not found.");
        }
    }

    @Override
    public String makeCall(String phoneNumber) {
        if (currentContact == null) {
            return ("Please select a contact before calling.");
        }
        if (isOnCall) {
            return ("Already on a call with " + currentContact.name() + ".");
        }
        try {
            if (Objects.equals(currentContact.phoneNumber(), "999-9999")) {
                throw new ChamadaException("Number unavailable. Please try again later.");
            }
            var MensageAlert = ("Calling to " + currentContact.name() + " (" + currentContact.phoneNumber() + ")...");
            this.isOnCall = true; 
            this.currentMessage = "Missed call from " + currentContact.name();
            MensageAlert = ("\nCall established with " + currentContact.name() + ".");
            return MensageAlert;
        } catch (ChamadaException e) {
            this.isOnCall = false;
            return ("Error connecting: " + e.getMessage());
        }
    }

    @Override
    public String receiveCall(String phoneNumber) {
        if (!isOnCall) { 
            this.isOnCall = true;
            this.currentContact = new Contact("Unknown", "Private number");
            return "Incoming call... Answering...\n Call in progress.";
        } else {
            return "Already on a call.";
        }
    }

    @Override
    public String endCall() {
        if (isOnCall) {
            var MensageAlert = "Call with " + (currentContact != null ? currentContact.name() : "unknown number") + " closed.";
            this.isOnCall = false;
            this.currentContact = null;
            return MensageAlert;
        } else {
            return "There is no call in progress.";
        }
    }

    @Override
    public String sendMessageVoice(String phoneNumber, String message) {
        if (!isOnCall) {
            var MensageAlert = "Starting voicemail recording. Please say your message after the beep...\n";
            // Lógica para gravar mensagem (simplificada)
            this.currentMessage = "You have a new voicemail recorded.";
            MensageAlert += "Recorded voice message. Ending.";
            return MensageAlert;
        } else {
            return "Unable to start voicemail during an active call.";
        }
    }

    @Override
    public String receiveMessageVoice() {
        System.out.println("Voice mail: " + this.currentMessage);
        this.currentMessage = "No new voicemail.";
        return this.currentMessage;
    }

    @Override
    public String getContatoAtual() {
        return currentContact != null ? currentContact.name() : "No contacts selected.";
    }

    @Override
    public boolean isOnCall() {
        return isOnCall; 
    }   
    
    public Map<String, Contact> getContacts() {
        return contacts;
    }
}