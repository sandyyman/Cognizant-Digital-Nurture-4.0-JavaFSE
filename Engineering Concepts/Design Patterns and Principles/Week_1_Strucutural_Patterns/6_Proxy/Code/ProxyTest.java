public class ProxyTest {
    public static void main(String[] args) {
        Image image = new ProxyImage("landscape.jpg");

        // First access: image is loaded
        image.display();

        // Second access: uses cached image
        image.display();
    }
}
