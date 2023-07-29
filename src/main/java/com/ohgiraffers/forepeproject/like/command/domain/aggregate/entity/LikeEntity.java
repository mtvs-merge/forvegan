package com.ohgiraffers.forepeproject.like.command.domain.aggregate.entity;

import com.ohgiraffers.forepeproject.like.command.domain.aggregate.vo.CommentWriter;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "like")
@Table(name = "LIKE")
@SequenceGenerator(
        name = "COMMENT_SEQ_GENERATOR",
        sequenceName = "SEQ_COMMENT_NUM",
        initialValue = 1,
        allocationSize = 1
)
public class LikeEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "COMMENT_SEQ_GENERATOR"
    )

    @Column(name = "COMMENT_NUM")
    private int commentNum;

    @Column(name = "COMMENT_DETAIL")
    private String commentDetail;

    @Column(name = "COMMENT_DATE")
    private String commentDate;

    @Embedded
    @Column(name = "COMMENT_WRITER")
    private CommentWriter commentWriter;

    @Column(name = "COMMENT_POSTNUM")
    private int commentPostNum;

    @PrePersist
    public void onPrePersist() { this.commentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")); }}


