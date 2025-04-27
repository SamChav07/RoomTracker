package com.uam.springboot.manager.app.dto;

import java.util.Map;
import java.util.Set;

public interface RelationalRequestDTO {
    Map<String, Set<Long>> getRelationIds();
}
