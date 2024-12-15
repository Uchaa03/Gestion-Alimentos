package com.ucha.gestionalimentos.dto.alimento;

import lombok.Data;

@Data
public class MoverAlimentoDTO {
        private Long alimentoId;
        private Long ubicacionOrigenId;
        private Long ubicacionDestinoId;
        private Long cantidad;
}
