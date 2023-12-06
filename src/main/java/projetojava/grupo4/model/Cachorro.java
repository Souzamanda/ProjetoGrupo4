package projetojava.grupo4.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_cachorro")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cachorro {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String raca;

}
