package com.project.ippaitu.service;

import com.project.ippaitu.model.Event;
import com.project.ippaitu.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public List<Event> getlistAll(){
        return eventRepository.findAll(Sort.by(Sort.Direction.ASC,"id"));
    }
    public void save(Event event){
        eventRepository.save(event);
    }
    public Event get(long id){
        return eventRepository.findById(id).get();
    }
    public void delete(long id){
        eventRepository.deleteById(id);
    }
}
