package com.example.task02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Task02Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        //здесь вы можете вручную протестировать ваше решение, вызывая реализуемый метод и смотря результат
        // например вот так:


        System.out.println(listFiles(Paths.get("task02/src/main/resources/")));


    }

    public static List<Path> listFiles(Path rootDir) throws IOException, InterruptedException {
        List<Path> paths = new ArrayList<>();

        try (Stream<Path> pathStream = Files.list(rootDir)) {
            pathStream.forEach(path -> {
                if(Files.isDirectory(path)) {
                    try {
                        paths.addAll(listFiles(path));
                    } catch (IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                if(Files.isRegularFile(path))
                    paths.add(path);
            });
        }

    return paths;
    }
}
