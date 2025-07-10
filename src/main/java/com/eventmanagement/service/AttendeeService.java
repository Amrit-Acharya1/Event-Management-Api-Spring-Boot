package com.eventmanagement.service;

import com.eventmanagement.entity.Attendee;
import com.eventmanagement.entity.Event;
import com.eventmanagement.entity.User;
import com.eventmanagement.repository.AttendeeRepository;
import com.eventmanagement.repository.EventRepository;
import com.eventmanagement.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Service
public class AttendeeService {
    private final AttendeeRepository attendeeRepository;
    private final UserRepository userRepository;
    private final EventRepository eventRepository;

    public AttendeeService(AttendeeRepository attendeeRepository, UserRepository userRepository, EventRepository eventRepository) {
        this.attendeeRepository = attendeeRepository;
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
    }

    public Attendee registerAttendee(Attendee attendee) {
        User user = userRepository.findById(attendee.getUser().getId())
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + attendee.getUser().getId()));
        Event event = eventRepository.findById(attendee.getEvent().getId())
                .orElseThrow(() -> new IllegalArgumentException("Event not found with ID: " + attendee.getEvent().getId()));

        attendee.setUser(user);
        attendee.setEvent(event);

        Attendee savedAttendee = attendeeRepository.save(attendee);
        
        
        
        return savedAttendee;
    }
     public Optional<Attendee> getAttendeeById(Long id) {
        return attendeeRepository.findById(id);
    }

    public List<Attendee> getAllAttendees() {
        return attendeeRepository.findAll();
    }
    public @ResponseBody void deleteAttendee(Long id){
        
        attendeeRepository.deleteById(id);
         
    }
     public Attendee updateAttendee(Long id, Attendee updatedAttendee) {
        Optional<Attendee> existingAttendee = attendeeRepository.findById(id);
        if (existingAttendee.isPresent()) {
            Attendee attendee = existingAttendee.get();
            User user = userRepository.findById(updatedAttendee.getUser().getId())
                    .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + updatedAttendee.getUser().getId()));
            Event event = eventRepository.findById(updatedAttendee.getEvent().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Event not found with ID: " + updatedAttendee.getEvent().getId()));

            attendee.setUser(user);
            attendee.setEvent(event);

            return attendeeRepository.save(attendee);
        } else {
            throw new IllegalArgumentException("Attendee not found with ID: " + id);
        }
    }
}