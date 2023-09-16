import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.ReajusteService;

public class ReajusteServiceTeste {
    ReajusteService service;
    Funcionario funcionario;
    
    @BeforeEach //anotacao que executa antes de fazer todos os testes
    void inicializar() {
        this.service = new ReajusteService();
        this.funcionario = new Funcionario("Pedro", LocalDate.now(), new BigDecimal("1000.00"));
    }

    //Se o desempenho for classificado como "A desejar", o reajuste será de 3% do salário atual.
    @Test
    public void reajusteDeveriaSerDeTresPorCentoQuandoDesempenhoForADesejar() {      
        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);

        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    // Se o desempenho for "Bom,", o reajuste será de 15% do salário.
    @Test
    public void reajusteDeveriaSerDeQuinzePorCentoQuandoDesempenhoForBom() {
        service.concederReajuste(funcionario, Desempenho.BOM);

        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }    

    // Se o desempenho for "Ótimo", o reajuste será de 20% do salário.
    @Test
    public void reajusteDeveriaSerDeVintePorCentoQuandoDesempenhoForOtimo() {
        service.concederReajuste(funcionario, Desempenho.OTIMO);

        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
}
