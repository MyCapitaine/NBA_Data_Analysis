package com.kmno4.presentation2;

import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kmno4.common.Config;
import com.kmno4.presentation.button.LMouseAdapter;
/**
 * 全球队一览分析界面
 * 内含联盟排名一览界面{@link AllTeamRankingAnalysisPanel}，
 * 最近10场分析界面{@link AllTeamRecentMatchAnalysisPanel}，
 * 攻防数据分析界面{@link AllTeamOffenAnalysisPanel}
 * 三个模块
 * @author hutao
 *
 */
@SuppressWarnings("serial")
public class AllTeamDataAnalysisPanel extends JPanel {
	private AllTeamDataAnalysisFrame allTeamDataAnalysisFrame;
	public static final int
	    PADDING = 10,
	    LABEL_HEIGHT = 60,
	    SELECT_PANEL_HEIGHT = 60,
	    PANEL_HEIGHT = Config.UI_HEIGHT - 2 * PADDING - LABEL_HEIGHT - SELECT_PANEL_HEIGHT;
	
	private JLabel somthing;
	private SelectPanel selectPanel;
	
	private JPanel currentPanel;
	private AllTeamRankingAnalysisPanel allTeamRankingAnalysisPanel;
	private AllTeamOffenAnalysisPanel allTeamOffenAnalysisPanel;
	private AllTeamRecentMatchAnalysisPanel allTeamRecentMatchAnalysisPanel;
	
	public AllTeamDataAnalysisPanel(AllTeamDataAnalysisFrame f) {
		allTeamDataAnalysisFrame = f;
		setBounds(0, 0, f.getWidth(), f.getHeight());
		setLayout(null);
		
		somthing = new JLabel("全球队数据分析", JLabel.LEFT);
		somthing.setBounds(PADDING, PADDING, Config.UI_WIDTH - 2 * PADDING, LABEL_HEIGHT);
		add(somthing);
		selectPanel = new SelectPanel();
		add(selectPanel);
		
		add(currentPanel = (allTeamRankingAnalysisPanel = new AllTeamRankingAnalysisPanel(allTeamDataAnalysisFrame)));
		
		
	}

	class SelectPanel extends JPanel {
		JLabel rank, recent, offen;
		public SelectPanel() {
			setBounds(PADDING, PADDING + LABEL_HEIGHT,
					Config.UI_WIDTH - 2 * PADDING, SELECT_PANEL_HEIGHT);
//			setLayout(null);
			//TODO
			rank = new JLabel("排名一览", JLabel.LEFT);
			recent = new JLabel("最近10场分析", JLabel.LEFT);
			offen = new JLabel("进攻防守分析", JLabel.LEFT);
			rank.addMouseListener(new LMouseAdapter(allTeamDataAnalysisFrame) {
				public void mouseClicked(MouseEvent e) {
					toRanking();
				}
			});
			recent.addMouseListener(new LMouseAdapter(allTeamDataAnalysisFrame) {
				public void mouseClicked(MouseEvent e) {
					toRecentMatchAna();
				}
			});
			offen.addMouseListener(new LMouseAdapter(allTeamDataAnalysisFrame) {
				public void mouseClicked(MouseEvent e) {
					toOffenAna();
				}
			});
			add(rank);
			add(recent);
			add(offen);
		}
	}
	
	/**
	 * 切换为联盟排名一览
	 */
	private void toRanking() {
		remove(currentPanel);
		add(currentPanel = (allTeamRankingAnalysisPanel = new AllTeamRankingAnalysisPanel(allTeamDataAnalysisFrame)));
		allTeamDataAnalysisFrame.repaint();
	}
	/**
	 * 切换为最近10场分析
	 */
	private void toRecentMatchAna() {
		remove(currentPanel);
		add(currentPanel = (allTeamRecentMatchAnalysisPanel = new AllTeamRecentMatchAnalysisPanel(allTeamDataAnalysisFrame)));
		allTeamDataAnalysisFrame.repaint();
	}
	/**
	 * 切换为攻防数据分析
	 */
	private void toOffenAna() {
		remove(currentPanel);
		add(currentPanel = (allTeamOffenAnalysisPanel = new AllTeamOffenAnalysisPanel(allTeamDataAnalysisFrame)));
		allTeamDataAnalysisFrame.repaint();
	}
	
	public static void main(String[] args) {
		new AllTeamDataAnalysisFrame();
	}
}
