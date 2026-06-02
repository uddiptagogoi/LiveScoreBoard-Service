package com.LiveScoreBoardService.Dao;

import com.LiveScoreBoardService.entity.LeagueDetail;

import java.util.Optional;

public interface LeagueDetailDao {

    Optional<LeagueDetail> findById(String idLeague);

    LeagueDetail save(LeagueDetail entity);
}
