package com.LiveScoreBoardService.Dao;

import com.LiveScoreBoardService.entity.LeagueDetail;
import com.LiveScoreBoardService.repository.LeagueDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class LeagueDetailDaoImpl implements LeagueDetailDao {

    @Autowired
    private LeagueDetailRepository repository;

    @Override
    public Optional<LeagueDetail> findById(String idLeague) {
        return repository.findById(idLeague);
    }

    @Override
    public LeagueDetail save(LeagueDetail entity) {
        return repository.save(entity);
    }
}
