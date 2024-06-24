package services;

import dao.TeamDao;
import java.util.List;
import models.Team;

public class TeamService {
    
    private TeamDao TeamDao;
    
    public TeamService(){
        TeamDao = new TeamDao();
    }
    
    public List<Team> getAllTeam(){
        return TeamDao.getAllTeams();
    }
    
    public int getIdByTeam(String code , String name){
        return TeamDao.getIdByTeam(code, name);
    }
    
    public Team getTeamById(int TeamId){
        return TeamDao.getTeamById(TeamId);
    }
    
    public void addTeam(Team Team){
        TeamDao.addTeam(Team);
    }
    public boolean isExistedTeamCode(String TeamId) {
        List<Team> Team_data = TeamDao.getAllTeams();
        for (Team cls : Team_data) {
            if (cls.getCode().trim().equals(TeamId.trim())) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isExistedTeamName(String TeamName) {
        List<Team> Team_data = TeamDao.getAllTeams();
        for (Team cls : Team_data) {
            if (cls.getName().trim().equals(TeamName.trim())) {
                return true;
            }
        }
        return false;
    }
    public void updateTeam(Team Team , int TeamId){
        TeamDao.updateTeam(Team, TeamId);
    }

    public void deleteTeam(int TeamId) {
        TeamDao.deleteTeam(TeamId);
    }

    public int getTeamIdByTeamName(Team Team) {
        return TeamDao.getTeamIdByTeamName(Team);
    }
    
    public Team getTeamNameById(int TeamId){
        return TeamDao.getTeamNameById(TeamId);
    }
    
    
}
