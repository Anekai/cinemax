package log;

import java.io.*;
import java.util.Vector;
import java.util.Date;
import java.text.SimpleDateFormat;

public class ArquivoLog {

    File arquivo;
    FileReader fileReader;
    BufferedReader bufferedReader;
    FileWriter fileWritter;
    BufferedWriter bufferedWriter;

    public ArquivoLog(String erros)
    {
        escreverLog(erros);
    }

    private void escreverLog(String erros)
    {
        try {
            
            Date data = new Date();
            SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
            formatador.format(data);
            
            arquivo = new File("exceptions.log");
            fileReader = new FileReader(arquivo);
            bufferedReader = new BufferedReader(fileReader);
            Vector texto = new Vector();
            while (bufferedReader.ready()){
                texto.add(bufferedReader.readLine());
            }
            fileWritter = new FileWriter(arquivo);
            bufferedWriter = new BufferedWriter(fileWritter);
            for (int i = 0; i<texto.size();i++){
                bufferedWriter.write(texto.get(i).toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.write(erros);
            bufferedReader.close();
            bufferedWriter.close();

        }
        catch (FileNotFoundException e) {
            try {
                arquivo.createNewFile();
                escreverLog(erros);
            } catch (IOException e1) {
                System.out.println("oi");
                System.exit(0);
            }
            System.out.println("file");
        }
        catch (IOException er)
        {
            System.out.println("OI");
            System.exit(0);
        }
    }
}
