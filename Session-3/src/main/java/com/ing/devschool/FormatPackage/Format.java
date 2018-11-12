package com.ing.devschool.FormatPackage;

import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class Format {
    private Path filePath;

    public abstract void printFormatType();
    public abstract void printFormat();

    public Path getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = Paths.get(filePath);
    }
}
