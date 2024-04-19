package edu.um.eduadventspring.Manager;

import java.util.List;

import edu.um.eduadventspring.Model.Union;

public interface UnionManager {
    
    List<Union> getUnionList();

    Union getUnionByEscuela(String escuelaId);

    Union getUnionById(Long id);
}
