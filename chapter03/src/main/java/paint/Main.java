package paint;

public class Main {

	public static void main(String[] args) {
        Point point1 = new Point();
        point1.setX(10);
        point1.setY(10);
        
        //drawPoint(point1);
        //point1.disapear();
        //point1.show();
        point1.show(false);
        draw(point1);
        
        Point point2 = new ColorPoint();
        point2.setX(100);
        point2.setY(200);
        ((ColorPoint)point2).setColor("red");  //다운캐스팅
//        drawPoint(point2);
        draw(point2);
        
        point2.show(false);
        point2.show(true);
        
        Triamgle triangle = new Triamgle();
//        drawTriamgle(triangle)
//        drawShape(triangle);
        draw(triangle);
        Rectangle rect = new Rectangle();
//      drawTriamgle(rect)
        //        drawShape(rect);
        draw(rect);
        
        Circle circle = new Circle();
//      drawTriamgle(circle)
        //        drawShape(circle);
        draw(circle);
	}
	
	public static void draw(Drawable drawable) {
		drawable.draw();
	}
	
//	public static void drawPoint(Point point) {
//		point.show();
//	}
	
//	public static void drawcolorPoint(ColorPoint colorPoint) {
//		colorPoint.show();
//	}
	
//	public static void drawShape(Shape shape) {
//		shape.draw();
//	}
//	
//	public static void drawTriangle(Triamgle triangle) {
//		triangle.draw();
//	}
//	
//	public static void drawRectangle(Rectangle rectangle) {
//		rectangle.draw();
//	}
//	
//	public static void drawCircle(Circle circle) {
//		circle.draw();
//	}
}
