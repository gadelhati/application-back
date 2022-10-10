package br.eti.gadelha.persistence.repository;

import java.util.List;

public interface RepositoryInterface<T> {
    List<T> findByNameContainingIgnoreCaseOrderByNameAsc(String name);
    T findByName(String name);
    boolean existsByName(String value);
}