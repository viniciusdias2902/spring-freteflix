package tech.viniciusdias.freteflex.service;

import org.springframework.stereotype.Service;
import tech.viniciusdias.freteflex.controller.domain.ExpressShippingCalculator;
import tech.viniciusdias.freteflex.controller.domain.StandardShippingCalculator;
import tech.viniciusdias.freteflex.controller.dto.ShippingType;

import static tech.viniciusdias.freteflex.controller.dto.ShippingType.EXPRESS;
import static tech.viniciusdias.freteflex.controller.dto.ShippingType.STANDARD;

@Service
public class ShippingService {
    private final StandardShippingCalculator standardShippingCalculator;
    private final ExpressShippingCalculator expressShippingCalculator;

    public ShippingService(StandardShippingCalculator standardShippingCalculator, ExpressShippingCalculator expressShippingCalculator) {
        this.standardShippingCalculator = standardShippingCalculator;
        this.expressShippingCalculator = expressShippingCalculator;
    }

    public Double calculate(ShippingType shippingType, Double distance, Double weight) {
        if (shippingType == STANDARD) {
            return standardShippingCalculator.calculate(distance, weight);
        }else if (shippingType == EXPRESS) {
            return expressShippingCalculator.calculate(distance, weight);
        }
        return 0.0;
    }
}
