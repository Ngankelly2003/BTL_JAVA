package dao;

import connectdb.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Team;

public class TeamDao {
    
    public List<Team> getAllTeams(){
        List<Team> Teams = new ArrayList<>();
        String sql = "SELECT * FROM tbl_team   ";
        try {
            Connection conn = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Team Team = new Team();
                Team.setCode(rs.getString("code"));
                Team.setName(rs.getString("name"));
                Teams.add(Team);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Teams;
    }
    
    public int getIdByTeam(String code, String name){
        int TeamId = -1;
        String sql = "SELECT tbl_team.id FROM tbl_team WHERE code = ? AND name = ?";
        try {
            Connection conn = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            
            preparedStatement.setString(1, code);
            preparedStatement.setString(2, name);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                TeamId = rs.getInt("id");
            }
            
            return TeamId;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    public Team getTeamById(int TeamId){
        String sql = "SELECT id,code,name FROM tbl_team WHERE id = ?";
        Team Team = new Team();
        try{
            Connection conn = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, TeamId);
            
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Team.setId(rs.getInt("id"));
                Team.setCode(rs.getString("code"));
                Team.setName(rs.getString("name"));
            }
            
            rs.close();
            preparedStatement.close();
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return Team;
    }
    
    public Team getTeamNameById(int TeamId){
        String sql = "SELECT name FROM tbl_team WHERE id = ?";
        Team Team = new Team();
        try{
            Connection conn = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, TeamId);
            
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Team.setName(rs.getString("name"));
            }
            
            rs.close();
            preparedStatement.close();
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return Team;
    }
    
    public void addTeam(Team Team){
        String sql = "INSERT INTO tbl_team(code,name) VALUES(?,?)";
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,Team.getCode());
            preparedStatement.setString(2, Team.getName());
            
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void updateTeam(Team Team , int TeamId){
        String sql = "UPDATE tbl_team SET code = ? , name = ? WHERE id = ?";
        
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, Team.getCode());
            preparedStatement.setString(2, Team.getName());
            preparedStatement.setInt(3, TeamId);
            
            System.out.println("SQL: " + preparedStatement.toString());
            
            int rowUpdated = preparedStatement.executeUpdate();
            if(rowUpdated > 0){
                System.out.println("Team updated.");
            }else {
                System.out.println("No changes detected. Team not updated.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteTeam(int TeamId) {
        String sql = "DELETE FROM tbl_team WHERE id = ?";
        
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, TeamId);
            
            int deleteRow = preparedStatement.executeUpdate();
            if(deleteRow > 0){
                System.out.println("Team deleted!");
            }else{
                System.out.println("Team delete failed!");
            }
        } catch (Exception e) {
        }
    }

    public int getTeamIdByTeamName(Team Team) {
        int TeamId = -1;
        String sql = "SELECT id from tbl_team WHERE name = ?";
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, Team.getName());
            
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                TeamId = rs.getInt("id");
            }
            return TeamId;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
