package org.example;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

public class CalculatorTests {
    @Test
    public void add_addingMoreThan2Numbers_returnsCorrectResult(){
        // to będzie test „czarnej skrzynki”
        Subcalculator subcalculator = new Subcalculator();
        Calculator calc = new Calculator(subcalculator);
        int result = calc.Add(1,2,3,50);
        assertThat(result).isEqualTo(56);
    }
    @Test
    public void add_addingMoreThan2Numbers_correctlyCallsSubcalculator(){
        // to będzie test „białej skrzynki”
        Subcalculator subcalculator = mock(Subcalculator.class);
        Calculator calc = new Calculator(subcalculator);

        calc.Add(1,2,5);

        verify(subcalculator, times(3)).Add(anyInt(), anyInt());
        verify(subcalculator, times(1)).Add(0,1);
        verify(subcalculator, times(1)).Add(0,2);
        verify(subcalculator, times(1)).Add(0,5);


    }
}

