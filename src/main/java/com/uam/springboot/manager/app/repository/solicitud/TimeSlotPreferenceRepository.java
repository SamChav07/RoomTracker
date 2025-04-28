package com.uam.springboot.manager.app.repository.solicitud;

import com.uam.springboot.manager.app.model.solicitud.TimeSlotPreference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeSlotPreferenceRepository extends JpaRepository<TimeSlotPreference, Long> {
}
