package com.olliniinioja.demo.yle.TeleText.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.Instant;

@Data
@Document(collection = "images")
@RequiredArgsConstructor
public class Image implements Serializable {

    @Id
    public String id;

    // FIXME: Lombok @NonNull conflicts with IntelliJ @NonNull and might show wrong during build
    @lombok.NonNull
    public int page;
    @lombok.NonNull
    public int subpage;
    public String url;

    public Instant time;

    public Image(int page, int subpage, String url) {
        this.page = page;
        this.subpage = subpage;
        this.url = url;
    }
}
