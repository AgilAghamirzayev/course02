package az.texnoera.lesson31controller.model.response;

import java.math.BigDecimal;
import java.util.UUID;

public record CardItemResponse(
        UUID id,
        String productName,
        String productCode,
        BigDecimal unitPrice,
        Integer quantity,
        String imageUrl
) {

}
