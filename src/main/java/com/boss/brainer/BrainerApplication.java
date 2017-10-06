package com.boss.brainer;

import com.boss.brainer.repository.ActiveGameRepository;
import com.boss.brainer.service.QuestionService;
import com.mongodb.Mongo;
import org.mongeez.Mongeez;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
public class BrainerApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BrainerApplication.class);
	}
	@Bean
	CommandLineRunner init(ActiveGameRepository activeGameRepository, QuestionService questionService) {

		return args -> {
			/*ActiveGame game = new ActiveGame();

			game.setFirstUser("user2");
			game.setSecondUser("user");

			game.setPendingUser("test2");
			game.setType(GameType.R5_Q5);

			Category category = new Category("sport");

			Question question1 = new Question();
			//question1.setId(1);
			question1.setType(QuestionType.TEXT);
			question1.setCorrectAnswer(new Answer("yeah, this is correct!!"));
			question1.setAnswer1(new Answer("so sad.."));
			question1.setAnswer2(new Answer("you are loser"));
			question1.setAnswer3(new Answer("no no"));

			GameQuestion gameQuestion = new GameQuestion();
			gameQuestion.setQuestionId(question1);
			gameQuestion.setFirstPlayerAnswer(new Answer("test"));
			gameQuestion.setSecondPlayerAnswer(new Answer("test"));

			Round round1 = new Round();
			round1.setCategory(category);
			round1.setRoundNumber(1);
			round1.setQuestions(Arrays.asList(gameQuestion));

			game.setRounds(Arrays.asList(round1));

			game.setPendingTime(Calendar.getInstance().getTime());


			ActiveGame obj = activeGameRepository.save(game);
			System.out.println(obj);

			/*List<ActiveGame> obj2 = activeGameRepository.findActiveGamesByFirstUser("test");
			System.out.println(obj2);*/

			/*List<BaseActiveGame> obj3 = baseActiveGameRepository.findBaseActiveGamesByUser("test");
			System.out.println(obj3);*/

			/*Question question = new Question();
			question.setCorrectAnswer(new Answer( "correct1"));
			question.setAnswer1(new Answer("incorrect11"));
			question.setAnswer2(new Answer("incorrect12"));
			question.setAnswer3(new Answer("incorrect13"));
			question.setType(QuestionType.TEXT);
			question.setQuestionDescription("TEST");

			Question question2 = new Question();
			question2.setCorrectAnswer(new Answer( "correct2"));
			question2.setAnswer1(new Answer("incorrect21"));
			question2.setAnswer2(new Answer("incorrect22"));
			question2.setAnswer3(new Answer("incorrect23"));
			question2.setType(QuestionType.TEXT);
			question2.setQuestionDescription("TEST2");

			Question question3 = new Question();
			question3.setCorrectAnswer(new Answer( "correct3"));
			question3.setAnswer1(new Answer("incorrect31"));
			question3.setAnswer2(new Answer("incorrect32"));
			question3.setAnswer3(new Answer("incorrect33"));
			question3.setType(QuestionType.TEXT);
			question3.setQuestionDescription("TEST3");

			questionRepository.save(question);
			questionRepository.save(question2);
			questionRepository.save(question3);*/

			/*List<Question> list = questionService.findRandomQuestions(2);
			System.out.println(list);*/

		};

	}

	public static void main(String[] args) {
		SpringApplication.run(BrainerApplication.class, args);
	}
}
