package moomint.toy.github_grass_text_maker.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GithubManager {

    public File commiter(String commitDate) {

        File commitFileLocation = new File("commitFileLocation");
        if (!commitFileLocation.exists()) {
            System.out.println("해당 디렉토리가 존재하지 않아 디렉토리를 생성합니다.");
            commitFileLocation.mkdir();
        }

        File file = new File(commitFileLocation, "text.txt");
        try (FileWriter writer = new FileWriter(file)) {
            writer.write("This is a commit test file.");
        } catch (IOException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }

        try {
            runCommand("git init", commitFileLocation);  // 필요시 리포지토리 초기화
            runCommand("git add text.txt", commitFileLocation);
            runCommand(String.format("git commit -m \"Initial commit\" --date=\"%s\"", commitDate), commitFileLocation);

            if (file.delete()) {
                runCommand("git add -u", commitFileLocation);
                runCommand(String.format("git commit -m \"Delete text.txt\" --date=\"%s\"", commitDate), commitFileLocation);
            } else {
                System.err.println("파일 삭제 실패");
            }

            System.out.println(commitDate + " Commit 완료");
        } catch (IOException | InterruptedException e) {
            System.out.println("failed commit: " + e.getMessage());
            throw new RuntimeException(e);
        }

        return commitFileLocation;
    }

    public void pusher(String repoUrl, File commitFileLocation) {
        try {
            runCommand("git remote add origin " + repoUrl, commitFileLocation);
            runCommand("git branch -M main", commitFileLocation);
            runCommand("git push -u origin main", commitFileLocation);
        } catch (IOException | InterruptedException e) {
            System.out.println("failed push: " + e.getMessage());
            throw new RuntimeException(e);
        }

        System.out.println("작업이 완료되었습니다.");
    }

    private void runCommand(String command, File workDir) throws IOException, InterruptedException {
        ProcessBuilder builder = new ProcessBuilder();
        builder.command("cmd.exe", "/c", command);
        builder.directory(workDir);  // 작업 디렉토리 설정
        builder.redirectErrorStream(true);
        Process process = builder.start();
        process.waitFor();
    }
}
