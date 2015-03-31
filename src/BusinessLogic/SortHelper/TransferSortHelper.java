package BusinessLogic.SortHelper;

import Enum.PlayerData;
import Enum.TeamData;

public class TransferSortHelper {
	public static PlayerData StringToDataTypeForPlayer(String key){
		PlayerData dataType = null;
		switch (key){
		case "参赛场数":
			dataType = PlayerData.numberOfMatchs ;
			break ;
		case "先发场数":
			dataType = PlayerData.numberOfStarting ;
			break ;
		case "篮板数":
			dataType = PlayerData.numberOfRebound ;
			break ;
		case "助攻数":
			dataType = PlayerData.numberOfAssist ;
			break ;
		case "在场时间":
			dataType = PlayerData.presentTime ;
			break ;
		case "投篮命中率":
			dataType = PlayerData.percentageOfShooting ;
			break ;
		case "三分命中率":
			dataType = PlayerData.percentageOf3_Point ;
			break ;
		case "罚球命中率":
			dataType = PlayerData.percentageOfFreeThrow ;
			break ;
		case "进攻数":
			dataType = PlayerData.numberOfAttack ;
			break ;
		case "防守数":
			dataType = PlayerData.numberOfDefense ;
			break ;
		case "抢断数":
			dataType = PlayerData.numberOfSteal ;
			break ;
		case "失误数":
			dataType = PlayerData.numberOfFault ;
			break ;
		case "犯规数":
			dataType = PlayerData.numberOfFoul ;
			break ;
		case "得分":
			dataType = PlayerData.score ;
			break ;
		case "效率":
			dataType = PlayerData.efficiency ;
			break ;
		case "GmSc效率值":
			dataType = PlayerData.efficiencyOfGmSc ;
			break ;
		case "盖帽数":
			dataType = PlayerData.numberOfBlock ;
			break ;
		case "真实命中率":
			dataType = PlayerData.percentageOfTrueShooting ;
			break ;
		case "投篮效率":
			dataType = PlayerData.efficiencyOfShooting ;
			break ;
		case "篮板率":
			dataType = PlayerData.percentageOfRebound ;
			break ;
		case "进攻篮板率":
			dataType = PlayerData.percentageOfAttackingRebound ;
			break ;
		case "防守篮板率":
			dataType = PlayerData.percentageOfDefenseRebound ;
			break ;
		case "助攻率":
			dataType = PlayerData.percentageOfAssist ;
			break ;
		case "抢断率":
			dataType = PlayerData.percentageOfSteal ;
			break ;
		case "盖帽率":
			dataType = PlayerData.percentageOfBlock ;
			break ;
		case "失误率":
			dataType = PlayerData.percentageOfFault ;
			break ;
		case "使用率":
			dataType = PlayerData.percentageOfUse ;
			break ;
			
		case "篮板":
			dataType=PlayerData.numberOfRebound;
			break;
		case "助攻":
			dataType=PlayerData.numberOfAssist;
			break;
		case "得分/篮板/助攻":
			dataType=PlayerData.comprehension;
			break;
		case "盖帽":
			dataType=PlayerData.numberOfBlock;
			break;
		case "抢断":
			dataType=PlayerData.numberOfSteal;
			break;
		case "犯规":
			dataType=PlayerData.numberOfFoul;
			break;
		case "失误":
			dataType=PlayerData.numberOfFault;
			break;
		case "分钟":
			dataType=PlayerData.presentTime;
			break;
		case "投篮":
			dataType=PlayerData.numberOfShooting;
			break;
		case "三分":
			dataType=PlayerData.numberOf3_Point;
			break;
		case "罚球":
			dataType=PlayerData.numberOfFreeThrow;
			break;
		case "两双":
			dataType = PlayerData.double_double;
			break ;
		}
		return dataType;
	}
	public static TeamData StringToDataTypeForTeam(String key){
		TeamData dataType=null;
		switch(key){
		case "球队名称":
			dataType=TeamData.teamFullName;
			break;
		case "比赛场数":
			dataType=TeamData.numberOfMatches;
			break;
		case "投篮命中数":
			dataType=TeamData.numberOfShooting;
			break;
		case "投篮出手数":
			dataType=TeamData.numberOfShotAttempt;
			break;
		case "三分命中数":
			dataType=TeamData.numberOf3_point;
			break;
		case "三分出手数":
			dataType=TeamData.numberOf3_pointAttempt;
			break;
		case "罚球命中数":
			dataType=TeamData.numberOfFreeThrow;
			break;
		case "罚球出手数":
			dataType=TeamData.numberOfFreeThrowAttempt;
			break;
		case "进攻篮板数":
			dataType=TeamData.numberOfAttackRebound;
			break;
		case "防守篮板数":
			dataType=TeamData.numberOfDefenseRebound;
			break;
		case "篮板数":
			dataType=TeamData.numberOfRebound;
			break;
		case "助攻数":
			dataType=TeamData.numberOfAssist;
			break;
		case "抢断数":
			dataType=TeamData.numberOfSteal;
			break;
		case "盖帽数":
			dataType=TeamData.numberOfBlock;
			break;
		case "失误数":
			dataType=TeamData.numberOfFault;
			break;
		case "犯规数":
			dataType=TeamData.numberOfFoul;
			break;
		case "得分":
			dataType=TeamData.score;
			break;
		case "投篮命中率":
			dataType=TeamData.percentageOfShooting;
			break;
		case "三分命中率":
			dataType=TeamData.percentageOf3_point;;
			break;
		case "罚球命中率":
			dataType=TeamData.percentageOfFreeThrow;
			break;
		case "进攻回合":
			dataType=TeamData.roundOfAttack;
			break;
		case "进攻效率":
			dataType=TeamData.efficiencyOfAttack;
			break;
		case "防守效率":
			dataType=TeamData.efficiencyOfDefense;
			break;
		case "篮板效率":
			dataType=TeamData.efficiencyOfRebound;
			break;
		case "抢断效率":
			dataType=TeamData.efficiencyOfSteal;
			break;
		case "助攻率":
			dataType=TeamData.efficiencyOfAssist;
			break;
		case "胜率":
			dataType=TeamData.percentageOfWinning;
		}
		return  dataType;
	}
}