package tech.viniciusdias.freteflex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.viniciusdias.freteflex.controller.dto.ShippingResponse;
import tech.viniciusdias.freteflex.controller.domain.ShippingType;
import tech.viniciusdias.freteflex.service.ShippingService;

@RestController()
@RequestMapping("/shipping")
public class ShippingController {
    private final ShippingService shippingService;

    public ShippingController(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    @GetMapping(value = "/calculate")
    public ResponseEntity<ShippingResponse> calculte(@RequestParam ShippingType shippingType,
                                                     @RequestParam Double distance,
                                                     @RequestParam Double weight) {
        Double cost = shippingService.calculate(shippingType, distance, weight);
        return ResponseEntity.ok(new ShippingResponse(cost));
    }
}
