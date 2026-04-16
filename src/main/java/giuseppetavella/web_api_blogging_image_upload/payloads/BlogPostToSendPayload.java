package giuseppetavella.web_api_blogging_image_upload.payloads;

import java.util.UUID;

public class BlogPostToSendPayload {

    private final UUID authorId;
    private final String categoria;
    private final String titolo;
    private final String contenuto;
    private final int tempoDiLettura;

    public BlogPostToSendPayload(UUID authorId, String titolo, String categoria, String contenuto, int tempoDiLettura) {
        this.authorId = authorId;
        this.titolo = titolo;
        this.categoria = categoria;
        this.contenuto = contenuto;
        this.tempoDiLettura = tempoDiLettura;
    }

    public UUID getAuthorId() {
        return this.authorId;
    }

    public String getCategoria() {
        return categoria;
    }


    public String getContenuto() {
        return contenuto;
    }


    public int getTempoDiLettura() {
        return tempoDiLettura;
    }



    public String getTitolo() {
        return titolo;
    }



}
