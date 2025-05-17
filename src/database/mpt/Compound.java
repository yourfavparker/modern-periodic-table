/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database.mpt;

/**
 *
 * @author Yousef
 */
public class Compound {
     private String name;
    private String formula;
    private String properties;

    public Compound(String name, String formula, String properties) {
        this.name = name;
        this.formula = formula;
        this.properties = properties;
    }

    public String getName() { return name; }
    public String getFormula() { return formula; }
    public String getProperties() { return properties; }

    public void setName(String name) { this.name = name; }
    public void setFormula(String formula) { this.formula = formula; }
    public void setProperties(String properties) { this.properties = properties; }
}
    

