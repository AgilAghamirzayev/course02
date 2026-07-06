package az.texnoera.lesson31controller.controller;

import az.texnoera.lesson31controller.model.response.CardResponse;
import az.texnoera.lesson31controller.service.CardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cards")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping
    public CardResponse getCard(@RequestHeader(value = "X-Guest-Session-Id", required = false) String gestSessionId) {
        return cardService.getCard(gestSessionId);
    }
}
