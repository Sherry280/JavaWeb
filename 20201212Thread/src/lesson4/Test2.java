package lesson4;

class Shape {
    private int x;
    private int y;
    public Shape(int x,int y){
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
class Rectangle extends Shape{

    public Rectangle(int x, int y) {
        super(x, y);
    }
    public int GetArea(int x,int y){
        int Area=x*y;
        return Area;
    }


}


class Circle extends Shape{

    public Circle(int x, int y) {
        super(x, y);
    }
}