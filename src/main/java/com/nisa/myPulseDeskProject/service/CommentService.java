package com.nisa.myPulseDeskProject.service;

import com.nisa.myPulseDeskProject.model.Comment;
import com.nisa.myPulseDeskProject.model.Ticket;
import com.nisa.myPulseDeskProject.repository.CommentRepository;
import com.nisa.myPulseDeskProject.repository.TicketRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final TicketRepository ticketRepository;
    private final HuggingFaceService huggingFaceService;

    public CommentService(CommentRepository commentRepository, 
                          TicketRepository ticketRepository,
                          HuggingFaceService huggingFaceService){
        this.commentRepository = commentRepository;
        this.ticketRepository = ticketRepository;
        this.huggingFaceService = huggingFaceService;
    }

    public Comment submitComment(String content) {
      
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setCreatedAt(LocalDateTime.now());
        
        comment = commentRepository.save(comment);

        String aiResponse = huggingFaceService.analyzeText(content);
        System.out.println("Debug Purposes - AI Answer: " + aiResponse);

        if (aiResponse != null && aiResponse.toUpperCase().contains("YES")) {
            Ticket ticket = new Ticket();
            ticket.setCreatedAt(LocalDateTime.now());
            
            ticket.setTitle("Support Request");
            ticket.setCategory("Other");
            ticket.setPriority("Medium");
            ticket.setSummary(content);

            try{
                for (String line : aiResponse.split("\n")){
             
                    if (line == null || !line.contains(":")) continue;

                    String[] parts = line.split(":", 2);
                    if (parts.length < 2) continue;

                    String key = parts[0].toUpperCase().trim();
                    String value = parts[1].trim();

                    if (key.contains("TITLE")) ticket.setTitle(value);
                    else if (key.contains("CATEGORY")) ticket.setCategory(value);
                    else if (key.contains("PRIORITY")) ticket.setPriority(value);
                    else if (key.contains("SUMMARY")) ticket.setSummary(value);
                }
            }catch (Exception e) {
                System.out.println("Error while parsing the answer by AI. Default values are used.");
            }

            ticket = ticketRepository.save(ticket);
            comment.setTicket(ticket);
            
            comment = commentRepository.save(comment);
        }
        
        return comment;
    }
}