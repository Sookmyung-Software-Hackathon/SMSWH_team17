package com.conchu.hbd.domain;

import com.conchu.hbd.repository.LetterRepository;
import com.conchu.hbd.util.RandomGenerator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "letter")
@NoArgsConstructor
public class Letter extends Timestamped {

    @Id
    @Column(name = "id")
    @JsonIgnore
    @GeneratedValue(generator = RandomGenerator.generatorName)
    @GenericGenerator(name = RandomGenerator.generatorName, strategy = "com.conchu.hbd.util.RandomGenerator")
    private String id;

    @Column(name = "category")
    private String category;

    @Column(name = "name")
    private String name;

    @Column(name = "letternum")
    private Long letternum;

    public Letter(LetterDto letterDto){
        this.category = letterDto.getCategory();
        this.name = letterDto.getName();
        this.letternum = (long)((Math.random() * 10) % 3);
    }

    @OneToMany()
    @JoinColumn(name="comment_id")
    private List<Comment> comments = new ArrayList<>();

}
