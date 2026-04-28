package com.LiveScoreBoardService.repository;

import com.LiveScoreBoardService.entity.Standing;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StandingRepository extends MongoRepository<Standing, String> {

    List<Standing> findByLeagueId(String leagueId);

    void deleteByLeagueId(String leagueId);
}