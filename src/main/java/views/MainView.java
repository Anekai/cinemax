
package views;

import configuration.SpringConfig;
import entities.Cargo;
import entities.Funcionario;
import java.util.Calendar;
import services.CargoService;
import services.FuncionarioService;
import services.ProdutoService;
import types.SimNaoType;

public class MainView {
    
    public static void main(String[] args) {
        FuncionarioService service = SpringConfig.context.getBean(FuncionarioService.class);

        Funcionario entity = new Funcionario();

        entity.setNome("Alexandre");
        entity.setSobreNome("Klabunde");
        entity.setAtivo(SimNaoType.SIM);
        entity.setCargo(new Cargo(3));
        entity.setLogin("alexandre.klabunde");
        entity.setSenha("teste123");
        entity.setDataContratacao(Calendar.getInstance());
        entity.setDataNascimento(Calendar.getInstance());

        service.find();
    }
    
}
