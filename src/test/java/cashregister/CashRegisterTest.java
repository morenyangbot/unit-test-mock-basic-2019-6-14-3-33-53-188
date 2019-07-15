package cashregister;


import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class CashRegisterTest {


    @Test
    public void should_print_the_real_purchase_when_call_process() {

        //given
        Printer mockPrinter = mock(Printer.class);
        CashRegister cashRegister = new CashRegister(mockPrinter);

        //when
        cashRegister.process(new Purchase(new Item[]{}));

        //then
        verify(mockPrinter, times(1)).print("");
        verify(mockPrinter, never()).print("Something cool");
    }

    @Test
    public void should_print_the_stub_purchase_when_call_process() {
        //given
        Printer mockPrinter = mock(Printer.class);
        CashRegister cashRegister = new CashRegister(mockPrinter);
        Purchase purchase = mock(Purchase.class);
        when(purchase.asString()).thenReturn("");
        //when
        cashRegister.process(purchase);
        //then
        verify(mockPrinter, times(1)).print("");
        verify(mockPrinter, never()).print("Something cool");
    }

    @Test
    public void should_verify_with_process_call_with_mockito() {
        //given
        Purchase purchase = mock(Purchase.class);
        when(purchase.asString()).thenReturn("");
        CashRegister cashRegister = mock(CashRegister.class);
        //when
        cashRegister.process(purchase);
        //then
        verify(cashRegister, times(1)).process(purchase);
    }

}
