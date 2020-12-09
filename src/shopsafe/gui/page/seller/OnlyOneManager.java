package shopsafe.gui.page.seller;

public class OnlyOneManager<E> {
    
    private E currentObj;

    public boolean noObject() {
        return currentObj == null;
    }

    public void set (E obj) {
        currentObj = obj;
    }

    public void reset() {
        currentObj = null;
    }

}
