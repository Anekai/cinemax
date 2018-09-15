
package types;

public enum TelaType {
    
    GENEROS("Gêneros"),
    FUNCIONARIOS("Funcionarios");

    private String value;

    private TelaType(String value) {
        setValue(value);
    }

    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }
    
}
