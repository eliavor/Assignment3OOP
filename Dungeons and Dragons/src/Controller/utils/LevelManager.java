package Controller.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LevelManager {
    private List<String> levelPaths;
    private int currentLevel;

    public LevelManager(String directoryPath) {
        File levelsDir = new File(directoryPath);
        if (!levelsDir.isDirectory()) {
            throw new IllegalArgumentException("Invalid directory path.");
        }

        File[] levelFiles = levelsDir.listFiles((dir, name) -> name.endsWith(".txt"));
        if (levelFiles == null || levelFiles.length == 0) {
            throw new IllegalArgumentException("No level files found in the directory.");
        }

        Arrays.sort(levelFiles, (f1, f2) -> {
            String name1 = f1.getName().replaceAll("\\D+", "");
            String name2 = f2.getName().replaceAll("\\D+", "");
            return Integer.parseInt(name1) - Integer.parseInt(name2);
        });

        levelPaths = new ArrayList<>();
        for (File file : levelFiles) {
            levelPaths.add(file.getAbsolutePath());
        }
        currentLevel = 0;
    }

    public boolean hasLevels() {
        return !levelPaths.isEmpty();
    }

    public String getNextLevelContent() {
        if (currentLevel >= levelPaths.size()) {
            return null;
        }

        String path = levelPaths.get(currentLevel);
        String content;
        try {
            content = new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            throw new RuntimeException("Error while reading the levels file: " + e.getMessage());
        }
        currentLevel++;
        return content;
    }
}
