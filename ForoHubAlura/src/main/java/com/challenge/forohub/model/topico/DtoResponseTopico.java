package com.challenge.forohub.model.topico;

public record DtoResponseTopico(
        Long id,
        String titulo,
        String mensaje,
        String autor,
        String curso
) {
}