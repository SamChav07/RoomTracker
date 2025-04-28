package com.uam.springboot.manager.app.repository.solicitud;

import com.uam.springboot.manager.app.model.solicitud.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
