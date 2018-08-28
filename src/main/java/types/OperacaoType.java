
package types;

public enum OperacaoType {
    
    INSERT("Insert"),
    UPDATE("Update"),
    DELETE("Delete");

    private String value;

    private OperacaoType(String value) {
        setValue(value);
    }

    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }
    
}
