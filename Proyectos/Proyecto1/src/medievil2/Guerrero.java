/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medievil2;
import java.io.Serializable;
/**
 *
 * @author 22437
 */
public class Guerrero extends Personaje implements Serializable{
    public Guerrero(){
        super("Guerrero", 2, 2, false);
    }
}
