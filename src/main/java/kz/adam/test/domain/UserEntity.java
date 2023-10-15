package kz.adam.test.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "user", schema = "test")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "accounts_seq")
    @SequenceGenerator(
            name = "user_seq",
            sequenceName = "test.user_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "name")
    private String name;
}
