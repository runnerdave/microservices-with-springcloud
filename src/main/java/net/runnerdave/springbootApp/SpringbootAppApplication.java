package net.runnerdave.springbootApp;

import net.runnerdave.springbootApp.model.Team;
import net.runnerdave.springbootApp.model.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringbootAppApplication {
	@Autowired
	TeamRepository teamRepository;

	@PostConstruct
	public void init() {
		List<Team> list = new ArrayList<>();

		Team team = new Team();
		team.setLocation("Harlem");
		team.setName("Globetrotters");
		list.add(team);

		Team team2 = new Team();
		team2.setLocation("Washington");
		team2.setName("Generals");
		team2.setMascot("Indian");
		list.add(team2);
		teamRepository.saveAll(list);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAppApplication.class, args);
	}

}
