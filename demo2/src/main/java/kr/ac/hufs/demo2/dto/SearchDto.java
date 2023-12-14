package kr.ac.hufs.demo2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchDto {
    private String title;
    private String link;
    private String description;
    private String category;
    private String telephone;
    private String address;
    private String roadAddress;
    private int mapx;
    private int mapy;
}
