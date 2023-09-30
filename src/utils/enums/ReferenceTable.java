package utils.enums;

/*
 * Enums provide abstraction, encapsulation, better readability, maintainability 
 * and flexibility to the codebase. 
 * E.g., If in the future we want to do NumericEncoding,
 * we can easily use the ReferenceTable.NUMBERS constant to do it. 
 */
public enum ReferenceTable {
    ALPHABET("ABCDEFGHIJKLMNOPQRSTUVWXYZ"),
    NUMBERS("0123456789"),
    SYMBOLS("()*+,-./"),
    CUSTOM("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789()*+,-./");

    private final String table;

    ReferenceTable(String table) {
        this.table = table;
    }

    public String getTable() {
        return table;
    }
}