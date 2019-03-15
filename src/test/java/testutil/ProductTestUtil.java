package testutil;

import model.Attribute;
import model.AttributeGroup;
import model.Product;
import service.product.Attributable;

import java.util.ArrayList;
import java.util.List;

public class ProductTestUtil {
    public static Product prepareProductForTest(){
        Attribute attributeHeight = new Attribute("height", "24");
        Attribute attributeName = new Attribute("name", "Janusz");
        Attribute attributeSurname = new Attribute("surname", "Soft");
        Attribute attributeColor = new Attribute("color", "blue");
        Attribute attributeShape = new Attribute("shape", "rectangular");

        List<Attributable> firstAttList = new ArrayList<Attributable>();
        firstAttList.add(attributeName);
        firstAttList.add(attributeSurname);

        List<Attributable> secondAttList = new ArrayList<Attributable>();
        secondAttList.add(attributeShape);

        AttributeGroup mainAttrGroup = new AttributeGroup("Product Attributes", new ArrayList<Attributable>());
        AttributeGroup attributes1 = new AttributeGroup("Attributes 1",firstAttList);
        AttributeGroup attributes2 = new AttributeGroup("Attributes 2", new ArrayList<Attributable>());
        AttributeGroup attributes3 = new AttributeGroup("Attributes 3",secondAttList);
        mainAttrGroup.addAttributeToAttributes(attributes1);
        mainAttrGroup.addAttributeToAttributes(attributeHeight);
        attributes2.addAttributeToAttributes(attributes3);
        attributes2.addAttributeToAttributes(attributeColor);
        mainAttrGroup.addAttributeToAttributes(attributes2);

        return new Product(mainAttrGroup);
    }
}
