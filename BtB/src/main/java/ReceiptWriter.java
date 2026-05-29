import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {

    public void saveReceipt(Order order) {

        File folder = new File("receipt");

        if (!folder.exists()) {
            folder.mkdirs();
        }

        String fileName = generateFileName(order);

        try {
            FileWriter writer = new FileWriter(new File(folder, fileName));

            writer.write(order.toString());

            writer.close();

            System.out.println("Receipt saved successfully!");

        } catch (IOException e) {
            System.out.println("Error saving receipt.");
            System.out.println(e.getMessage());
        }
    }

    private String generateFileName(Order order) {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");

        return order.getOrderTime().format(formatter) + ".txt";
    }
}
