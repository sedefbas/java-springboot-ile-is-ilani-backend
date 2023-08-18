package com.example.ticaretUstasi.businnes.request.link;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class LinkAdd {
    private int id;
    private String LinkName;
    private String url;
}
