package kg.gov.mf.loan.doc.model;

import kg.gov.mf.loan.task.model.Catalog;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="cat_content_parameter")
public class ContentParameter extends Catalog {

    private int position;
    private String format;
    private long systemObjectTypeId;
    private String fieldName;
    private int fieldPosition;
    private long fieldTypeId;
    private long classificator;
    private double constantValue;
    private String constantText;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public long getSystemObjectTypeId() {
        return systemObjectTypeId;
    }

    public void setSystemObjectTypeId(long systemObjectTypeId) {
        this.systemObjectTypeId = systemObjectTypeId;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public int getFieldPosition() {
        return fieldPosition;
    }

    public void setFieldPosition(int fieldPosition) {
        this.fieldPosition = fieldPosition;
    }

    public long getFieldTypeId() {
        return fieldTypeId;
    }

    public void setFieldTypeId(long fieldTypeId) {
        this.fieldTypeId = fieldTypeId;
    }

    public long getClassificator() {
        return classificator;
    }

    public void setClassificator(long classificator) {
        this.classificator = classificator;
    }

    public double getConstantValue() {
        return constantValue;
    }

    public void setConstantValue(double constantValue) {
        this.constantValue = constantValue;
    }

    public String getConstantText() {
        return constantText;
    }

    public void setConstantText(String constantText) {
        this.constantText = constantText;
    }
}
