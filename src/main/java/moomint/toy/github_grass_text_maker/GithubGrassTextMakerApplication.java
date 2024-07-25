package moomint.toy.github_grass_text_maker;

import moomint.toy.github_grass_text_maker.view.InputView;

//@SpringBootApplication
public class GithubGrassTextMakerApplication {

	public static void main(String[] args) {
//		SpringApplication.run(GithubGrassTextMakerApplication.class, args);

		InputView inputView = new InputView();
		inputView.input();
	}

}
