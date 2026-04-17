package tech.viniciusdias.freteflex.service;

import org.springframework.stereotype.Service;
import tech.viniciusdias.freteflex.controller.domain.ExpressShippingCalculator;
import tech.viniciusdias.freteflex.controller.domain.StandardShippingCalculator;
import tech.viniciusdias.freteflex.controller.domain.ShippingType;

import static tech.viniciusdias.freteflex.controller.domain.ShippingType.EXPRESS;
import static tech.viniciusdias.freteflex.controller.domain.ShippingType.STANDARD;

@Service
public class ShippingService {
    private final StandardShippingCalculator standardShippingCalculator;
    private final ExpressShippingCalculator expressShippingCalculator;

    public ShippingService(StandardShippingCalculator standardShippingCalculator, ExpressShippingCalculator expressShippingCalculator) {
        this.standardShippingCalculator = standardShippingCalculator;
        this.expressShippingCalculator = expressShippingCalculator;
    }

    public Double calculate(ShippingType shippingType, Double distance, Double weight) {
        return switch (shippingType) {
            case STANDARD -> standardShippingCalculator.calculate(distance, weight);
            case EXPRESS -> expressShippingCalculator.calculate(distance, weight);
            default -> null;
        };
    }
}
