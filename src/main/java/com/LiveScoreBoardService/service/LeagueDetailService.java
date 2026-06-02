package com.LiveScoreBoardService.service;

import com.LiveScoreBoardService.Dao.LeagueDetailDao;
import com.LiveScoreBoardService.Dto.LeagueDetailDto;
import com.LiveScoreBoardService.entity.LeagueDetail;
import com.LiveScoreBoardService.entity.LeagueDetailApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LeagueDetailService {

    private final LeagueDetailDao leagueDetailDao;
    private final WebClient webClient;

    private static final String API_URL =
            "https://www.thesportsdb.com/api/v1/json/123/lookupleague.php?id=";

    public LeagueDetailDto getLeagueDetails(String leagueId) {
        // 1. CHECK IN MONGO DB
        Optional<LeagueDetail> optional = leagueDetailDao.findById(leagueId);
        if (optional.isPresent()) {
            return mapToDto(optional.get());
        }

        LeagueDetailApiResponse response =
                webClient.get()
                        .uri(API_URL + leagueId)
                        .retrieve()
                        .bodyToMono(LeagueDetailApiResponse.class)
                        .block();

        if (response == null
                || response.getLeagues() == null
                || response.getLeagues().isEmpty()) {

            throw new RuntimeException(
                    "League details not found for id " + leagueId);
        }

        LeagueDetailDto dto = response.getLeagues().get(0);


        // 3. SAVE INTO MONGO DB
        LeagueDetail entity = mapToEntity(dto);
        leagueDetailDao.save(entity);

        return dto;
    }

    // DTO → ENTITY
    private LeagueDetail mapToEntity(LeagueDetailDto dto) {
        return LeagueDetail.builder()
                .idLeague(dto.getIdLeague())
                .strLeague(dto.getStrLeague())
                .strSport(dto.getStrSport())
                .strCountry(dto.getStrCountry())
                .strLeagueAlternate(dto.getStrLeagueAlternate())
                .intFormedYear(dto.getIntFormedYear())
                .strCurrentSeason(dto.getStrCurrentSeason())
                .strBadge(dto.getStrBadge())
                .strBanner(dto.getStrBanner())
                .strLogo(dto.getStrLogo())
                .strPoster(dto.getStrPoster())
                .strTrophy(dto.getStrTrophy())
                .strDescriptionEN(dto.getStrDescriptionEN())
                .strWebsite(dto.getStrWebsite())
                .strTwitter(dto.getStrTwitter())
                .strFacebook(dto.getStrFacebook())
                .strInstagram(dto.getStrInstagram())
                .strYoutube(dto.getStrYoutube())
                .strTvRights(dto.getStrTvRights())
                .build();
    }

    // ENTITY → DTO
    private LeagueDetailDto mapToDto(LeagueDetail entity) {
        LeagueDetailDto dto = new LeagueDetailDto();

        dto.setIdLeague(entity.getIdLeague());
        dto.setStrLeague(entity.getStrLeague());
        dto.setStrSport(entity.getStrSport());
        dto.setStrCountry(entity.getStrCountry());
        dto.setStrLeagueAlternate(entity.getStrLeagueAlternate());
        dto.setIntFormedYear(entity.getIntFormedYear());
        dto.setStrCurrentSeason(entity.getStrCurrentSeason());

        dto.setStrBadge(entity.getStrBadge());
        dto.setStrBanner(entity.getStrBanner());
        dto.setStrLogo(entity.getStrLogo());
        dto.setStrPoster(entity.getStrPoster());
        dto.setStrTrophy(entity.getStrTrophy());

        dto.setStrDescriptionEN(entity.getStrDescriptionEN());

        dto.setStrWebsite(entity.getStrWebsite());
        dto.setStrTwitter(entity.getStrTwitter());
        dto.setStrFacebook(entity.getStrFacebook());
        dto.setStrInstagram(entity.getStrInstagram());
        dto.setStrYoutube(entity.getStrYoutube());

        dto.setStrTvRights(entity.getStrTvRights());

        return dto;
    }
}