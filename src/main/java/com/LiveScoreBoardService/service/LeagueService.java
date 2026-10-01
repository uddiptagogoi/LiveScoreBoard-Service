package com.LiveScoreBoardService.service;

import com.LiveScoreBoardService.entity.League;
import com.LiveScoreBoardService.repository.LeagueRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class LeagueService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LeagueService.class);

    @Autowired
    private LeagueRepository repo;

    private final RestTemplate restTemplate = new RestTemplate();

    @Scheduled(cron = "0 0 0 * * *")
    public void refreshLeaguesDaily() {
        LOGGER.info("Cron job started: fetching leagues...");

        fetchAndSaveLeagues();

        LOGGER.info("Cron job finished: leagues updated.");
    }

    public List<League> fetchAndSaveLeagues() {

        List<League> result = new ArrayList<>();

        try {
            String url = "https://www.thesportsdb.com/api/v1/json/123/all_leagues.php";

            ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);

            List<Map<String, Object>> leagues =
                    (List<Map<String, Object>>) response.getBody().get("leagues");



            for (Map<String, Object> l : leagues) {

                String sport = (String) l.get("strSport");
                if (sport == null || !sport.equalsIgnoreCase("Soccer")) continue;

                League league = new League();
                league.setIdLeague((String) l.get("idLeague"));
                league.setName((String)l.get("strLeague"));
                league.setCountry(getCountry((String) l.get("strLeague")));
                league.setLogo("https://www.thesportsdb.com/images/media/league/badge/" + l.get("idLeague") + ".png");
                result.add(league);
            }

            repo.deleteAll();   // optional: refresh data
            repo.saveAll(result);
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
        }
        return result;
    }

    public List<League> getAllLeagues() {
        return repo.findAll();
    }

    private String getCountry(String leagueName) {
        if (leagueName == null) return "International";

        if (leagueName.contains("English")) return "England";
        if (leagueName.contains("Spanish")) return "Spain";
        if (leagueName.contains("German")) return "Germany";
        if (leagueName.contains("Italian")) return "Italy";
        if (leagueName.contains("French")) return "France";
        if (leagueName.contains("MLS")) return "USA";

        return "International";
    }
}