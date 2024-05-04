package model;



public class Videodepot {
	private String videoID;
	private String description;
	private String video;
	private Packages packagesFK;
	
	public Videodepot(String videoID, String description, String video, Packages packagesFK) {
		super();
		this.videoID = videoID;
		this.description = description;
		this.video = video;
		this.packagesFK = packagesFK;
	}

	
	public Videodepot(String videoID) {
		super();
		this.videoID = videoID;
	}


	public Videodepot(String videoID, String description, String video) {
		super();
		this.videoID = videoID;
		this.description = description;
		this.video = video;
	}


	public Videodepot() {
		super();
	}

	
	public String getVideoID() {
		return videoID;
	}

	public void setVideoID(String videoID) {
		this.videoID = videoID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public Packages getPackagesFK() {
		return packagesFK;
	}

	public void setPackagesFK(Packages packagesFK) {
		this.packagesFK = packagesFK;
	}

	@Override
	public String toString() {
		return "Videodepot [videoID=" + videoID + ", description=" + description + ", video=" + video + ", packagesFK="
				+ packagesFK + "]";
	}
	
	
}
