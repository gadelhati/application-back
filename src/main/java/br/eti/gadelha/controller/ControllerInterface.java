package br.eti.gadelha.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

public interface ControllerInterface<T, S> {
    public ResponseEntity<T> create(@RequestBody @Valid S created);
    public List<T> retrieve();
    public ResponseEntity<Page<T>> retrieve(Pageable pageable);
    public ResponseEntity<T> retrieve(@PathVariable UUID id);
    public ResponseEntity<Page<T>> retrieve(Pageable pageable, @RequestParam(required = false) String q);
    public ResponseEntity<T> update(@PathVariable("id") UUID id, @RequestBody @Valid S updated);
    public ResponseEntity<T> delete(@PathVariable UUID id);
    public ResponseEntity<HttpStatus> delete();
}