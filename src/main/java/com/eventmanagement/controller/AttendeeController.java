package com.eventmanagement.controller;

import com.eventmanagement.dto.ApiResponse;
import com.eventmanagement.entity.Attendee;
import com.eventmanagement.service.AttendeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/attendees")
public class AttendeeController {
    private final AttendeeService attendeeService;

    public AttendeeController(AttendeeService attendeeService) {
        this.attendeeService = attendeeService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Attendee>> registerAttendee(@RequestBody Attendee attendee) {
        Attendee savedAttendee = attendeeService.registerAttendee(attendee);
        return new ResponseEntity<>(ApiResponse.success(savedAttendee, "Attendee registered successfully", HttpStatus.CREATED.value()), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Attendee>>> getAllAttendees() {
        List<Attendee> attendees = attendeeService.getAllAttendees();
        return new ResponseEntity<>(ApiResponse.success(attendees, "Attendees retrieved successfully", HttpStatus.OK.value()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Attendee>> getAttendeeById(@PathVariable Long id) {
        Optional<Attendee> attendee = attendeeService.getAttendeeById(id);
        if (attendee.isPresent()) {
            return new ResponseEntity<>(ApiResponse.success(attendee.get(), "Attendee retrieved successfully", HttpStatus.OK.value()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(ApiResponse.error("Attendee not found with ID: " + id, HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteAttendee(@PathVariable Long id) {
        Optional<Attendee> attendee = attendeeService.getAttendeeById(id);
        if (attendee.isPresent()) {
            attendeeService.deleteAttendee(id);
            return new ResponseEntity<>(ApiResponse.success(null, "Attendee deleted successfully", HttpStatus.NO_CONTENT.value()), HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(ApiResponse.error("Attendee not found with ID: " + id, HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Attendee>> updateAttendee(@PathVariable Long id, @RequestBody Attendee attendee) {
        try {
            Attendee updatedAttendee = attendeeService.updateAttendee(id, attendee);
            return new ResponseEntity<>(ApiResponse.success(updatedAttendee, "Attendee updated successfully", HttpStatus.OK.value()), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(ApiResponse.error(e.getMessage(), HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND);
        }
    }
}