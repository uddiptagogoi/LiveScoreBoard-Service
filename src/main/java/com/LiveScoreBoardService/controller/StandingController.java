package com.LiveScoreBoardService.controller;

import com.LiveScoreBoardService.entity.Standing;
import com.LiveScoreBoardService.service.LeagueService;
import com.LiveScoreBoardService.service.StandingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/standings")
public class StandingController {

    @Autowired
    private StandingService service;

    @Autowired
    private LeagueService leagueService;

    // Sync from external API (manual or cron)
    @GetMapping("/sync")
    public void sync() {
        leagueService.getAllLeagues().stream()
                .map(league -> league.getIdLeague())
                .forEach(id -> service.fetchAndSaveStandings(id));
    }

    // Get from DB (React will call this)
    @GetMapping("/{leagueId}")
    public List<Standing> get(@PathVariable String leagueId) {
        return service.getStandings(leagueId);
    }
}