package 课上.pojo;

/**
 * @ClassName: Score 
 * @Description: 分数实体类
 * @author: Mr.T
 * @date: 2020年6月24日 上午11:30:03
 */
public class Score {
	
	private Integer id; //分数ID
	
	private String subject;//科目名称
	
	private Integer score;//分数
	
	private Integer stId;//学生ID
	
	private String stName;//学生名称

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getStId() {
		return stId;
	}

	public void setStId(Integer stId) {
		this.stId = stId;
	}

	public String getStName() {
		return stName;
	}

	public void setStName(String stName) {
		this.stName = stName;
	}
	
	
	

}
