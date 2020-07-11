package net.runnerdave.springbootApp;

import net.runnerdave.springbootApp.model.Player;
import net.runnerdave.springbootApp.model.Team;
import net.runnerdave.springbootApp.model.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
		Set<Player> set = new HashSet<>();
		set.add(new Player("Big Easy", "Showman"));
		set.add(new Player("Buckets", "Guard"));
		set.add(new Player("Dizzy", "Guard"));
		team.setPlayers(set);

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
