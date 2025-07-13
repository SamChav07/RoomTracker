package com.uam.springboot.manager.app.controller;

import lombok.RequiredArgsConstructor;
import org.apache.commons.text.WordUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/metadata")
@RequiredArgsConstructor
public class MetadataController {

    private final ApplicationContext ctx;              // para buscar controllers

    @GetMapping("/{paquete}/{dto}")
    public Map<String,Object> metadata(
            @PathVariable String paquete,
            @PathVariable String dto) throws ClassNotFoundException {

        Class<?> dtoClass = Class.forName(
                "com.uam.springboot.manager.app.dto." + paquete + ".requestDTOs." + dto);

        Map<String,Object> meta = new LinkedHashMap<>();
        meta.put("entity", dto);

        /* ---------- 1. baseUrl ------------------------------------------------ */
        String base = calcularBaseUrl(dtoClass);
        meta.put("baseUrl", base);

        /* ---------- 2. fields ------------------------------------------------- */
        List<Map<String,Object>> fields = new ArrayList<>();
        for (Field f : dtoClass.getDeclaredFields()) {
            if (f.getName().equals("id")) continue;

            Map<String,Object> fd = new LinkedHashMap<>();
            fd.put("name", f.getName());
            fd.put("label", WordUtils.capitalizeFully(f.getName().replaceAll("([A-Z])"," $1")));
            fd.put("type", mapJavaType(f.getType()));

            if (f.getType().isEnum()) {
                fd.put("enumValues",
                        Stream.of(f.getType().getEnumConstants()).map(Object::toString).toList());
            }
            if (Set.class.isAssignableFrom(f.getType())) {
                fd.put("multiple", true);
            }
            fields.add(fd);
        }
        meta.put("fields", fields);
        return meta;
    }

    /* ---------- helpers ------------------------------------------------------ */
    private String calcularBaseUrl(Class<?> dtoClass) {
        /* 1) Si lleva @CrudMeta → lo usamos */
        CrudMeta ann = dtoClass.getAnnotation(CrudMeta.class);
        if (ann != null) return ann.baseUrl();

        /* 2) Si existe un Controller cuyo nombre contiene la entidad */
        String possible = buscarUrlEnControllers(dtoClass.getSimpleName().replace("RequestDTO",""));
        if (possible != null) return possible;

        /* 3) Fallback: pluralización simple + excepciones */
        return "/" + pluralizar(dtoClass.getSimpleName()
                .replace("RequestDTO","")
                .toLowerCase());
    }

    private String buscarUrlEnControllers(String entityRaw) {
        return ctx.getBeansWithAnnotation(RestController.class).values().stream()
                .map(Object::getClass)
                .filter(c -> c.getSimpleName().toLowerCase().contains(entityRaw.toLowerCase()))
                .map(c -> c.getAnnotation(RequestMapping.class))
                .filter(Objects::nonNull)
                .flatMap(a -> Arrays.stream(a.value()))
                .findFirst().orElse(null);
    }

    private static final Map<String,String> IRREGULARES = Map.of(
            "coordinador", "coordinadores",
            "profesor",    "profesores"
    );
    private String pluralizar(String palabra) {
        if (IRREGULARES.containsKey(palabra)) return IRREGULARES.get(palabra);
        // reglas muy básicas de castellano
        if (palabra.endsWith("z")) return palabra.substring(0,palabra.length()-1) + "ces";
        if (palabra.endsWith("r") || palabra.endsWith("n") || palabra.endsWith("d"))
            return palabra + "es";
        return palabra + "s";
    }

    private String mapJavaType(Class<?> t) {
        return switch (t.getSimpleName()) {
            case "Boolean","boolean" -> "boolean";
            case "Integer","Long","int","long" -> "int";
            default -> t.isEnum() ? "enum" : "string";
        };
    }
}

