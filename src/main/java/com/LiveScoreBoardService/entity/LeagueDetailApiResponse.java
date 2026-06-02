package com.LiveScoreBoardService.entity;
import com.LiveScoreBoardService.Dto.LeagueDetailDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class LeagueDetailApiResponse {
    private List<LeagueDetailDto> leagues;

    public List<LeagueDetailDto> getLeagues() {
        return leagues;
    }

    public void setLeagues(List<LeagueDetailDto> leagues) {
        this.leagues = leagues;
    }
}