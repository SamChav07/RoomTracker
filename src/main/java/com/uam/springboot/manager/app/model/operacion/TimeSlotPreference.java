package com.uam.springboot.manager.app.model.operacion;

import com.uam.springboot.manager.app.model.catalogos.BloqueHorario;
import com.uam.springboot.manager.app.model.Identifiable;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="time_slot_preference")
@Getter
@Setter
public class TimeSlotPreference extends Identifiable {

    @ManyToOne(optional=false)
    private SolicitudItem solicitudItem;

    @ManyToOne(optional=false)
    private BloqueHorario timeSlot;

    @Min(1)
    @Max(10)
    private Integer prioridad; // 1–10
}
