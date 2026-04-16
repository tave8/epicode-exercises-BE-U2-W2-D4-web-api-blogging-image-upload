package giuseppetavella.web_api_blogging_image_upload.payloads;

import java.time.LocalDate;
import java.util.UUID;

public class NewAuthorPayload {

    private final String nome;
    private final String cognome;
    private final String email;
    private final LocalDate dataNascita;
    
    public NewAuthorPayload(String nome, String cognome, String email, LocalDate dataNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataNascita = dataNascita;
    }

    public String getCognome() {
        return cognome;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }
}
