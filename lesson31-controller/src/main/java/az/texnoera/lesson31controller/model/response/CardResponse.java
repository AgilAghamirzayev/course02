package az.texnoera.lesson31controller.model.response;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record CardResponse(
        UUID id,
        List<CardItemResponse> items,
        BigDecimal subtotal,
        BigDecimal taxAmount,
        BigDecimal totalAmount
) {
}
