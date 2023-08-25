package br.com.otavio.restwithspringbootandjavaerudio.VO;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class BookVO extends RepresentationModel<BookVO> implements Serializable {

    private static final long serialVersionUID = 1L;

    private String author;
    private LocalDateTime launch_date;
    private String title;
    private Long price;

}
