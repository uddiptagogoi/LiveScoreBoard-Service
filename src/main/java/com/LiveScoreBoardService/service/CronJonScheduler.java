package com.LiveScoreBoardService.service;

import com.LiveScoreBoardService.entity.League;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

public class CronJonScheduler {

    private static final Logger LOGGER = LoggerFactory.getLogger(LeagueService.class);

    @Autowired
    private LeagueService leagueService;

    @Autowired
    private StandingService standingService;

    @Scheduled(cron = "0 0 0 * * *")
    public void refreshLeaguesDaily() {
        LOGGER.info("Cron job started: fetching leagues...");

        leagueService.fetchAndSaveLeagues();

        LOGGER.info("Cron job finished: leagues updated.");
    }

    @Scheduled(cron = "0 32 15 17 4 *") // every 6 hours
    public void refreshAllLeagues() {

        List<League> leagueList = leagueService.getAllLeagues();

        for (String leagueId : leagueList.stream().map(League::getIdLeague).toList()) {
            standingService.fetchAndSaveStandings(leagueId);
        }
    }
}
