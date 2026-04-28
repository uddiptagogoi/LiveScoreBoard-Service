package com.LiveScoreBoardService.controller;

import com.LiveScoreBoardService.entity.League;
import com.LiveScoreBoardService.service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/leagues")
public class LeagueController {

    @Autowired
    private LeagueService service;

    // Call external API + save to DB
    @GetMapping("/sync")
    public List<League> syncLeagues() {
        return service.fetchAndSaveLeagues();
    }

    // Get from DB (for React)
    @GetMapping
    public List<League> getLeagues() {
        return service.getAllLeagues();
    }
}