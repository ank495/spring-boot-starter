package com.example.demo.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="sessions")
@Transactional
public class Session {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="session_id")
  private Long sessionId;
  @Column(name="session_name")
  private String sessionName;
  @Column(name="session_description")
  private String sessionDescription;
  @Column(name="session_length")
  private Integer sessionLength;
  @Column(name="session_speaker")
  @ManyToMany
  @JoinTable(
      name="session_speakers",
      joinColumns = @JoinColumn(name="session_id"),
      inverseJoinColumns = @JoinColumn(name=" speaker_id")
  )
  private List<Speaker> speakers;
}
