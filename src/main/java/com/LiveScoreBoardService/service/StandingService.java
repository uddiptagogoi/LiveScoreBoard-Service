package com.LiveScoreBoardService.service;

import com.LiveScoreBoardService.entity.Standing;
import com.LiveScoreBoardService.repository.StandingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class StandingService {

    @Autowired
    private StandingRepository repo;

    private final RestTemplate restTemplate = new RestTemplate();

    public List<Standing> fetchAndSaveStandings(String leagueId) {

        String url = "https://www.thesportsdb.com/api/v1/json/123/lookuptable.php?l=" + leagueId;

        ResponseEntity<Map> response =
                restTemplate.getForEntity(url, Map.class);

        List<Map<String, Object>> table =
                (List<Map<String, Object>>) response.getBody().get("table");

        List<Standing> result = new ArrayList<>();

        for (Map<String, Object> team : table) {

            Standing s = new Standing();
            s.setLeagueId(leagueId);
            s.setTeamId((String) team.get("idTeam"));
            s.setTeamName((String) team.get("strTeam"));

            s.setRank(parseInt(team.get("intRank")));
            s.setPlayed(parseInt(team.get("intPlayed")));
            s.setWin(parseInt(team.get("intWin")));
            s.setDraw(parseInt(team.get("intDraw")));
            s.setLoss(parseInt(team.get("intLoss")));
            s.setGoalsFor(parseInt(team.get("intGoalsFor")));
            s.setGoalsAgainst(parseInt(team.get("intGoalsAgainst")));
            s.setGoalDifference(parseInt(team.get("intGoalDifference")));
            s.setPoints(parseInt(team.get("intPoints")));

            s.setBadge((String) team.get("strBadge"));

            result.add(s);
        }

        // refresh only that league
        repo.deleteByLeagueId(leagueId);
        repo.saveAll(result);

        return result;
    }

    public List<Standing> getStandings(String leagueId) {
        return repo.findByLeagueId(leagueId);
    }

    private int parseInt(Object val) {
        try {
            return val == null ? 0 : Integer.parseInt(val.toString());
        } catch (Exception e) {
            return 0;
        }
    }
}