package com.challenge.forohub.model.topico;

import jakarta.validation.constraints.NotBlank;

public record DtoActualizarTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotBlank
        String autor,
        @NotBlank
        String curso) {
}
