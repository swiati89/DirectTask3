package service.product.impl;

import model.Attribute;
import model.AttributeGroup;
import service.product.Attributable;
import service.product.AttributePrinter;

public class AttributePrinterImpl implements AttributePrinter {

    private static final String ATTRIBUTE_LABEL = "*Single attribute ";

    public void printAttributes(AttributeGroup attributeGroup, int textShift) {
        String format = returnFormat(textShift);
        System.out.printf(format, "+-" + attributeGroup.getGroupName() + " begin-+");
        for(Attributable attributeOrList : attributeGroup.getAttributes()){
            if(attributeOrList instanceof Attribute){
                textShift--;
                Attribute attribute = (Attribute) attributeOrList;
                printSingleAttributeData(attribute, format);
            } else if (attributeOrList instanceof AttributeGroup) {
                textShift++;
                AttributeGroup innerAttributeGroup = (AttributeGroup) attributeOrList;
                printAttributes(innerAttributeGroup, textShift);
            }
        }
        System.out.printf(format, "+-" + attributeGroup.getGroupName() + " end-+");
    }

    private void printSingleAttributeData(Attribute attribute, String format) {
        System.out.printf("\t".concat(format),
                ATTRIBUTE_LABEL + attribute.getName() + " = " + attribute.getValue() + "*");
    }

    private String returnFormat (int numOfTabs){
        String tabFormat = "%1$-40s%n";
        for(int i = 0; i<numOfTabs; i++){
            tabFormat = "\t".concat(tabFormat);
        }

        return tabFormat;
    }

}
