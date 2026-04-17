package tech.viniciusdias.freteflex.controller.domain;

public interface ShippingCalculator {
    Double calculate(Double distance, Double weight);
}
