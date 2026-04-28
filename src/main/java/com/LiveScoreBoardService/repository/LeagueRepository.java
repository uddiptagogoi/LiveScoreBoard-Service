package com.LiveScoreBoardService.repository;

import com.LiveScoreBoardService.entity.League;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LeagueRepository extends MongoRepository<League, String> {
}
