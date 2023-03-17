/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecuaciones;

/**
 *
 * @author rod06
 */
public class Triangulo {
    private int base;
    private int altura;
    private int perimetro;
    private int area;

    public Triangulo() {
    }

    public Triangulo(String base, String altura) {
        this.setBase(Integer.parseInt(base));
        this.setAltura(Integer.parseInt(altura));
    }
    
    public Triangulo(int base, int altura){
        this.setBase(base);
        this.setAltura(altura);
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getPerimetro() {
        return perimetro;
    }

    public void setPerimetro(int perimetro) {
        this.perimetro = perimetro;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }
    
    public void obtenerArea(){
        int result = this.getBase() * this.getAltura() / 2;
        this.setArea(result);
    }
    
    public void obtenerPerimetro(){
        int result = this.getBase() * 3;
        this.setPerimetro(result);
    }
}
