/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medievil2;

/**
 *
 * @author 22437
 */
public class Dimension {
    private int dim;
    private Dimension(){
    
    }

    public int getDim() {
        return dim;
    }

    public void setDim(int dim) {
        this.dim = dim;
    }

    public Dimension(int dim) {
        setDim(dim);
    }
    
    
}
