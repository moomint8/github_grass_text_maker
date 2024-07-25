package moomint.toy.github_grass_text_maker;

import moomint.toy.github_grass_text_maker.view.MainView;
import moomint.toy.github_grass_text_maker.view.SingleCommitView;

//@SpringBootApplication
public class GithubGrassTextMakerApplication {

	public static void main(String[] args) {
//		SpringApplication.run(GithubGrassTextMakerApplication.class, args);

		MainView mainView = new MainView();
		mainView.run();
	}

}
