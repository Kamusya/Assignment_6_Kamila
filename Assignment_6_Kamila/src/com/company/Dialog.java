package com.company;

interface Button{
    void render();
    void onClick();
}


// The creator class declares the factory method that must
// return an object of a product class. The creator's subclasses
// usually provide the implementation of this method.
public abstract class Dialog {
    // The creator may also provide some default implementation
    // of the factory method.
    public abstract Button createButton();
    // Note that, despite its name, the creator's primary
    // responsibility isn't creating products. It usually
    // contains some core business logic that relies on product
    // objects returned by the factory method. Subclasses can
    // indirectly change that business logic by overriding the
    // factory method and returning a different type of product
    // from it.
    public void renderWindow(){
        // Call the factory method to create a product object.
        Button okButton = createButton();
        // Now use the product.
        okButton.render();
    }

}


// Concrete creators override the factory method to change the
// resulting product's type.
class WindowsDialog extends Dialog {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
class WebDialog extends Dialog {
    @Override
    public Button createButton() {
        return new HTMLButton();
    }
}

// The product interface declares the operations that all
// concrete products must implement.

// Concrete products provide various implementations of the
// product interface.
class WindowsButton implements Button {
    public void render(){
        onClick();
    }
    public void onClick(){
    }
    // Render a button in Windows style.
    // Bind a native OS click event.
}
class HTMLButton implements Button {
    public void render() {
    }

    public void onClick() {
    }
    // Return an HTML representation of a button
    // Bind a web browser click event.

    // The application picks a creator's type depending on the
    // current configuration or environment settings.
    public static void main(String[] args) {
        configure();
    }

    static void configure() {
        if (System.getProperty("OS").equals("Windows 10")) {
            dialog = new WindowsDialog();
        } else {
            dialog = new WebDialog();
        }
    }
}