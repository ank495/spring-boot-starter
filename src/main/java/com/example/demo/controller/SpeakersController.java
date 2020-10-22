package com.example.demo.controller;


import com.example.demo.model.Speaker;
import com.example.demo.repository.SpeakerRepository;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakersController {

  @Autowired
  private SpeakerRepository speakerRepository;

  @GetMapping
  public List<Speaker> getAllSpeakers(){
    return speakerRepository.findAll();
  }

  @PostMapping
  public Speaker saveSpeakerRecord(@RequestBody Speaker speaker) {
    return speakerRepository.saveAndFlush(speaker);
  }

  @GetMapping
  @RequestMapping("{id}")
  public Speaker getSpeakerInfo(@PathVariable Long id) {
    return speakerRepository.getOne(id);
  }

  @RequestMapping(value="{id}", method = RequestMethod.PUT)
  public void deleteSpeaker(@PathVariable long id) {
     speakerRepository.deleteById(id);
  }

/*
  @RequestMapping(value="{id}", method =  RequestMethod.PUT)
  @ResponseStatus(HttpStatus.CREATED)
  public Speaker updateRecord(@PathVariable long id, @RequestBody Speaker speaker) {
    Speaker existingSpeaker = speakerRepository.getOne(id);
    BeanUtils.copyProperties(speaker, existingSpeaker, "speaker_id");
    return speakerRepository.saveAndFlush(existingSpeaker);
  }
*/

}
