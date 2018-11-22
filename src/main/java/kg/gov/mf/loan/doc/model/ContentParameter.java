package kg.gov.mf.loan.doc.model;

import kg.gov.mf.loan.task.model.Catalog;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="cat_content_parameter")
public class ContentParameter extends Catalog {

    private int position;
    private String format;
    private Long systemObjectTypeId;
    private String fieldName;
    private int fieldPosition;
    private Long fieldTypeId;
    private Long classificator;
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

    public Long getSystemObjectTypeId() {
        return systemObjectTypeId;
    }

    public void setSystemObjectTypeId(Long systemObjectTypeId) {
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

    public Long getFieldTypeId() {
        return fieldTypeId;
    }

    public void setFieldTypeId(Long fieldTypeId) {
        this.fieldTypeId = fieldTypeId;
    }

    public Long getClassificator() {
        return classificator;
    }

    public void setClassificator(Long classificator) {
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
