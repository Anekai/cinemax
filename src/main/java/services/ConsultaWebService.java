
package services;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reportVO.FornecedorVO;

@Service
@Transactional
public class ConsultaWebService {
    
    public FornecedorVO consultaProdutos(String cnpj) {
        try {
            URL url = new URL("https://www.receitaws.com.br/v1/cnpj/" + cnpj);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            if (connection.getResponseCode() != 200) {
                throw new RuntimeException("HTTP error code : "+ connection.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((connection.getInputStream())));
            
            Gson gson = new Gson();
            
            FornecedorVO vo = gson.fromJson(br, FornecedorVO.class);
            
            connection.disconnect();
            
            return vo;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
}
