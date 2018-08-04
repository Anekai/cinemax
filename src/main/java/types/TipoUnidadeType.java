/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package types;

/**
 *
 * @author alexa
 */
public enum TipoUnidadeType {
    
    ATIVO("Ativo"),
    INATIVO("Inativo");

    private String value;

    private TipoUnidadeType(String value) {
        setValue(value);
    }

    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }
    
}
