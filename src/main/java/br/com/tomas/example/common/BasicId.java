package br.com.tomas.example.common;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Data;

/**
 *
 * @author tomaslm
 */
@Data
@MappedSuperclass
public class BasicId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
}
