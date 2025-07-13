package com.uam.springboot.manager.app.service.impl.solver;

import com.uam.springboot.manager.app.dto.operacion.requestDTOs.PlantillaReservaRequestDTO;
import com.uam.springboot.manager.app.dto.solver.ReservaDTO;
import com.uam.springboot.manager.app.model.catalogos.Ambiente;
import com.uam.springboot.manager.app.model.catalogos.BloqueHorario;
import com.uam.springboot.manager.app.model.catalogos.Grupo;
import com.uam.springboot.manager.app.repository.catalogos.AmbienteRepository;
import com.uam.springboot.manager.app.repository.catalogos.BloqueHorarioRepository;
import com.uam.springboot.manager.app.repository.catalogos.GrupoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Component
@RequiredArgsConstructor
public class ReservaToPlantillaMapper {

    private final AmbienteRepository ambienteRepo;
    private final GrupoRepository grupoRepo;
    private final BloqueHorarioRepository bloqueRepo;

    /**
     * Convierte un ReservaDTO en una lista de PlantillaReservaRequestDTO.
     * <p>Si duracionBloques == 3 creará 3 request consecutivos.</p>
     */
    public List<PlantillaReservaRequestDTO> toPlantillaRequests(
            Long periodoId, ReservaDTO reserva) {

        // 1) Buscar las entidades base
        Ambiente ambiente = ambienteRepo.findByCodigo(reserva.getAmbienteCodigo())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Ambiente no encontrado: " + reserva.getAmbienteCodigo()));

        Grupo grupo = grupoRepo.findByCodigo(reserva.getGrupoCodigo())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Grupo no encontrado: " + reserva.getGrupoCodigo()));




        // 2) Desdoblar por cada bloque
        int inicio = Objects.requireNonNull(reserva.getBloqueIndice(),
                "bloqueIndice nulo en " + reserva.getGrupoCodigo());
        int dur = Objects.requireNonNull(reserva.getDuracionBloques(),
                "duracionBloques nula en " + reserva.getGrupoCodigo());

        /*if(inicio > 18){
            inicio = 18;
        }*/
        List<PlantillaReservaRequestDTO> result = new ArrayList<>(dur);

        log.info("DEBUG BloqueInicio: id={}, grupoCodigo{}=, inicioRecibido={}",
                reserva.getBloqueIndice(), reserva.getGrupoCodigo());         // lo que hoy llamas 'indice'

        for (int offset = 0; offset < dur; offset++) {
            int indiceBloque = inicio + offset;
            BloqueHorario bloque = bloqueRepo.findByIndice(indiceBloque)
                    .orElseThrow(() -> new IllegalArgumentException(
                            "Bloque horario no encontrado indice=" + indiceBloque));

            result.add(new PlantillaReservaRequestDTO(
                    periodoId,
                    reserva.getDiaSemana(),
                    ambiente.getId(),
                    bloque.getId(),
                    grupo.getId()
            ));
        }
        return result;
    }
}
