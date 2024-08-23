package moomint.toy.github_grass_text_maker.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class GithubManager {

    public File commiter(String commitDate) {

        File commitFileLocation = new File("commitFileLocation");
        if (!commitFileLocation.exists()) {
            System.out.println("해당 디렉토리가 존재하지 않아 디렉토리를 생성합니다.");
            commitFileLocation.mkdir();
        }

        System.out.println("생성할 파일의 타입을 선택하세요.");
        System.out.println("1. 자바");
        System.out.println("2. 파이썬");
        System.out.println("3. 텍스트 파일");

        System.out.print("입력: ");
        Scanner sc = new Scanner(System.in);

        int selectFileType = sc.nextInt();

        try {

            File file;
            String fileName;

            switch (selectFileType) {
                case 1 -> {
                    file = copyFile("src/main/java/moomint/toy/github_grass_text_maker/template/JavaTemplate.java", commitFileLocation);
                    fileName = "JavaTemplate.java";
                }
                case 2 -> {
                    file = copyFile("src/main/java/moomint/toy/github_grass_text_maker/template/PythonTemplate.py", commitFileLocation);
                    fileName = "PythonTemplate.py";
                }
                case 3 -> {
                    file = new File(commitFileLocation, "text.txt");
                    FileWriter writer = new FileWriter(file);
                    writer.write("This is a commit test file.");
                    fileName = "text.txt";
                }
                default -> throw new RuntimeException("지원하지 않는 언어입니다.");
            }

            runCommand("git init", commitFileLocation);  // 필요시 리포지토리 초기화
            runCommand("git add " + fileName, commitFileLocation);
            runCommand(String.format("git commit -m \"Initial commit\" --date=\"%s\"", commitDate), commitFileLocation);

            if (file.delete()) {
                runCommand("git add -u", commitFileLocation);
                runCommand(String.format("git commit -m \"Delete " + fileName + "\" --date=\"%s\"", commitDate), commitFileLocation);
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

    private File copyFile(String sourcePath, File targetDir) throws IOException {
        Path currentWorkingDir = Path.of("").toAbsolutePath();
        Path source = currentWorkingDir.resolve(sourcePath); // 현재 작업 디렉토리에 상대 경로 결합
        File targetFile = new File(targetDir, source.getFileName().toString());

        Files.copy(source, targetFile.toPath());

        return targetFile;
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
