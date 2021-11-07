package com.conchu.hbd.domain;

import com.conchu.hbd.util.RandomGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Entity(name = "comment")
@Table(name = "comment")
@NoArgsConstructor
@AllArgsConstructor
public class Comment extends Timestamped{

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = RandomGenerator.generatorName)
    @GenericGenerator(name = RandomGenerator.generatorName, strategy = "com.conchu.hbd.util.RandomGenerator")
    private String id;

    @Column(name = "letterId")
    private String letterId;

    @Column(name = "content", nullable = false)
    private String content;


    public Comment(CommentRequestDto requestDto) {
        this.letterId = requestDto.getLetterId();
        this.content = requestDto.getContent();
    }

    public void setLetter_id(Letter letter) {
        this.letterId = letter.getId();
        letter.getComments().add(this);
    }
}