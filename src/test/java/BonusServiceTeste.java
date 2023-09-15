import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.BonusService;

public class BonusServiceTeste {
    
    @Test
    void bonusDeveriaSerZeroParaFuncionariosComSalarioMuitoAlto(){
        BonusService service = new BonusService();
        //Forma simples
        Assertions.assertThrows(IllegalArgumentException.class,
        () -> service.calcularBonus(new Funcionario("Pedro", LocalDate.now(), new BigDecimal ("25000"))));
    
        //Segunda forma, verifica se a mensagem da exception esta de acordo
        // try {
        //     service.calcularBonus(new Funcionario("Pedro", LocalDate.now(), new BigDecimal ("25000")));
        //     fail("ERRO! Passou, nao deu a exception");
        // } catch (Exception e) {
        //     Assertions.assertEquals("Funcionario com salario com mais de 10mil nao pode receber bonus", e.getMessage());
        // }
    }

    @Test
    void bonusDeveriaSerDezPorCentoDoSalario(){
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Pedro", LocalDate.now(), new BigDecimal ("2500")));

        Assertions.assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    void bonusDeveriaSerDezPorCentroParaSalarioExatamenteAteMil(){
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Pedro", LocalDate.now(), new BigDecimal ("10000")));

        Assertions.assertEquals(new BigDecimal("1000.00"), bonus);
    }


}
