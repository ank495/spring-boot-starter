package com.example.demo.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

@Entity(name="speakers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Speaker {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="speaker_id")
  private Long speakerId;
  @Column(name="first_name")
  private String firstName;
  @Column(name="last_name")
  private String lastName;
  @Column(name="title")
  private String title;
  @Column(name="company")
  private String company;
  @Column(name="speaker_bio")
  private String speakerBio;
  @Column(name="speaker_photo")
  @Lob
  @Type(type="org.hibernate.type.BinaryType")
  private byte[] speakerPhoto;
  @ManyToMany(mappedBy = "speakers")
  private List<Session> sessions;
}
