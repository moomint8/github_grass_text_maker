package moomint.toy.github_grass_text_maker.view;

import moomint.toy.github_grass_text_maker.util.DateManager;
import moomint.toy.github_grass_text_maker.util.GithubManager;

import java.io.File;

public class CommitSelector {

    public void singleCommit(String repoUrl, DateManager dateManager, GithubManager githubManager) {

        // commit 날짜 입력
        System.out.println("Commit할 날짜를 입력해주세요.");
        String commitDateWithOffset = dateManager.formatDate();

        File commitFileLocation = githubManager.commiter(commitDateWithOffset);

        githubManager.pusher(repoUrl, commitFileLocation);
    }
}
