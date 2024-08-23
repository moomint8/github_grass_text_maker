package moomint.toy.github_grass_text_maker.view;

import moomint.toy.github_grass_text_maker.util.DateManager;
import moomint.toy.github_grass_text_maker.util.GithubManager;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Scanner;

public class CommitSelector {

    public void singleCommit(String repoUrl, DateManager dateManager, GithubManager githubManager) {

        System.out.println("Commit할 날짜를 입력해주세요.");
        String commitDateWithOffset = dateManager.formatDate();

        int fileType = selectFileType();

        File commitFileLocation = githubManager.commiter(commitDateWithOffset, fileType);

        githubManager.pusher(repoUrl, commitFileLocation);
    }

    public void multipleCommit(String repoUrl, DateManager dateManager, GithubManager githubManager) {

        System.out.println("시작 날짜를 입력해주세요.");
        LocalDateTime startDate = dateManager.inputDateTime();
        System.out.println("종료 날짜를 입력해주세요.(※주의※ 시작 날짜보다 늦은 시, 분 입력해주세요.)");
        LocalDateTime endDate = dateManager.inputDateTime();

        if (startDate.isAfter(endDate)) {
            System.out.println("시작 날짜는 종료 날짜보다 이전이어야 합니다.");
            return;
        }

        File commitFileLocation = null;

        LocalDateTime currentDate = startDate;

        int fileType = selectFileType();

        while (!currentDate.isAfter(endDate)) {
            String commitDateWithOffset = dateManager.formatDate(currentDate);

            commitFileLocation = githubManager.commiter(commitDateWithOffset, fileType);

            // 다음 날짜로 이동
            currentDate = currentDate.plusDays(1);
        }

        githubManager.pusher(repoUrl, commitFileLocation);
    }

    private int selectFileType() {
        System.out.println("생성할 파일의 타입을 선택하세요.");
        System.out.println("1. 자바");
        System.out.println("2. 파이썬");
        System.out.println("3. 텍스트 파일");

        System.out.print("입력: ");
        Scanner sc = new Scanner(System.in);

        return sc.nextInt();
    }
}
