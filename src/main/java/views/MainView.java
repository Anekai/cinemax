
package views;

import configuration.SpringConfig;
import services.ProdutoService;

public class MainView {
    
    public static void main(String[] args) {
        ProdutoService service = SpringConfig.context.getBean(ProdutoService.class);

        //Produto entity = new Produto();

        //entity.setNome("Alexandre Klabunde");
        //entity.setUnidade(TipoU);
        //entity.setSenha("teste123");

        service.find();
    }
    
}
