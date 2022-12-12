package app.prog.controller;

import app.prog.controller.mapper.AuthorRestMapper;
import app.prog.controller.mapper.BookRestMapper;
import app.prog.controller.response.*;
import app.prog.model.AuthorEntity;
import app.prog.model.BookEntity;
import app.prog.service.AuthorService;
import app.prog.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class AuthorController {
    private final AuthorService service;
    private final AuthorRestMapper mapper;

    @GetMapping("/auhtor")
    public List<AuthorResponse> getAuth() {
        return service.getAuth().stream()
                .map(mapper::toRest)
                .toList();
    }

    @PostMapping("/author")
    public List<AuthorResponse> createBooks(@RequestBody List<CreateAuthorResponse> toCreate) {
        List<AuthorEntity> domain = toCreate.stream()
                .map(mapper::toDomain)
                .toList();
        return service.createAuthor(domain).stream()
                .map(mapper::toRest)
                .toList();
    }

    @PutMapping("/author")
    public List<AuthorResponse> updateAuthor(@RequestBody List<UpdateAuthorResponse> toUpdate) {
        List<AuthorEntity> domain = toUpdate.stream()
                .map(mapper::toDomain)
                .toList();
        return service.updateAuhtor(domain).stream()
                .map(mapper::toRest)
                .toList();
    }

    @DeleteMapping("/auhtor/{authorId}")
    public AuthorResponse deleteAuthor(@PathVariable Integer authorId) {
        return mapper.toRest(service.deleteAuthor(authorId));
    }
}
