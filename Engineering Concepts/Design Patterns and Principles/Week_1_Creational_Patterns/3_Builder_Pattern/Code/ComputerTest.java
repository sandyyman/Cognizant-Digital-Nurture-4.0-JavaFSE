public class ComputerTest {
    public static void main(String[] args) {
        Computer computer1 = new Computer.Builder()
                .setCPU("Intel i7")
                .setRAM("16GB")
                .setStorage("1TB SSD")
                .setGPU("NVIDIA RTX 3060")
                .build();

        Computer computer2 = new Computer.Builder()
                .setCPU("AMD Ryzen 5")
                .setRAM("8GB")
                .setStorage("512GB SSD")
                .setGPU("Integrated")
                .build();

        System.out.println("Computer 1:");
        System.out.println(computer1);
        System.out.println("\nComputer 2:");
        System.out.println(computer2);
    }
}
