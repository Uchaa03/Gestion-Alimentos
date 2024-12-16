package com.ucha.gestionalimentos.dto.alimento;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter
public class MoverAlimentoDTO {
        private Long alimentoId;
        private Long ubicacionOrigenId;
        private Long ubicacionDestinoId;
        private Long cantidad;
}
