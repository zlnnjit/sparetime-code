package top.bcoder.rocketmq.producer.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Orders implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
    * id
    */
    private Long id;

    /**
    * name
    */
    private String name;

    /**
    * piece
    */
    private Double piece;


}