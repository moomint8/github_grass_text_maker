package moomint.toy.github_grass_text_maker.view;

import moomint.toy.github_grass_text_maker.util.DateManager;
import moomint.toy.github_grass_text_maker.util.GithubManager;

import java.util.Scanner;

public class MainView {

    private static final String GITHUB_URL_PATTERN = "^https:\\/\\/github\\.com\\/[a-zA-Z0-9_-]+\\/[a-zA-Z0-9_-]+\\.git$";

    public void run() {

        Scanner scanner = new Scanner(System.in);
        DateManager dateManager = new DateManager();
        GithubManager githubManager = new GithubManager();
        CommitSelector commitSelector = new CommitSelector();

        String repoUrl = getRepositoryAddress();

        while (true) {
            System.out.print("레포 주소: " + repoUrl);
            System.out.println("\n============== 메인 페이지 ==============");
            System.out.println("0. Git Repository 주소 재입력");
            System.out.println("1. 특정 날짜 commit");
            System.out.println("2. 특정 기간 commit");
            System.out.println("3. 잔디에 글씨 남기기");
            System.out.println("999. 프로그램 종료");
            System.out.print("메뉴 입력 : ");

            String input = scanner.nextLine();

            switch (input) {
                case "0" -> repoUrl = getRepositoryAddress();
                case "1" -> {
                    commitSelector.singleCommit(repoUrl, dateManager, githubManager);
                }
                case "2" -> commitSelector.multipleCommit(repoUrl, dateManager, githubManager);
                case "3" -> System.out.println("구현예정");
                case "999" -> {
                    System.out.println("프로그램 종료");
                    return;
                }
                default -> System.out.println("잘못된 입력입니다.");
            }
        }
    }

    private String getRepositoryAddress() {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("GitHub 레포지토리 주소를 입력하세요(999 입력 시 종료): ");
            String repoUrl = scanner.nextLine();

            if (repoUrl.matches(GITHUB_URL_PATTERN)) {
                return repoUrl;
            }
            if (repoUrl.equals("999")) {
                return null;
            }
            System.out.println("잘못된 형태의 주소입니다. 다시 입력해주세요.");
        }
    }
}
