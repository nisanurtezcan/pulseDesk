package com.nisa.myPulseDeskProject.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.nisa.myPulseDeskProject.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long>{

}


