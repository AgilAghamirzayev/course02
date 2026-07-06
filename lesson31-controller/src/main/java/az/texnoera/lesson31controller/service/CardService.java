package az.texnoera.lesson31controller.service;

import az.texnoera.lesson31controller.model.response.CardItemResponse;
import az.texnoera.lesson31controller.model.response.CardResponse;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class CardService {
    public CardResponse getCard(String gestSessionId) {
        return new CardResponse(
                UUID.randomUUID(),
                List.of(new CardItemResponse(
                        UUID.randomUUID(),
                        "Card 1",
                        "Card 1 description",
                        BigDecimal.TEN,
                        2,
                        "test.html"
                )),
                BigDecimal.TWO,
                BigDecimal.TEN,
                BigDecimal.TEN
        );
    }
}
