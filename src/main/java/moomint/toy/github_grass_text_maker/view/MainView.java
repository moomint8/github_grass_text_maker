package moomint.toy.github_grass_text_maker.view;

import java.util.Scanner;

public class MainView {

    public void run() {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n============== 메인 페이지 ==============");
            System.out.println("1. 특정 날짜 commit");
            System.out.println("2. 특정 기간 commit");
            System.out.println("3. 잔디에 글씨 남기기");
            System.out.println("999. 프로그램 종료");
            System.out.print("메뉴 입력 : ");

            String input = scanner.nextLine();

            switch (input) {
                case "1" -> {
                    SingleCommitView singleCommit = new SingleCommitView();
                    singleCommit.run();
                }
                case "2", "3" -> System.out.println("구현예정");
                case "999" -> {
                    System.out.println("프로그램 종료");
                    return;
                }
                default -> System.out.println("잘못된 입력입니다.");
            }
        }
    }
}
