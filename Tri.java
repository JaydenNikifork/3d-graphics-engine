import java.awt.Graphics;

public class Tri {
    public Vec p1;
    public Vec p2;
    public Vec p3;
    public Vec line1;
    public Vec line2;
    public Vec line3;


    public Tri(Vec p1, Vec p2, Vec p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        line1 = new Vec(this.p2.x - this.p1.x, this.p2.y - this.p1.y, this.p2.z - this.p1.z);
        line2 = new Vec(this.p3.x - this.p2.x, this.p3.y - this.p2.y, this.p3.z - this.p2.z);
        line3 = new Vec(this.p1.x - this.p3.x, this.p1.y - this.p3.y, this.p1.z - this.p3.z);
    }


    public void setPoints(Vec p1, Vec p2, Vec p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }


    public void draw(Graphics g) {
        g.drawPolygon(new int[] {(int) p1.x + WindowConfig.SCREEN_WIDTH/2, (int) p2.x + WindowConfig.SCREEN_WIDTH/2, (int) p3.x + WindowConfig.SCREEN_WIDTH/2},
                      new int[] {(int) p1.y + WindowConfig.SCREEN_HEIGHT/2, (int) p2.y + WindowConfig.SCREEN_HEIGHT/2, (int) p3.y + WindowConfig.SCREEN_HEIGHT/2}, 3);
    }


    public Vec normal() {
        return new Vec(
            line1.y * line2.z - line1.z * line2.y,
            line1.z * line2.x - line1.x * line2.z,
            line1.x * line2.y - line1.y * line2.x
        );
    }
}
