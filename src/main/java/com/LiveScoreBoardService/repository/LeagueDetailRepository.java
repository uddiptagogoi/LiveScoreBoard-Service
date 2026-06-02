package com.LiveScoreBoardService.repository;
import com.LiveScoreBoardService.entity.LeagueDetail;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LeagueDetailRepository extends MongoRepository<LeagueDetail, String>{
}
