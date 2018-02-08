package br.com.tomas.example.common;

import javax.persistence.Id;
import lombok.Data;

/**
 *
 * @author tomaslm
 */
@Data
public class BasicId {

    @Id
    private Long ID;
}
