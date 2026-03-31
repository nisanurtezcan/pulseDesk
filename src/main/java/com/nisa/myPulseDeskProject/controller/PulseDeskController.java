package com.nisa.myPulseDeskProject.controller;

import com.nisa.myPulseDeskProject.model.Comment;
import com.nisa.myPulseDeskProject.model.Ticket;
import com.nisa.myPulseDeskProject.repository.CommentRepository;
import com.nisa.myPulseDeskProject.repository.TicketRepository;
import com.nisa.myPulseDeskProject.service.CommentService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PulseDeskController {

    private final CommentService commentService;
    private final CommentRepository commentRepository;
    private final TicketRepository ticketRepository;

    public PulseDeskController(CommentService commentService,
                               CommentRepository commentRepository,
                               TicketRepository ticketRepository) {
        this.commentService = commentService;
        this.commentRepository = commentRepository;
        this.ticketRepository = ticketRepository;
    }

    @PostMapping("/comments")
    public Comment submitComment(@RequestBody CommentRequest request) {
        return commentService.submitComment(request.getContent());
    }

    @GetMapping("/comments")
    public List<Comment> getComments() {
        return commentRepository.findAll();
    }

    @GetMapping("/tickets")
    public List<Ticket> getTickets() {
        return ticketRepository.findAll();
    }

    @GetMapping("/tickets/{ticketId}")
    public ResponseEntity<Ticket> getTicket(@PathVariable Long ticketId) {
        return ticketRepository.findById(ticketId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}