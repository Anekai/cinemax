
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
        
//        CargoService service = SpringConfig.context.getBean(CargoService.class);
//
//        Cargo entity = new Cargo();
//
//        entity.setNome("Gerente");
//        entity.setFuncionalidade("Gerenciar");
//        entity.setAtivo(SimNaoType.SIM);
//
        
        FuncionarioService service = SpringConfig.context.getBean(FuncionarioService.class);

        Funcionario entity = new Funcionario();

        entity.setNome("Guilherme");
        entity.setSobreNome("Maccali");
        entity.setAtivo(SimNaoType.SIM);
        entity.setCargo(new Cargo(1));
        entity.setLogin("guilherme.maccali");
        entity.setSenha("teste123");
        entity.setDataContratacao(Calendar.getInstance());
        entity.setDataNascimento(Calendar.getInstance());

        service.insert(entity);
    }
    
}
