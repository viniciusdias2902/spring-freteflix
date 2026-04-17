package tech.viniciusdias.freteflex.controller.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class StandardShippingCalculator implements ShippingCalculator{
    @Override
    public Double calculate(Double distance, Double weight) {
        return weight * 1 + distance * 0.5;
    }
}
