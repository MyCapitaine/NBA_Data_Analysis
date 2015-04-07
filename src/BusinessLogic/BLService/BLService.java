package BusinessLogic.BLService;

import java.util.ArrayList;

import Enum.PlayerData;
import Enum.Season;
import Enum.TeamData;
import Enum.Zone;
import PO.MatchPO;
import PO.PlayerPO;
import PO.TeamPO;

public interface BLService {
	public void init();
	public ArrayList<PlayerPO> getAllPlayers() ;
	public ArrayList<TeamPO> getAllTeamsOf13_14() ;
	/**
	 * 
	 * @param standard 标准（总数据、场均或姓名）
	 * @param dataType 技术类型
	 * @return 球队的排序结果
	 */
	public ArrayList<PlayerPO> sortPlayersByComprehension(String  standard,PlayerData dataType,Season season) ;
	/**
	 * 
	 * @param standard 标准（总数据、场均或队伍全名或队伍胜率等）
	 * @param dataType 技术类型
	 * @return 球员的排序结果
	 */
	public ArrayList<TeamPO> sortTeamsOf13_14ByComprehension(String standard,TeamData dataType,Season season);
	//以下方法为：根据球员位置、东西部、具体分区和排序依据返回所有满足条件的前50名球员序列,其中standard和dataType参数同排序方法中的参数
	/**
	 * 
	 * @param position 球员位置
	 * @param zone 东西部
	 * @param district 具体分区（界面上可以不选择，如果不选择，则传null）
	 * @param standard 排序依据的标准（总数据、场均或队伍全名或队伍胜率等）
	 * @param dataType 技术类型
	 * @return 球员的筛选结果
	 */
	public ArrayList<PlayerPO> pickUpPlayersByCondition(String position,
			Zone zone, String district, String standard,PlayerData dataType,Season season);
	/**
	 *  仅限精确查找
	 * @param season 赛季（枚举类型）
	 * @param date 日期（如01-01）
	 * @param nameOfTeams 两队名字（CHA-LAC）
	 * @return 查找的比赛
	 */
	public MatchPO findMatch(Season season,String date,String nameOfTeams) ;
	/**
	 * 
	 * @param name 球员名称
	 * @return 球员列表
	 */
	public ArrayList<PlayerPO> findPlayerByName(String name) ;
	/**
	 *  
	 * @param name 球队名称（缩写或者全名）
	 * @return 球队列表
	 */
	public ArrayList<TeamPO>findTeamByName(String name) ;
	/**
	 * 
	 * @param season 赛季
	 * @param date 日期（如01-01）
	 * @return 前五名球员列表,如果不存在即返回null。
	 */
	public ArrayList<PlayerPO> getDailyStandingPlayers(Season season,String date,PlayerData dataType) ;
	
}
