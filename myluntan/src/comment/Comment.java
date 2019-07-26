package comment;

public class Comment {
	private Integer commentId;
	private String comContent;
	private String comTime;
	private String comName;
	private Integer articleId;
	public Integer getCommentId() {
		return commentId;
	}
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}
	public String getComContent() {
		return comContent;
	}
	public void setComContent(String comContent) {
		this.comContent = comContent;
	}
	public String getComTime() {
		return comTime;
	}
	public void setComTime(String comTime) {
		this.comTime = comTime;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public Integer getArticleId() {
		return articleId;
	}
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", comContent=" + comContent + ", comTime=" + comTime + ", comName="
				+ comName + ", articleId=" + articleId + "]";
	}
	
	
}
