package com.LiveScoreBoardService.controller;

import com.LiveScoreBoardService.Dto.LeagueDetailDto;
import com.LiveScoreBoardService.service.LeagueDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/league-details")
public class LeagueDetailController {

    @Autowired
    private LeagueDetailService leagueDetailsService;

    @GetMapping("/{leagueId}")
    public LeagueDetailDto getLeagueDetails(@PathVariable String leagueId) {
        return leagueDetailsService.getLeagueDetails(leagueId);
    }
}
