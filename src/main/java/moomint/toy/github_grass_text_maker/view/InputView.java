package moomint.toy.github_grass_text_maker.view;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class InputView {

    public void input() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("commit date(yyyy/MM/dd HH:mm): ");
        String dateInput = scanner.nextLine();
        LocalDateTime localDateTime = LocalDateTime.parse(dateInput, DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));

        // 한국 시간대로 변환
        String commitDateWithOffset = localDateTime.atOffset(ZoneOffset.ofHours(9))
                .format(DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss yyyy +0900", Locale.ENGLISH));

        System.out.print("GitHub 레포지토리 주소를 입력하세요: ");
        String repoUrl = scanner.nextLine();

        File commitFileLocation = new File("commitFileLocation");
        if (!commitFileLocation.exists()) {
            System.out.println("해당 디렉토리가 존재하지 않아 디렉토리를 생성합니다.");
            commitFileLocation.mkdir();
        }
        System.out.println("commitFileLocation = " + commitFileLocation);

        // 3. text.txt 파일 생성하고 Git add 및 commit
        File file = new File(commitFileLocation, "text.txt");
        try (FileWriter writer = new FileWriter(file)) {
            writer.write("This is a commit test file.");
        } catch (IOException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
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
