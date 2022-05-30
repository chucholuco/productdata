package com.bharath.springdata.product;

import com.bharath.springdata.product.entities.Image;
import com.bharath.springdata.product.repos.ImageRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;

@SpringBootTest
public class FileDataApplicationTests {

    @Autowired
    ImageRepository repository;

    @Test
    public void testImageTest() throws IOException {
        Image image = new Image();
        image.setId(1L);
        image.setName("butterfly.jpg");

        File file = new File("C:\\Users\\tapia\\Downloads\\butterfly.jpg");
        byte fileContent[] = new byte[(int) file.length()];
        FileInputStream inputStream = new FileInputStream(file);
        inputStream.read(fileContent);

        image.setData(fileContent);

        repository.save(image);

        inputStream.close();

    }

    @Test
    public void testReadImage() {
        Image image = repository.findById(1L).get();
        File file = new File("C:\\Users\\tapia\\Downloads\\test_downloaded\\"+image.getName());
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
            outputStream.write(image.getData());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
